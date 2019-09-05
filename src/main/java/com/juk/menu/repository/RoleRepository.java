package com.juk.menu.repository;

import com.juk.menu.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Создаём интерфейс RoleRepository для взаимодействия с БД и Spring Data.Этот репозиторий будет с классом-сущностью
 * Role
 *
 * @author Shakhov Yevhen
 */

@Repository  //указываем что это репозиторий для спринга
@Transactional // помечаем класс для транзакций
public interface RoleRepository extends JpaRepository<Role, Long> {

}
