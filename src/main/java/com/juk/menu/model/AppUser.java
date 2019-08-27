package com.juk.menu.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Table(name = "app_user")
@Entity
public class AppUser implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(unique=true, length = 36, nullable = false)
    private String userName;

    @Column(length = 128, nullable = false)
    private String encryptedPassword;

    @Column(length = 1, nullable = false)
    private boolean enabled;


}
