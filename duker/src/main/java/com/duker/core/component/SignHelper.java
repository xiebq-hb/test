package com.duker.core.component;

import com.duker.core.util.EncryptUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author xiebq
 * @create 2019/8/19 0019
 * @since 1.0.0
 */
@Component
@Slf4j
public class SignHelper {

    @Value("${app.secret_key}")
    private String secret_key ;
    @Value("${app.code}")
    private String app_code;


    /**
     * 功能描述: <br>
     * 生成token令牌
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/8/19 0019 上午 11:54
     */
    public String get(){
        return EncryptUtil.md5(app_code+":"+app_code+":"+System.currentTimeMillis());
    }
}
