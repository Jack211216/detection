package com.detection.config;

import com.detection.interceptor.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @Author ding
 * @Date 2021/12/20
 */
@Configuration
public class MyWebAppConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //多个拦截器组成一个拦截器链

        // addPathPatterns用于添加拦截规则

        // excludePathPatterns用户排除拦截
        registry.addInterceptor(Interceptor()).addPathPatterns("/**").excludePathPatterns("/**/person/**"); //对来自/user/** 这个链接来的请求进行拦截

    }

    @Bean
    public Interceptor Interceptor(){
        return new Interceptor();
    }
}
