package com.juk.menu.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Создаём класс Set,который будет нашей таблицей в БД.
 *
 * @author Shakhov Yevhen
 */

@Entity  //аннотация для превращения класса в сущность
@Data   //генерирует сразу такие реализации toString, EqualsAndHashCode,Getter / @Setter,RequiredArgsConstructor
@Table   //привязка сущности к определенной таблице
@NoArgsConstructor   //создаёт конструктор класса без параметров
public class Set implements Serializable {
    /*
    Создаём поля класса,которые в будущем будут нашими колонками в таблице
     */
    @Id  //указываем что это поле является ключем
    @GeneratedValue(strategy = GenerationType.AUTO)  //итератор для значения id
    private Long id;


    @Column(unique = true, nullable = false) // указываем что это поле будет нашей колонкой в табдице и оно не может
    // быть пустым и оно уникально по названию.
    private String name;


}
