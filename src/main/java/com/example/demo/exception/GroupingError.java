package com.example.demo.exception;

public class GroupingError extends RuntimeException {
    private ExceptionEnum exceptionEnum;

    public GroupingError(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }
}
