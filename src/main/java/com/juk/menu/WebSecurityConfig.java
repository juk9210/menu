package com.juk.menu;

import com.juk.menu.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Создаём класс WebSecurityConfig для настроек нашей безопасности
 *
 * @author Shakhov Yevhen
 */

@Configuration  //указываем что класс является конфигурацией
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * Создаём поле UserServiceImpl для автосвязывания с WebSecurityConfig
     */
    @Autowired
    private UserDetailsServiceImpl userService;

    /**
     * Создаём бин
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     *
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService( userService ).passwordEncoder( passwordEncoder() );
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        //доступно для всех
        http.authorizeRequests().antMatchers( "/", "welcome", "/sign_in", "/menu", "/menu/sort/by_type",
                "/menu/sort/by_weight/up", "/menu/sort/by_weight/down", "/menu/sort/by_price/up",
                "/menu/sort/by_price/down" ).permitAll();
        //доступно для админа и пользователя
        http.authorizeRequests().antMatchers( "/sign_out", "/new_roll", "/add_roll", "/edit/{id}",
                "/update/{id}", "/delete/{id}" ).access( "hasAnyRole('ROLE_USER','ROLE_ADMIN')" );
        //доступно только для админа
        http.authorizeRequests().antMatchers( "/add_user" ).access( "hasRole('ROLE_ADMIN')" );
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
