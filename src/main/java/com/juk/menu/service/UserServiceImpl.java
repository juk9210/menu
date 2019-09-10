package com.juk.menu.service;

import com.juk.menu.model.AppUser;
import com.juk.menu.repository.AppUserRepository;
import com.juk.menu.repository.UserRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Создаём класс-сервис, в котором будем описывать уже основную логику и работать не напрямую с сущностями, а с
 * репозиториями
 *
 * @author Shakhov Yevhen
 */
@Service  //помечеам класс что он будет сервисом.
@Slf4j
public class UserServiceImpl implements UserDetailsService {
    /**
     * Создаем поля AppUserRepository и UserRoleRepository для автосвязывания с сервисом
     */
    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Переопределяем метод loadUserByUsername для загрузки роли пользователя по его имени
     *
     * @param userName
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = this.appUserRepository.findUserAccount( userName )
                .orElseThrow( RuntimeException::new );

        if (appUser == null) {
            log.error( "User not found! " + userName );
            throw new UsernameNotFoundException( "User " + userName + " was not found in the database" );
        }

        log.info( "Found User: " + appUser );

        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = this.userRoleRepository.getRoleNames( appUser.getUserId() );

        List<GrantedAuthority> grantList = new ArrayList<>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority( role );
                grantList.add( authority );
            }
        }

        return new User( appUser.getUserName(), appUser.getEncryptedPassword(), grantList );
    }

//    public void save(AppUser appUser) {
//        appUser.setEncryptedPassword( bCryptPasswordEncoder.encode( appUser.getEncryptedPassword() ) );
//
//        appUserRepository.save( appUser );
//    }
}
