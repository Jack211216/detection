package com.detection.emun;

/**
 * @author ding
 * @date 2021/12/7
 */
public enum gender {
    man("男",1),woman("女",2);
    //成员变量
    private String sex;
    private Integer type;
    //构造方法
    private gender(String sex,Integer type)
    {
        this.sex=sex;
        this.type=type;
    }
}
