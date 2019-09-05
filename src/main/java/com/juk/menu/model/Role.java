package com.juk.menu.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Создаём класс Role,который будет нашей таблицей в БД,в которой будут хранится названия наших ролей пользователей
 *
 * @author Shakhov Yevhen
 */
@Data  //генерирует сразу такие реализации toString, EqualsAndHashCode,Getter / @Setter,RequiredArgsConstructor
@NoArgsConstructor //создаёт конструктор класса без параметров
@Table  //привязка сущности к определенной таблице
@Entity  //аннотация для превращения класса в сущность
public class Role implements Serializable {
    /*
 Создаём поля класса,которые в будущем будут нашими колонками в таблице
  */
    @Id  //указываем что это поле является ключем
    @GeneratedValue //итератор для значения id
    @Column(name = "role_id", nullable = false) // указываем что это поле будет нашей колонкой в таблице и оно не может
    // быть пустым.
    private Long roleId;

    @Column(name = "role_name", unique = true, length = 30, nullable = false)// указываем что это поле будет нашей
    // колонкой в таблице и оно не может  быть пустым и оно уникально по названию и его длину.
    private String roleName;
}
