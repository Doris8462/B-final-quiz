package com.example.demo.exception;

public enum ExceptionEnum {

    USER_NOT_EXIST("NOT FOUND","用户不存在"),
    ADD_USER_EXCEPTION("SERVER ERROR", "添加失败"),
    REQUEST_PARAMETER_NOT_MATCH("CLIENT ERROR", "参数不合规"),
    DIVIDE_GROUP_EXCEPTION("SERVER ERROR", "分组失败");

    private String error;
    private String message;


    ExceptionEnum(String error, String message) {
        this.error = error;
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
