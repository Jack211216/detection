package com.detection.exception;

import com.detection.exception.entity.MyException;
import com.detection.util.Result;
import com.detection.util.StringUtils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author ding
 * @date 2021/12/8
 */
@ControllerAdvice
public class WholeExceptionHandler {

    //声明要捕获的异常
    @ExceptionHandler(MyException.class)
    public Result ExcepitonHandler(MyException me) {

        if(StringUtils.isNull(me.getCode())){
          return Result.error(me.getMessage());
        }
        return  Result.error(me.getCode(),me.getMessage());
    }

}
