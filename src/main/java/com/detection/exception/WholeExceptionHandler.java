package com.detection.exception;

import com.detection.exception.entity.MyException;
import com.detection.common.Result;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ding
 * @date 2021/12/8
 */
@ControllerAdvice
public class WholeExceptionHandler {

    //声明要捕获的异常
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Result Method(MyException me) {
        if(me.getCode()!=0){
          return Result.error(me.getMessage());
        }
        return  Result.error(me.getCode(),me.getMessage());
    }

}
