package com.petproject.carrental.exeptions;

import org.springframework.http.HttpStatus;

public class AppExeption extends RuntimeException {

    private final HttpStatus code;

    public AppExeption(String message, HttpStatus code) {
        super(message);
        this.code = code;
    }

    public HttpStatus getCode() {
        return code;
    }
}
