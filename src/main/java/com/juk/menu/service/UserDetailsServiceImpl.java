package com.juk.menu.service;


import com.juk.menu.model.AppRole;
import com.juk.menu.model.AppUser;

import com.juk.menu.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = this.userRepository.findByUserName( userName );

        if (appUser == null) {
            log.error( "User not found! " + userName );
            throw new UsernameNotFoundException( "User " + userName + " was not found in the database" );
        }

        log.info( "Found User: " + appUser );


        List<String> roleNames = this.userRepository.getRoleNames( appUser.getUserId() );

        List<GrantedAuthority> grantList = new ArrayList<>(  );
        for (String role: roleNames){
           GrantedAuthority authority =new SimpleGrantedAuthority( role );
           grantList.add( authority );
        }
        return new User( appUser.getUserName(),appUser.getEncryptedPassword(),grantList );
    }
}