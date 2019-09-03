package com.juk.menu.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "roll")
@Data
@NoArgsConstructor
public class Roll implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false)
    private String name;


    @Column
    private String typeOfRoll;

    @Column(length = 3)
    private Integer weight;

    @Column(name = "calorie_content", length = 10)
    private Integer calorieContent;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roll")
//    @JoinColumn(name = "composition_name", nullable = false)
//    @Column
    private Set<Composition> compositions = new HashSet<>(  );

    @Column(length = 3)
    private Integer price;


}
