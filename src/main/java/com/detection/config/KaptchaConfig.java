package com.detection.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

import static com.google.code.kaptcha.Constants.*;

/**
 * @Author ding
 * @Date 2021/12/9
 */
@Configuration
public class KaptchaConfig {

    @Bean
    public DefaultKaptcha getDDefaultKaptcha() {
        DefaultKaptcha dk = new DefaultKaptcha();
        Properties properties = new Properties();
        // 图片边框
        properties.setProperty(KAPTCHA_BORDER, "no");
        // 边框颜色
        properties.setProperty(KAPTCHA_BORDER_COLOR, "105,179,90");
        // 字体颜色
        properties.setProperty(KAPTCHA_TEXTPRODUCER_FONT_COLOR, "red");
        // 图片宽
        properties.setProperty(KAPTCHA_IMAGE_WIDTH, "110");
        // 图片高
        properties.setProperty(KAPTCHA_IMAGE_HEIGHT, "40");
        // 字体大小
        properties.setProperty(KAPTCHA_TEXTPRODUCER_FONT_SIZE, "30");
        // session key
        properties.setProperty(KAPTCHA_SESSION_KEY, "code");
        // 验证码长度
        properties.setProperty(KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "4");
        // 字体
        properties.setProperty(KAPTCHA_TEXTPRODUCER_FONT_NAMES, "Arial,Courier");
        Config config = new Config(properties);
        dk.setConfig(config);

        return dk;
    }
}
