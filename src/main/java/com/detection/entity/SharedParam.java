package com.detection.entity;

import java.util.List;

/**
 * @author ding
 * @date 2021/12/8
 */
public class SharedParam {

    private String account;

    private String password;

    private List<College> colleges;


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

    public List<College> getColleges() {
        return colleges;
    }

    public void setColleges(List<College> colleges) {
        this.colleges = colleges;
    }
}
