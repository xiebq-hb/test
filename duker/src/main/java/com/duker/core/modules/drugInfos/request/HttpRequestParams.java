package com.duker.core.modules.drugInfos.request;

import com.alibaba.fastjson.JSON;
import com.duker.core.modules.drugInfos.common.SignUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiebq
 * @create 2019/10/22 0022
 * @since 1.0.0
 */
public class HttpRequestParams {

    public static void  createRequestParams(){
        //商户编码
        String mchCode = "";
        //密钥
        String secret = "";
        //请求接口
        String url = "";

        //待签名内容
        Map<String,Object> ps = new HashMap<>();
        ps.put("orderId","w23ddieu33t3te");
        ps.put("storeCode","43eb4b603af811e9906200163e02b1e9");

        //时间戳
        String timestamp = System.currentTimeMillis() + "";
        String signValue = SignUtils.createSign(
                JSON.toJSONString(ps),
                mchCode,
                secret,
                url,
                timestamp);

        System.out.println("NONCESTR:" + "接口名称");
        System.out.println("TIMESTAMP_HEAD:" + timestamp);
        System.out.println("TENANTCODE:" + mchCode);
        System.out.println("SIGN_HEAD:" + signValue);
        System.out.println("CONTENT_TYPE:" + "application/json");

    }

    public static void main(String[] args) {
        createRequestParams();
    }

}
