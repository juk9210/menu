package com.juk.menu.repository;

import com.juk.menu.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Создаём интерфейс AppUserRepository для взаимодействия с БД и Spring Data.Этот репозиторий будет с классом-сущностью
 * AppUser
 *
 * @author Shakhov Yevhen
 */

@Repository //указываем что это репозиторий для спринга
@Transactional // помечаем класс для транзакций
public interface UserRepository extends JpaRepository<AppUser, Long> {
    /**
     * Создаём метод findUserAccount с помощью которого в дальнейшем будем искать пользователя по аккаунту
     *
     * @param userName
     * @return
     */
    AppUser findByUserName(String userName);

    List<String> getRoleNames(Long userId);
}
