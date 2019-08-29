package com.juk.menu.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class Roll implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(name = "type_of_roll", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeOfRollEnum typeOfRoll;

    @Column(length = 3)
    private Integer weight;

    @Column(name = "calorie_content", length = 10)
    private Integer calorieContent;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "composition_id", nullable = false)
    private List<Composition> composition;

    @Column(length = 3)
    private Integer price;


}
