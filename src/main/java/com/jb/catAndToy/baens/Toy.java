package com.jb.catAndToy.baens;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/*

Hila Gannot
11/8/2022 11:20

*/

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "toys")
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 40, nullable = false)
    private String name;

    @ManyToOne
    @ToString.Exclude
    private Cat cat;
    public Toy(String name) {
        this.name = name;
    }
}
