package com.jb.catAndToy.clr.on;
/*

Hila Gannot
11/8/2022 3:59

*/

import com.jb.catAndToy.baens.COLOR;
import com.jb.catAndToy.baens.Cat;
import com.jb.catAndToy.baens.Toy;
import com.jb.catAndToy.services.CatService;
import com.jb.catAndToy.utils.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
@Order(3)
public class ServiceTest implements CommandLineRunner {
    @Autowired
    private CatService catService;

    @Autowired
    private Print print;


    @Override
    public void run(String... args) throws Exception {

        Toy t1 = new Toy("swimming");
        Toy t2 = new Toy("cycling");

        Cat cat1 = Cat.builder()
                .name("dyoni")
                .birthday(Date.valueOf(LocalDate.now().minusYears(6)))
                .color(COLOR.GRAY)
                .toys(List.of(t1, t2))
                .weight(12)
                .build();

        //ADD CAT
        print.print("ADD NEW CAT");
        catService.addCat(cat1);
        catService.getAllCats().forEach(System.out::println);

        Toy t3 = new Toy("boxing");
        Toy t4 = new Toy("shooting ");

        Cat cat2 = Cat.builder()
                .name("david")
                .birthday(Date.valueOf(LocalDate.now().minusYears(18)))
                .color(COLOR.WIGHT)
                .toys(List.of(t3, t4))
                .weight(3.5)
                .build();


        //UPDATE CAT
        print.print("UPDATE CAT");
        catService.updateCat(1, cat2);
        catService.getAllCats().forEach(System.out::println);

        //DELETE CAT
        print.print("DELETE CAT");
        catService.deleteCat(1);
        catService.getAllCats().forEach(System.out::println);

        //SINGLE CAT
        print.print("SINGLE CAT");
        catService.getSingletCat(2);

        //NAME AND WEIGHT
        print.print("NAME AND WEIGHT");
        System.out.println(catService.findByNameAndWeight("david", 3.5));


        //NAME OR WEIGHT
        print.print("NAME OR WEIGHT");
        System.out.println(catService.findByNameOrWeight("david", 8.8));

        //ORDER BY WEIGHT UP
        print.print("ORDER BY WEIGHT UP");
        System.out.println(catService.findByOrderByWeightAsc());


        //ORDER BY WEIGHT DOWN
        print.print("ORDER BY WEIGHT DOWN");
        System.out.println(catService.findByOrderByWeightDesc());

        //START WITH
        print.print("START WITH");
        System.out.println(catService.findByNameStartingWith("d"));

        //AVG
        print.print("AVG");
        System.out.println(catService.avgAllWe());
    }
}
