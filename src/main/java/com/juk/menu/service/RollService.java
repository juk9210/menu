package com.juk.menu.service;

import com.juk.menu.model.Roll;
import com.juk.menu.repository.SetRepository;
import com.juk.menu.repository.RollRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Создаём класс-сервис, в котором будем описывать уже основную логику и работать не напрямую с сущностями, а с
 * репозиториями
 *
 * @author Shakhov Yevhen
 */

@Service   //помечеам класс что он будет сервисом.
public class RollService {
    /*
    Создаём поля RollRepository и SetRepository чтобы можно было работать с ними в нашем сервисе. И делаем их
     final для того чтобы нельзя было их изменять.
     */
    private final RollRepository rollRepository;
    private final SetRepository setRepository;

    /**
     * Создаём конструктор с нашими полями
     *
     * @param rollRepository
     * @param setRepository
     */
    public RollService(RollRepository rollRepository, SetRepository setRepository) {
        this.rollRepository = rollRepository;
        this.setRepository = setRepository;
    }

    /**
     * Создаём метод findByOrderByWeightAsc через который будем фильтровать роллы по возрастанию веса
     *
     * @return
     */
    public List<Roll> findByOrderByWeightAsc() {
        return rollRepository.findByOrderByWeightAsc();
    }

    /**
     * Создаём метод findByOrderByWeightDesc через который будем фильтровать роллы по убыванию веса
     *
     * @return
     */
    public List<Roll> findByOrderByWeightDesc() {
        return rollRepository.findByOrderByWeightDesc();
    }

    /**
     * Создаём метод findByOrderByPriceAsc через который будем фильтровать роллы по возрастанию цен
     *
     * @return
     */
    public List<Roll> findByOrderByPriceAsc() {
        return rollRepository.findByOrderByPriceAsc();
    }

    /**
     * Создаём метод findByOrderByPriceDesc через который будем фильтровать роллы по убыванию цен
     *
     * @return
     */
    public List<Roll> findByOrderByPriceDesc() {
        return rollRepository.findByOrderByPriceDesc();
    }

    /**
     * Создаём метод findByTypeOfRoll через который будем искать роллы по их типу.
     *
     * @param typeOfRoll
     * @return
     */
    public List<Roll> findByTypeOfRoll(String typeOfRoll) {
        return rollRepository.findByTypeOfRoll( typeOfRoll );
    }
}
