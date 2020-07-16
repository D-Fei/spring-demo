package com.boss.learning.springerr.common;

public enum MyExceptionCode implements IMyException{
    UNKNOW_EXCEPTION(-1, "未知错误"),
    USER_AGE_SCOPE_EXCEPTION(2001,"用户年龄范围超出异常"),
    USER_NAME_EXCEPTION(2002, "用户名字包含非法字符");

    private int code;
    private String msg;


    private MyExceptionCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }
}
