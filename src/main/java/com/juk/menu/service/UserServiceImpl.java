package com.juk.menu.service;

import com.juk.menu.model.AppUser;
import com.juk.menu.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserServiceImpl implements UserService {
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(AppUser appUser) {
        appUser.setEncryptedPassword( bCryptPasswordEncoder.encode( appUser.getEncryptedPassword() ) );
        appUser.setEnabled( true );
        appUserRepository.save( appUser );
    }
}
