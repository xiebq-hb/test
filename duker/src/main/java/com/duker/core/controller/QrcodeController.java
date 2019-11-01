package com.duker.core.controller;

import com.duker.core.util.QrCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * @author xiebq
 * @create 2019/10/17 0017
 * @since 1.0.0
 */
@Controller
@RequestMapping(value = "/api")
public class QrcodeController {

    /**
     * 功能描述: <br>
     * 二维码
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/10/17 0017 下午 13:44
     */
    @RequestMapping(value = "/qrcode")
    public void qrcode(HttpServletRequest request, HttpServletResponse response){
        StringBuffer url = request.getRequestURL();
        //域名
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();

        //再加上请求链接
//        String requestUrl = tempContextUrl + "ducker/index";
        String requestUrl = "https://www.zhihu.com/signin?next=%2F";
        try {
            OutputStream os = response.getOutputStream();
            //带有logo的二维码生成
            QrCodeUtil.encode(requestUrl, "D:\\temp\\logo\\logo.png", os, true);
            //不带logo的二维码生成
            QrCodeUtil.encode(requestUrl, os);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
