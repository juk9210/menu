package com.juk.menu.service;

import com.juk.menu.model.AppRole;
import com.juk.menu.model.AppUser;
import com.juk.menu.repository.RoleRepository;
import com.juk.menu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public AppUser findByUserName(String userName){
        return userRepository.findByUserName( userName );
    }
    @Override
    public void save(AppUser appUser) {
        appUser.setUserName( appUser.getUserName() );
        appUser.setEncryptedPassword( bCryptPasswordEncoder.encode( appUser.getEncryptedPassword() ) );
        appUser.setEnabled( true );
        appUser.setRole();
        userRepository.save( appUser );
    }
}
