package com.juk.menu.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Table
@Entity
public class Role implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "role_id", nullable = false)
    private Long roleId;

    @Column(name = "role_name", unique=true, length = 30, nullable = false)
    private String roleName;
}
