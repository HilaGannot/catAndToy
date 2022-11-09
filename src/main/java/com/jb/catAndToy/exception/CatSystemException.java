package com.jb.catAndToy.exception;
/*

Hila Gannot
11/8/2022 1:56

*/

public class CatSystemException extends Exception{

    private String msg;

    public CatSystemException(ErrMsg msg) {
        super(msg.name());
        this.msg = msg.name();
    }
}
