package com.juk.menu.repository;

import com.juk.menu.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Создаём интерфейс UserRoleRepository для взаимодействия с БД и Spring Data.Этот репозиторий будет с классом-сущностью
 * UserRole
 *
 * @author Shakhov Yevhen
 */

@Repository      //указываем что это репозиторий для спринга
@Transactional   // помечаем класс для транзакций
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    /**
     * Создаём метод getRoleNames, с помощью которого в дальнейшем будем получать имя ролей по id.
     *
     * @param userId
     * @return
     */
    @Query("Select ur.role.roleName from UserRole ur where ur.appUser.userId = ?1")
    List<String> getRoleNames(Long userId);
}
