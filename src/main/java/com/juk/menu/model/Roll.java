package com.juk.menu.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Создаём класс Roll,который будет нашей таблицей в БД.
 *
 * @author Shakhov Yevhen
 */

@Entity            //аннотация для превращения класса в сущность
@Table(name = "roll")   //привязка сущности к определенной таблице
@Data    //генерирует сразу такие реализации toString, EqualsAndHashCode,Getter / @Setter,RequiredArgsConstructor
@NoArgsConstructor     //создаёт конструктор класса без параметров
public class Roll implements Serializable {
    /*
    Создаём поля класса,которые в будущем будут нашими колонками в таблице
     */
    @Id   //указываем что это поле является ключем
    @GeneratedValue(strategy = GenerationType.AUTO)    //итератор для значения id
    private long id;

    @Column(unique = true, nullable = false) // указываем что это поле будет нашей колонкой в табдице и оно не может
    // быть пустым и оно уникально по названию.
    private String name;


    @Column     // указываем что это поле будет нашей колонкой в табдице
    private String typeOfRoll;

    @Column(length = 3) // указываем что это поле будет нашей колонкой в табдице и указываем длину
    private Integer weight;

    @Column(name = "calorie_content", length = 10)
    //указываем что это поле будет нашей колонкой в табдице и указываем длину
    private Integer calorieContent;

    @Column    // указываем что это поле будет нашей колонкой в табдице
    private String composition;

    @Column(length = 3)  // указываем что это поле будет нашей колонкой в табдице и указываем длину
    private Integer price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Set set;

}
