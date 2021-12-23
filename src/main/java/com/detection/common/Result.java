package com.detection.common;

import com.detection.util.HttpStatus;

import java.util.HashMap;

/**
 * @author ding
 * @date 2021/12/8
 */
public class Result extends HashMap<String,Object> {

    //状态码
    public static final String CODE_TAG="code";

    //返回内容
    public static final String MSG_TAG="msg";

    //数据对象
    public static final String DATA_TAG="data";


    public Result(){

    }

    /**初始化**/
    public Result(int code, String msg, Object data){
        super.put(CODE_TAG,code);
        super.put(MSG_TAG,msg);
        if(data!=null){
            super.put(DATA_TAG,data);

        }
    }

    public Result(int code, String msg){
        super.put(CODE_TAG,code);
        super.put(MSG_TAG,msg);

    }


    /**
     * 返回成功
     * @param msg 内容
     * @param data 数据对象
     * */
    public static Result success(String msg, Object data){

        return new Result(HttpStatus.SUCCESS,msg,data);
    }



    /**返回成功*/
    public static Result success(){

        return success("操作成功");

    }


    public static Result success(String msg){

        return new Result(HttpStatus.SUCCESS,msg);
    }



    public static Result success(Object ... data){

        return success("操作成功",data);

    }

    /**返回失败*/
    public static Result error(){

        return error("操作失败");

    }

    public static Result error(String msg){

        return new Result(HttpStatus.ERROR,msg);

    }

    public static Result error(int code,String msg){
        return new Result(code,msg);

    }
}
