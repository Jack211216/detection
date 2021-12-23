package com.detection.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.detection.exception.entity.MyException;

import java.io.*;
import java.util.Properties;


/**
 * @Author ding
 * @Date 2021/12/16
 */
public class PropertiesUtil {

    private final static String PRO_PATH="constant.properties";

    private static Properties properties;

    /**
     * 类加载
     * */
    static{
        properties = getInstance(new Properties());
        InputStream  stream = ClassLoader.getSystemResourceAsStream(PRO_PATH);
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(stream!=null) stream.close();
            } catch (IOException e) {
                throw new MyException("文件读取错误！");
            }
        }


    }

    /**
     * 单例
     * */
    public synchronized static  Properties getInstance(Properties properties){

        if(StringUtils.isNotNull(properties))
            properties=new Properties();

        return properties;
    }



    public static Properties getUerKey(String filePath){

        properties = getInstance(new Properties());
        InputStream stream = null;
        try {
            stream =new  FileInputStream(filePath);
            properties.load(stream);
        } catch (FileNotFoundException e) {
           throw new MyException("找不到文件:"+filePath);
        } catch (IOException e) {
           throw new MyException("文件读取错误:"+filePath);
        } catch (NullPointerException e) {
           throw new MyException("文件内容为空:"+filePath);
        } finally {
            try {
                if(stream!=null)stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       return properties;
    }

    public static String getKey(String key){

        return properties.getProperty(key);

    }

}
