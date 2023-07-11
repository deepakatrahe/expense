package com.deepak.expensetrackerv1.exception;


import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {

    private Object obj;
    public BadRequestException(Object obj) {
        this.obj = obj;
    }
}
