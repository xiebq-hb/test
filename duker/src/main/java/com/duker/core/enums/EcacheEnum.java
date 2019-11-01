package com.duker.core.enums;

/**
 * ehcache缓存枚举类
 * @author xiebq
 * @desc
 * @create 2019/8/16 0016
 * @since 1.0.0
 */
public enum EcacheEnum {

    //用户缓存
    USER_CACHE("users","user_cache");

    EcacheEnum(String cacheName, String key) {
        this.cacheName = cacheName;
        this.key = key;
    }

    private String cacheName;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCacheName() {
        return cacheName;
    }

    public void setCacheName(String cacheName) {
        this.cacheName = cacheName;
    }
}
