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
@Data
@NoArgsConstructor
@Table(name = "app_role")
@Entity
public class AppRole implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer roleId;

    @Column
    private String name;

}
