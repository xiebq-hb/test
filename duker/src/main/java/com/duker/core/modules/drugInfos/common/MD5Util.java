package com.duker.core.modules.drugInfos.common;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    // @@ 用来将字节转换成 16 进制表示的字符
    private static char hexDigits[];

    static {
        hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    /**
     * @param source
     * @return
     */
    public static String encode(String source) {
        try {
            return encode(source.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param source
     * @return
     */
    public static String encode(byte[] source) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update(source);
        // @@ MD5 的计算结果是一个 128 位的长整数，用字节表示就是 16 个字节
        byte tmp[] = md.digest();
        // @@ 每个字节用 16 进制表示的话，使用两个字符，所以表示成 16 进制需要 32 个字符
        char str[] = new char[16 * 2];
        // @@ 转换结果中对应的字符位置
        int k = 0;
        // @@ 从第一个字节开始，对 MD5 的每一个字节转换成 16 进制字符的转换
        for (int i = 0; i < 16; i++) {
            byte byte0 = tmp[i];
            // @@ 取字节中高 4 位的数字转换, >>> 为逻辑右移，将符号位一起右移
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            // @@ 取字节中低 4 位的数字转换
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
    }

    public static String getMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
