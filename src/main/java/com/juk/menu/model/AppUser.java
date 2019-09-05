package com.juk.menu.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Создаём класс Role,который будет нашей таблицей в БД, в котором будут хранится имена наших пользователей с паролями
 * и привязкой к роли пользователя
 *
 * @author Shakhov Yevhen
 */
@Data  //генерирует сразу такие реализации toString, EqualsAndHashCode,Getter / @Setter,RequiredArgsConstructor
@NoArgsConstructor  //создаёт конструктор класса без параметров
@Table(name = "app_user")  //привязка сущности к определенной таблице
@Entity   //аннотация для превращения класса в сущность
public class AppUser implements Serializable {
    /*
Создаём поля класса,которые в будущем будут нашими колонками в таблице
 */
    @Id   //указываем что это поле является ключем
    @GeneratedValue  //итератор для значения id
    @Column(name = "user_id", nullable = false) // указываем что это поле будет нашей колонкой в таблице и оно не может
    // быть пустым.
    private Long userId;

    @Column(unique = true, length = 36, nullable = false)// указываем что это поле будет нашей
    // колонкой в таблице и оно не может  быть пустым и оно уникально по названию и его длину.
    private String userName;

    @Column(length = 128, nullable = false)// указываем что это поле будет нашей
    // колонкой в таблице и оно не может  быть пустым  и его длину.
    private String encryptedPassword;

    @Column(length = 1, nullable = false)// указываем что это поле будет нашей
    // колонкой в таблице и оно не может  быть пустым  и его длину.
    private boolean enabled;


}
