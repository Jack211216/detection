package com.detection.controller;

import com.detection.entity.Email;
import com.detection.entity.Login;

import com.detection.entity.SharedParam;
import com.detection.entity.User;
import com.detection.exception.entity.MyException;
import com.detection.service.LoginService;

import com.detection.service.UserService;
import com.detection.util.*;
import com.detection.common.Result;
import com.detection.util.api.EmailAPI;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.EmailException;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;


/**
 * @Author ding
 * @Date 2021/12/7
 */

@RestController
@RequestMapping("/person")
@Slf4j
public class loginController  {

    @Autowired
    private LoginService loginService;
    
    @Value("${token.secret}")
    private  String SECRET;

    @Value("${token.header}")
    private  String HEADER;


    /**
    *@Describe :登录
    *@param login:账号&密码
    *@Date :2021/12/9 14:18
    */
    @PostMapping("login")
    public Result login(@RequestBody Login login, HttpServletRequest request){
        HashMap<String,Object> map = null;
      try {
          map = loginService.queryUser(login);

          String rightCode = request.getSession().getAttribute("verificationCode") == null ? "" : (String) request.getSession().getAttribute("verificationCode");
          log.info("rightCode:" + rightCode + " ———— tryCode:" + login.getTryCode());
          boolean pwdFlag = UtilMD5.validPassword(login.getPassword(), map.get("password").toString());
          if(!pwdFlag){
              return Result.error(HttpStatus.BAD_REQUEST,"账号或密码错误");
          }else if (!rightCode.equals(login.getTryCode())) {
              return Result.error(HttpStatus.BAD_REQUEST,"验证码错误,请再输一次!");
          }
      } catch (NoSuchAlgorithmException e) {
          e.printStackTrace();
      } catch (UnsupportedEncodingException e) {
          throw new MyException("解密异常");
      } catch (NullPointerException e){
          throw new MyException("账号不存在");
      }

      String token = TokenUtil.getToken(map.get("id").toString(), SECRET+map.get("password").toString());
      request.getSession().setAttribute(HEADER,token);
      map.clear();
      map.put("token",token);
      return Result.success(map);
    }

    /**
     * @Describe: 注册
     * @param user: 用户参数
     * @Date:2021/12/9 14:22
     */
    @PostMapping("reg")
    public Result register(@RequestBody User user){

        Login param=new Login();
        param.setAccount(user.getAccount());
        try {
            HashMap<String, Object> users = loginService.queryUser(param);
            HashMap<String, Object>  map= ( users==null || users.size() == 0 )? null : users;
            if(StringUtils.isNull(map)) {
                String encryptedPwd = UtilMD5.getEncryptedPwd(user.getPassword());
                user.setPassword(encryptedPwd);
                loginService.insertUser(user);
                log.info(encryptedPwd);
                log.info(String.valueOf(encryptedPwd.length()));
            }else if(StringUtils.isNotNull(map) && map.get("phone").equals(user.getPhone())){
                return Result.error(HttpStatus.NOT_MODIFIED,"手机号已注册！");
            }else {
                return Result.error(HttpStatus.NOT_MODIFIED,"账户已存在！");
            }
        } catch (NoSuchAlgorithmException e) {
           e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            throw new MyException("加密异常");
        }
        return Result.success();
    }

    /**
     * 邮箱验证
     * */
    @PostMapping("email")
    public Result email(@RequestBody Email email){

        String path=StringUtils.isNotEmpty(email.getFilePath())==true ? email.getFilePath():"C:/key.txt";
        Properties uerKey = PropertiesUtil.getUerKey(path);
        email.setFilePath(path);

        try {
            email.setCode(uerKey.getProperty("EMAIL_KEY"));
            EmailAPI.getEmail(email);
        } catch (EmailException e) {
            e.printStackTrace();
            throw new MyException("邮件发送失败");
        } catch (NullPointerException e){
            throw new MyException("读取的key值为空");
        }
        return  Result.success();
    }
}
