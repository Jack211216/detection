package com.detection.util;


/**
 * @author ding
 * @date 2021/12/8
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {


   /**
    * 对象等于null
    * */
   public static boolean isNull(Object obj){

       return obj == null;

   }

    /**
     * 对象不等于null
     * */
    public static boolean isNotNull(Object obj){

        return obj != null;

    }

}
