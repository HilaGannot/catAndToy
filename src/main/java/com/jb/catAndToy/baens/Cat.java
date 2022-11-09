package com.jb.catAndToy.baens;
/*

Hila Gannot
11/8/2022 11:20

*/

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "cats")
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 40, nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private COLOR color;
    private double weight;
    private Date birthday;
    @OneToMany(mappedBy = "cat",cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @Singular
    private List<Toy> toys;
}
