package com.juk.menu;

import com.juk.menu.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserServiceImpl userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService( userService ).passwordEncoder( passwordEncoder() );
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        //доступно для всех
        http.authorizeRequests().antMatchers( "/", "/sign_in", "/sign_out" ).permitAll();
        //доступно для админа и пользователя
        http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
        //доступно только для админа
        http.authorizeRequests().antMatchers( "/admin" ).access( "hasRole('ROLE_ADMIN')" );
        // если нет прав (роли) для доступа к странице
        // будет брошено AccessDeniedException.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage( "/403" );
        //конфигурация для формы входа(sign in страница)
        http.authorizeRequests().and().formLogin()
                .loginProcessingUrl( "/j_spring_security_check" )
                .loginPage( "/sign_in" )
                .defaultSuccessUrl( "/" )
                .failureUrl( "/sign_in?error=true" )
                .usernameParameter( "username" )
                .passwordParameter( "password" )
                //конфиг для выхода
                .and().logout().logoutUrl( "/sign_out" ).logoutSuccessUrl( "/sign_in" );

    }
}
