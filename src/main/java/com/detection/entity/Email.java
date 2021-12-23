package com.detection.entity;

/**
 * @Author ding
 * @Date 2021/12/18
 */
public class Email {

    private String receiver;

    private String addresser;

    private String code;

    private String msg;

    private String subject;

    private String filePath;

    private String addresserName;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getAddresserName() {
        return addresserName;
    }

    public void setAddresserName(String addresserName) {
        this.addresserName = addresserName;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getAddresser() {
        return addresser;
    }

    public void setAddresser(String addresser) {
        this.addresser = addresser;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
