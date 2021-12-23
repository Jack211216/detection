package com.detection.entity;

import java.util.Date;

/**
 * @Author ding
 * @Date 2021/12/22
 */
public class DBLog {

    private Long id;

    private String operPerson;
    
    private String operAccount;
    
    private String filePath;
    
    private Date operTime;

    private String remark;

    private String state;


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public String getOperPerson() {
        return operPerson;
    }

    public void setOperPerson(String operPerson) {
        this.operPerson = operPerson;
    }

    public String getOperAccount() {
        return operAccount;
    }

    public void setOperAccount(String operAccount) {
        this.operAccount = operAccount;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getOperTime() {
        return operTime;
    }


}
