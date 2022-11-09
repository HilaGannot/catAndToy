package com.jb.catAndToy.exception;
/*

Hila Gannot
11/8/2022 1:57

*/

public enum ErrMsg {
    ID_NOT_FOUND("id not found"),
    ID_ALREADY_EXIST("id exist"),
    WEIGHT_MUST_BR_MORE_THAN_ZERO("more that 0");

    private String message;

    ErrMsg(String message) {
        this.message = message;
    }
}
