package com.juk.menu.repository;


import com.juk.menu.model.Roll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Создаём интерфейс RollRepository для взаимодействия с БД и Spring Data.Этот репозиторий будет с классом-сущностью
 * Roll
 *
 * @author Shakhov Yevhen
 */


@Repository    //указываем что это репозиторий для спринга
public interface RollRepository extends JpaRepository<Roll, Long> {
    /**
     * Создаём метод findByOrderByWeightAsc, с помощью которого в дальнейшем будем фильтровать роллы по возрастанию веса
     *
     * @return
     */

    List<Roll> findByOrderByWeightAsc();

    /**
     * Создаём метод findByOrderByWeightDesc, с помощью которого в дальнейшем будем фильтровать роллы по убыванию веса
     *
     * @return
     */

    List<Roll> findByOrderByWeightDesc();

    /**
     * Создаём метод findByOrderByPriceAsc, с помощью которого в дальнейшем будем фильтровать роллы по возрастанию цен
     *
     * @return
     */

    List<Roll> findByOrderByPriceAsc();

    /**
     * Создаём метод findByOrderByWeightDesc, с помощью которого в дальнейшем будем фильтровать роллы по убыванию цена
     *
     * @return
     */

    List<Roll> findByOrderByPriceDesc();

    /**
     * Создаём метода findByTypeOfRoll, с помощью которого в дальнеёшем будем искать роллы по их типу
     *
     * @param typeOfRoll
     * @return
     */

    List<Roll> findByTypeOfRoll(String typeOfRoll);

}
