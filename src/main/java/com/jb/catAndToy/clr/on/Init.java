package com.jb.catAndToy.clr.on;

import com.jb.catAndToy.baens.COLOR;
import com.jb.catAndToy.baens.Cat;
import com.jb.catAndToy.baens.Toy;
import com.jb.catAndToy.repos.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/*

Hila Gannot
11/8/2022 11:54

*/
@Component
@Order(1)
public class Init implements CommandLineRunner {
    @Autowired
    private CatRepository catRepository;

    @Override
    public void run(String... args) throws Exception {

        Toy t1 = new Toy("tennis");
        Toy t2 = new Toy("tetris");
        Toy t3 = new Toy("nintendo");
        Toy t4 = new Toy("playstation");

        Cat cat1 = Cat.builder()
                .name("malech")
                .birthday(Date.valueOf(LocalDate.now().minusYears(3)))
                .color(COLOR.BLACK)
                .toys(List.of(t1, t2))
                .weight(3.7)
                .build();

        Cat cat2 = Cat.builder()
                .name("ruth")
                .birthday(Date.valueOf(LocalDate.now().minusYears(5)))
                .color(COLOR.BLUE)
                .weight(8.8)
                .toys(List.of(t3, t4))
                .build();

        t1.setCat(cat1);
        t2.setCat(cat1);
        t3.setCat(cat2);
        t4.setCat(cat2);

        catRepository.save(cat1);
        catRepository.save(cat2);

        catRepository.findAll().forEach(System.out::println);
    }
}
