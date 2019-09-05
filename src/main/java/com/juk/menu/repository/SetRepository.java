package com.juk.menu.repository;

import com.juk.menu.model.Set;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Создаём интерфейс SetRepository для взаимодействия с БД и Spring Data.Этот репозиторий будет с классом-сущностью
 * Set
 *
 * @author Shakhov Yevhen
 */

@Repository  //указываем что это репозиторий для спринга
public interface SetRepository extends CrudRepository<Set, Long> {

}
