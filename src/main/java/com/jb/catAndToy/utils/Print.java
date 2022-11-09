package com.jb.catAndToy.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*

Hila Gannot
11/8/2022 3:48

*/
@Component
public class Print {

    @Value("${SIZE}")
    private int SIZE;

    public void print(String txt){
        int side = (SIZE - txt.length()) / 2;
        System.out.print("@".repeat(side));
        System.out.print(txt);
        System.out.println("@".repeat(side));
    }
}
