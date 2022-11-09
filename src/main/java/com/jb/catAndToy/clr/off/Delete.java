package com.jb.catAndToy.clr.off;

import com.jb.catAndToy.repos.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*

Hila Gannot
11/8/2022 12:01

*/
@Component
@Order(3)
public class Delete implements CommandLineRunner {
    @Autowired
    private CatRepository catRepository;
    @Override
    public void run(String... args) throws Exception {
        catRepository.deleteById(1);
    }
}
