package com.detection.entity;



import javax.xml.crypto.Data;

/**
 * @author ding
 * @date 2021/12/8
 */
public class User{

   private Long  id;
   private String  account;
   private String  password;
   private Long  phone;
   private String  email;
   private String  tencentAccount;
   private Integer tencentType;
   private String  tencentName;
   private String  accountName;
   private char  sex;
   private Data birthday;
   private String  address;
   private String  province;
   private String  town;
   private String  county;
   private String  imgUrl;
   private Integer  status;
   private Integer  types;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTencentAccount() {
        return tencentAccount;
    }

    public void setTencentAccount(String tencentAccount) {
        this.tencentAccount = tencentAccount;
    }

    public Integer getTencentType() {
        return tencentType;
    }

    public void setTencentType(Integer tencentType) {
        this.tencentType = tencentType;
    }

    public String getTencentName() {
        return tencentName;
    }

    public void setTencentName(String tencentName) {
        this.tencentName = tencentName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getTypes() {
        return types;
    }

    public void setTypes(Integer types) {
        this.types = types;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Data getBirthday() {
        return birthday;
    }

    public void setBirthday(Data birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
