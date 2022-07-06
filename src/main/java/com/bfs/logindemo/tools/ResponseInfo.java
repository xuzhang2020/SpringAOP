package com.bfs.logindemo.tools;


public class ResponseInfo<T> {
    public static final Integer OK = 200;
    public static final Integer WARN = 300;
    public static final Integer ERROR = 500;

    private Integer code;

    //"返回消息", dataType = "String")
    private String message = "succeed";


    private T data;

    public static Integer getOK() {
        return OK;
    }

    public static Integer getERROR() {
        return ERROR;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

