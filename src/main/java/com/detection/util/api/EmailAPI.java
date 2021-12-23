package com.detection.util.api;

import com.detection.entity.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * @Author ding
 * @Date 2021/12/18
 */
public class EmailAPI {


    /**
     *邮件发送
     * */
    public static void getEmail(Email m) throws EmailException {

        //创建一个HtmlEmail实例对象
        HtmlEmail email=new HtmlEmail();
        email.setHostName("smtp.qq.com");
        email.setCharset("utf-8");
        email.addTo(m.getReceiver());
        email.setFrom(m.getAddresser(),m.getAddresserName());
        email.setAuthentication(m.getAddresser(),m.getCode());
        email.setSubject(m.getSubject());
        email.setMsg(m.getMsg());
        email.send();

    }
}
