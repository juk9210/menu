package com.juk.menu;

import com.juk.menu.model.AppUser;
import com.juk.menu.model.AppRole;
import com.juk.menu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

/**
 * Делаем класс DbInitConfig для добавления начального пользователя
 *
 * @author Shakhov Yevhen
 */

@Configuration //указываем что класс является конфигурацией
public class DbInitConfig {
    /*
   Создаём поля AppUserRepository и RoleRepository,UserRoleRepository чтобы можно было работать с ними в нашем сервисе.
    И делаем их final для того чтобы нельзя было их изменять.
    */
    private final UserRepository userRepository;

    /**
     * Создаём конструктор с нашими полями
     *
     * @param
     */
    @Autowired
    public DbInitConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @EventListener //помечаем метод onApplicationEvent что онбудет запускаться вместе с приложением
    public void onApplicationEvent(ContextRefreshedEvent event) {
        AppUser apu1 = new AppUser();
        apu1.setUserId( 1L );
        apu1.setUserName( "admin" );
        apu1.setEncryptedPassword( "$2a$10$AJN2uPvuYfgLKhdZtVhKROGuk7l/Ug5.XqxNE20no9StG.mdPCTp2" );
        apu1.setEnabled( true );
        apu1.setRole();
        apu1 = userRepository.save( apu1 );
    }
}
