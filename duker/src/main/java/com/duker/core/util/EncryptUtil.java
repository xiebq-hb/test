package com.duker.core.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;

/**
 * @author xiebq
 * @create 2019/8/19 0019
 * @since 1.0.0
 */
public class EncryptUtil {
    
    /**
     * 功能描述: <br>
     * MD5加密
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/8/19 上午 11:44
     */
    public static String md5(String encryptValue){
        try {
            return DigestUtils.md5Hex(encryptValue.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误");
        }
    }
}
