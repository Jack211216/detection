package com.detection.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author ding
 * @Date 2021/12/23
 */
public class EncryUtil {


    /**
     * 加密整数型字段
     *
     * @param input
     * @return
     * @throws Exception
     */
    public static Long EncryptLong(Long input) {
        if (input != null) {
            if (input == 0) return input;
            byte[] bytes = GetBytesToBin(input, 32);
            byte[] resultBytes = Reset(bytes);
            Long result = Compute(resultBytes, 32);
            return result == 0 ? input : result;
        }
        return input;
    }

    public static List<Long> EncryptLong(List<Long> num) {
        List<Long> e=new ArrayList<>();
        for(Long input:num){
            e.add(EncryptLong(input));
        }

        return e;
    }

    /**
     * 解密整数型字段
     *
     * @param input
     * @return
     * @throws Exception
     */
    public static Long DecryptLong(Long input) {
        if (input != null) {
            if (input == 0) return input;
            byte[] bytes = GetBytesToBin(input, 32);
            byte[] resultBytes = Reset2(bytes);
            Long result = Compute(resultBytes, 32);
            return result == 0 ? input : result;
        }
        return input;
    }


    public static List<Long> DecryptLong(List<Long> num) {
        List<Long> d=new ArrayList<>();
        for(Long input:num){
            d.add(DecryptLong(input));
        }
        return d;
    }

    /**
     * 十进制转成二进制byte[]
     *
     * @param value
     * @param count
     * @return
     */
    public static byte[] GetBytesToBin(Long value, int count) {
        byte[] ret = new byte[count];
        Long ptr = value;
        for (int i = 0; i < count; i++) {
            ret[i] = (byte) (ptr % 2);
            ptr = ptr / 2;
        }

        return ret;
    }

    /**
     * 二进制byte[]转成十进制
     *
     * @param bytes
     * @param count
     * @return
     */
    public static Long Compute(byte[] bytes, int count) {
        Long value = (long) 0;
        for (int i = 0; i < count; i++) {
            value += (long) (bytes[i] * Math.pow(2, i));
        }
        return value;
    }

    /**
     * 加密处理
     */
    public static byte[] Reset(byte[] bytes) {
        // region 置换加密
        byte byte0 = bytes[0];
        byte byte1 = bytes[1];
        byte byte2 = bytes[2];
        byte byte3 = bytes[3];
        byte byte4 = bytes[4];
        byte byte5 = bytes[5];
        byte byte6 = bytes[6];
        byte byte7 = bytes[7];
        byte byte8 = bytes[8];
        byte byte9 = bytes[9];
        byte byte10 = bytes[10];
        byte byte11 = bytes[11];
        byte byte12 = bytes[12];
        byte byte13 = bytes[13];
        byte byte14 = bytes[14];
        byte byte15 = bytes[15];
        byte byte16 = bytes[16];
        byte byte17 = bytes[17];
        byte byte18 = bytes[18];
        byte byte19 = bytes[19];
        byte byte20 = bytes[20];
        byte byte21 = bytes[21];
        byte byte22 = bytes[22];
        byte byte23 = bytes[23];
        byte byte24 = bytes[24];
        byte byte25 = bytes[25];
        byte byte26 = bytes[26];
        byte byte27 = bytes[27];
        byte byte28 = bytes[28];
        byte byte29 = bytes[29];
        byte byte30 = bytes[30];
        byte byte31 = bytes[31];

        byte[] keyBytes = GetBytesToBin((long) 785469581, 36);
        bytes[0] = (byte) (byte8 ^ keyBytes[10]);
        bytes[1] = (byte) (byte9 ^ keyBytes[9]);
        bytes[2] = (byte) (byte10 ^ keyBytes[8]);
        bytes[3] = (byte) (byte11 ^ keyBytes[11]);
        bytes[4] = (byte) (byte12 ^ keyBytes[12]);
        bytes[5] = (byte) (byte13 ^ keyBytes[13]);
        bytes[6] = byte7;
        bytes[7] = byte6;
        bytes[8] = (byte) (byte24 ^ keyBytes[25]);
        bytes[9] = (byte) (byte25 ^ keyBytes[24]);
        bytes[10] = (byte) (byte26 ^ keyBytes[26]);
        bytes[11] = (byte) (byte27 ^ keyBytes[29]);
        bytes[12] = (byte) (byte28 ^ keyBytes[27]);
        bytes[13] = (byte) (byte29 ^ keyBytes[28]);
        bytes[14] = byte15;
        bytes[15] = byte14;
        bytes[16] = (byte) (byte16 ^ keyBytes[17]);
        bytes[17] = (byte) (byte17 ^ keyBytes[18]);
        bytes[18] = (byte) (byte18 ^ keyBytes[16]);
        bytes[19] = (byte) (byte19 ^ keyBytes[21]);
        bytes[20] = (byte) (byte20 ^ keyBytes[20]);
        bytes[21] = (byte) (byte21 ^ keyBytes[19]);
        bytes[22] = byte31;
        bytes[23] = byte30;
        bytes[24] = byte23;
        bytes[25] = byte22;
        bytes[26] = (byte) (byte5 ^ keyBytes[3]);
        bytes[27] = (byte) (byte4 ^ keyBytes[5]);
        bytes[28] = (byte) (byte3 ^ keyBytes[4]);
        bytes[29] = (byte) (byte2 ^ keyBytes[0]);
        bytes[30] = (byte) (byte1 ^ keyBytes[2]);
        bytes[31] = (byte) (byte0 ^ keyBytes[1]);
        // endregion
        return bytes;
    }


    /**
     * 解密处理
     */
    public static byte[] Reset2(byte[] bytes) {
        // region 置换加密
        byte byte0 = bytes[0];
        byte byte1 = bytes[1];
        byte byte2 = bytes[2];
        byte byte3 = bytes[3];
        byte byte4 = bytes[4];
        byte byte5 = bytes[5];
        byte byte6 = bytes[6];
        byte byte7 = bytes[7];
        byte byte8 = bytes[8];
        byte byte9 = bytes[9];
        byte byte10 = bytes[10];
        byte byte11 = bytes[11];
        byte byte12 = bytes[12];
        byte byte13 = bytes[13];
        byte byte14 = bytes[14];
        byte byte15 = bytes[15];
        byte byte16 = bytes[16];
        byte byte17 = bytes[17];
        byte byte18 = bytes[18];
        byte byte19 = bytes[19];
        byte byte20 = bytes[20];
        byte byte21 = bytes[21];
        byte byte22 = bytes[22];
        byte byte23 = bytes[23];
        byte byte24 = bytes[24];
        byte byte25 = bytes[25];
        byte byte26 = bytes[26];
        byte byte27 = bytes[27];
        byte byte28 = bytes[28];
        byte byte29 = bytes[29];
        byte byte30 = bytes[30];
        byte byte31 = bytes[31];

        byte[] keyBytes = GetBytesToBin((long) 785469581, 36);
        bytes[0] = (byte) (byte31 ^ keyBytes[1]);
        bytes[1] = (byte) (byte30 ^ keyBytes[2]);
        bytes[2] = (byte) (byte29 ^ keyBytes[0]);
        bytes[3] = (byte) (byte28 ^ keyBytes[4]);
        bytes[4] = (byte) (byte27 ^ keyBytes[5]);
        bytes[5] = (byte) (byte26 ^ keyBytes[3]);
        bytes[6] = byte7;
        bytes[7] = byte6;
        bytes[8] = (byte) (byte0 ^ keyBytes[10]);
        bytes[9] = (byte) (byte1 ^ keyBytes[9]);
        bytes[10] = (byte) (byte2 ^ keyBytes[8]);
        bytes[11] = (byte) (byte3 ^ keyBytes[11]);
        bytes[12] = (byte) (byte4 ^ keyBytes[12]);
        bytes[13] = (byte) (byte5 ^ keyBytes[13]);
        bytes[14] = byte15;
        bytes[15] = byte14;
        bytes[16] = (byte) (byte16 ^ keyBytes[17]);
        bytes[17] = (byte) (byte17 ^ keyBytes[18]);
        bytes[18] = (byte) (byte18 ^ keyBytes[16]);
        bytes[19] = (byte) (byte19 ^ keyBytes[21]);
        bytes[20] = (byte) (byte20 ^ keyBytes[20]);
        bytes[21] = (byte) (byte21 ^ keyBytes[19]);
        bytes[22] = byte25;
        bytes[23] = byte24;
        bytes[24] = (byte) (byte8 ^ keyBytes[25]);
        bytes[25] = (byte) (byte9 ^ keyBytes[24]);
        bytes[26] = (byte) (byte10 ^ keyBytes[26]);
        bytes[27] = (byte) (byte11 ^ keyBytes[29]);
        bytes[28] = (byte) (byte12 ^ keyBytes[27]);
        bytes[29] = (byte) (byte13 ^ keyBytes[28]);
        bytes[30] = byte23;
        bytes[31] = byte22;
        // endregion
        return bytes;
    }

    /**
     * 加密
     * **/
    public static String base64Encode(String str){
        BASE64Encoder baseEncode = new BASE64Encoder();
        return baseEncode.encode(str.getBytes());//加密
    }

    /**
     * 解密
     * */
    public static String base64Decode(String str){
        BASE64Decoder baseDecoder = new BASE64Decoder();
        try {
            return new String(baseDecoder.decodeBuffer(str));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
