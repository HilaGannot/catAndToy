package com.jb.catAndToy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jb.catAndToy"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ,
                pattern = "com.jb.catAndToy.clr.off.*"))
public class CatAndToyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatAndToyApplication.class, args);
    }

}
