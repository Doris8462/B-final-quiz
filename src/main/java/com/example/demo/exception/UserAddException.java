package com.example.demo.exception;

public class UserAddException extends RuntimeException {
    private ExceptionEnum exceptionEnum;

    public UserAddException(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }
}
