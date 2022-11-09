package com.jb.catAndToy.clr.on;
/*

Hila Gannot
11/8/2022 11:56

*/

import com.jb.catAndToy.baens.Cat;
import com.jb.catAndToy.repos.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class Update implements CommandLineRunner {

    @Autowired
    private CatRepository catRepository;

    @Override
    public void run(String... args) throws Exception {
        Cat toUpdate = catRepository.findById(1).orElseThrow();
        toUpdate.getToys().get(0).setName("ches");
        catRepository.findAll().forEach(System.out::println);
    }
}
