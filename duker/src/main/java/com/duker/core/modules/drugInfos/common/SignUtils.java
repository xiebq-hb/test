package com.duker.core.modules.drugInfos.common;

public class SignUtils {

    /**
     * 调用药店签名
     *
     * @param conent
     * @param appId
     * @param securityKey
     * @param method
     * @return
     */
    public static String createSign(String conent, String appId, String securityKey, String method, String timestamp) {
        String signStr = conent + appId + securityKey + method + timestamp;
        String sign = MD5Util.encode(signStr);
        return sign;

    }
}
