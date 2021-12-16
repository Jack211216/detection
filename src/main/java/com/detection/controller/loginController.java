package com.detection.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.detection.entity.Login;

import com.detection.entity.User;
import com.detection.service.UserService;

import com.detection.util.HttpStatus;
import com.detection.util.Result;
import com.detection.util.StringUtils;
import com.detection.util.UtilMD5;
import com.sun.media.jfxmedia.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;


/**
 * @Author ding
 * @Date 2021/12/7
 */

@RestController
@RequestMapping("/login")
@Slf4j
public class loginController  {

    @Autowired
    private UserService userService;

    /**
    *@Describe :登录
    *@param login:账号&密码
    *@Date :2021/12/9 14:18
    */
    @PostMapping("log")
    public Result login(@RequestBody Login login, HttpServletRequest request){
      try {
          User user = userService.queryUser(login);
          String rightCode = request.getSession().getAttribute("verificationCode") == null ? "" : (String) request.getSession().getAttribute("verificationCode");

          log.info("rightCode:" + rightCode + " ———— tryCode:" + login.getTryCode());
          boolean pwdFlag = UtilMD5.validPassword(login.getPassword(), user.getPassword());
          if(!pwdFlag){
              return Result.error(HttpStatus.BAD_REQUEST,"账号或密码错误");
          }else if (!rightCode.equals(login.getTryCode())) {
              return Result.error(HttpStatus.BAD_REQUEST,"验证码错误,请再输一次!");
          }
      } catch (NoSuchAlgorithmException e) {
          e.printStackTrace();
      } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
      }
      return Result.success();
    }

    /**
     * @Describe: 注册
     * @param user: 用户参数
     * @Date:2021/12/9 14:22
     */
    @PostMapping("reg")
    public Result register(@RequestBody User user){
        Login login=new Login();
        login.setAccount(user.getAccount());
        try {
            User admin = userService.queryUser(login);
            if(StringUtils.isNull(admin)) {
                String encryptedPwd = UtilMD5.getEncryptedPwd(user.getPassword());
                user.setPassword(encryptedPwd);
                userService.insertUser(user);
                log.info(encryptedPwd);
                log.info(String.valueOf(encryptedPwd.length()));
            }else if(!StringUtils.isNull(admin) && admin.getPhone().equals(user.getPhone())){
                return Result.error(HttpStatus.NOT_MODIFIED,"手机号已注册！");
            }else {
                return Result.error(HttpStatus.NOT_MODIFIED,"账户已存在！");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return Result.success();
    }


}
