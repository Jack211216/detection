package com.detection.controller;

import com.detection.util.*;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.sun.org.apache.bcel.internal.classfile.Code;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.util.Map;

/**
 * @Author ding
 * @Date 2021/12/9
 */
@Controller
@RequestMapping("kaptcha")
@Slf4j
public class KaptchaController {

    /**
     * 验证码工具
     */
    @Autowired
    DefaultKaptcha defaultKaptcha;

    /**
     * 生成验证码：方案一
     */
    @PostMapping("/captchaImageOne")
    public void defaultKaptch(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            // 将生成的验证码保存在session中
            String createText = defaultKaptcha.createText();
            request.getSession().setAttribute("rightCode", createText);
            BufferedImage bi = defaultKaptcha.createImage(createText);
            ImageIO.write(bi, "jpg", out);
            getOutPut(response,out);
        } catch (Exception e) {
            e.printStackTrace();

        }finally {
            out.close();
        }

    }

    /**
     * 生成验证码：方案二
     */
    @PostMapping("/captchaImageTwo")
    public void getCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
        // 生成随机字串
        String verifyCode = CodeUtil.generateVerifyCode(4);

        // 生成图片
        int w = 111, h = 45;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        CodeUtil.outputImage(w, h, stream, verifyCode);
        try {
            request.getSession().setAttribute("verificationCode",verifyCode);
            getOutPut(response,stream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stream.close();
        }

    }

    /**
     * 生成验证码：方案三
     */
    @PostMapping("/captchaImageThree")
    public void getCodes(HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map = CodeUtil.generateCodeAndPic();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        request.getSession().setAttribute("verificationCode",map.get("code").toString());

        try {
            ImageIO.write((RenderedImage) map.get("codePic"), "jpeg", out);
            getOutPut(response,out);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    private ServletOutputStream getOutPut(HttpServletResponse response,ByteArrayOutputStream stream) {
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream sout = null;
        try {
            sout = response.getOutputStream();
            sout.write(stream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                sout.flush();
                sout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sout;
    }
}
