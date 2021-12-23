package com.detection.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.detection.annotation.VerifyToken;
import com.detection.entity.Login;
import com.detection.entity.User;
import com.detection.exception.entity.MyException;
import com.detection.service.Impl.LoginServiceImpl;
import com.detection.service.LoginService;
import com.detection.util.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @Author ding
 * @Date 2021/12/20
 */

public class Interceptor implements HandlerInterceptor {

    private final static Logger logger= LoggerFactory.getLogger(Interceptor.class);

    @Autowired
    LoginService loginService;

    @Value("${token.secret}")
    private String SECRET;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){

//        if (loginService == null) {//解决service为null无法注入问题
//            logger.error("loginService is null");
//            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
//            loginService = (LoginServiceImpl) factory.getBean("LoginServiceImpl");
//        }
        // 从http请求中取出 token
        String token = request.getHeader("Authorization");
        logger.debug("拦截了！");
        //判断是否是请求到controller层，如果不是就放行，否真拦截
        if(!(handler instanceof HandlerMethod))
           return true;

//        HandlerMethod handlerMethod= (HandlerMethod) handler;
//        Method method=handlerMethod.getMethod();
//
//        if(method.isAnnotationPresent(VerifyToken.class)){
//            VerifyToken annotation = method.getAnnotation(VerifyToken.class);
//            if(annotation.required()){
                if(StringUtils.isNull(token)){
                    throw new MyException("请求没有token!");
                }
                Long userId;
                try{
                    userId = Long.valueOf(JWT.decode(token).getAudience().get(0));
                }catch (JWTDecodeException e){
                     throw new MyException("token不合法");
                }
                User user=new User();
                user.setId(userId);
                User us = loginService.queryId(user);

                if(StringUtils.isNull(us)) throw new MyException("用户不存在，请重新登录！");

                //验证 token
                JWTVerifier jwt=JWT.require(Algorithm.HMAC256(SECRET+us.getPassword())).build();
                try{
                    jwt.verify(token);
                }catch (JWTVerificationException e){
                     e.printStackTrace();
                    throw new MyException("校验token发生异常");
                }
                return true;
//            }
//        }
//         return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws  Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }



}
