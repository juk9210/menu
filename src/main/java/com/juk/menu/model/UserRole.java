package com.juk.menu.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Создаём класс Role,который будет нашей таблицей в БД, в котором будут отображена связь между пользователем и
 * ролью пользователя
 *
 * @author Shakhov Yevhen
 */
@Data  //генерирует сразу такие реализации toString, EqualsAndHashCode,Getter / @Setter,RequiredArgsConstructor
@NoArgsConstructor  //создаёт конструктор класса без параметров
@Table(name = "user_role")   //привязка сущности к определенной таблице
@Entity     //аннотация для превращения класса в сущность
public class UserRole implements Serializable {
    /*
Создаём поля класса,которые в будущем будут нашими колонками в таблице
*/
    @Id   //указываем что это поле является ключем
    @GeneratedValue  //итератор для значения id
    @Column(name = "id", nullable = false)  // указываем что это поле будет нашей колонкой в таблице и оно не может
    // быть пустым.
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) //указываем что будет связь многие к одному с таблицей AppUser.
    @JoinColumn(nullable = false) // указываем что это поле будет нашей колонкой в таблице и оно не может
    // быть пустым.
    private AppUser appUser;

    @ManyToOne(fetch = FetchType.LAZY) //указываем что будет связь многие к одному с таблицей AppUser.
    @JoinColumn(nullable = false)// указываем что это поле будет нашей колонкой в таблице и оно не может
    // быть пустым.
    private Role role;
}
