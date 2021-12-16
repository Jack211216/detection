package com.detection.entity;

/**
 * @author ding
 * @date 2021/12/8
 */
public class Login extends Pager{

    private String account;

    private String password;

    private String phone;

    private String email;

    private String tryCode;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTryCode() {
        return tryCode;
    }

    public void setTryCode(String tryCode) {
        this.tryCode = tryCode;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
