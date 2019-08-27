package com.juk.menu;

import com.juk.menu.model.AppUser;
import com.juk.menu.model.Role;
import com.juk.menu.model.UserRole;
import com.juk.menu.repository.AppUserRepository;
import com.juk.menu.repository.RoleRepository;
import com.juk.menu.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@Configuration
public class DbInitConfig {
    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public DbInitConfig(AppUserRepository appUserRepository, RoleRepository roleRepository, UserRoleRepository userRoleRepository) {
        this.appUserRepository = appUserRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        AppUser apu1 = new AppUser();
        apu1.setUserId( 1L );
        apu1.setUserName( "admin" );
        apu1.setEncryptedPassword( "$2a$10$AJN2uPvuYfgLKhdZtVhKROGuk7l/Ug5.XqxNE20no9StG.mdPCTp2" );
        apu1.setEnabled( true );
        apu1 = appUserRepository.save( apu1 );

        Role r1 = new Role();
        r1.setRoleId( 1L );
        r1.setRoleName( "ROLE_ADMIN" );
        r1 = roleRepository.save( r1 );

        UserRole ur1 = new UserRole();
        ur1.setId( 1L );
        ur1.setAppUser( apu1 );
        ur1.setRole( r1 );
        userRoleRepository.save( ur1 );

    }
}
