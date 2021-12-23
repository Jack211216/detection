package com.detection.exception.entity;

/**
 * @author ding
 * @date 2021/12/8
 */
public class MyException extends RuntimeException {

    private int code;  //异常状态码

    private String message;  //异常信息

    private String descInfo;   //描述

    private  Object[] objs;

    public MyException() {
    }

    public MyException(String message) {
        this.message = message;
    }

    public MyException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public MyException(int code, String message, String descInfo) {
        this.code = code;
        this.message = message;
        this.descInfo = descInfo;
    }

    public MyException(Object ... obj) {

        this.objs = obj;

    }

    public Object[] getObjs() {
        return objs;
    }

    public void setObjs(Object[] objs) {
        this.objs = objs;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescInfo() {
        return descInfo;
    }

    public void setDescInfo(String descInfo) {
        this.descInfo = descInfo;
    }
}
