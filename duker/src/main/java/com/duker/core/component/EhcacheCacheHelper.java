package com.duker.core.component;

import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * EhcacheCache缓存工具类
 * @author xiebq
 * @create 2019/8/15 0015
 * @since 1.0.0
 */
@Slf4j
@Component
public class EhcacheCacheHelper {

    @Autowired
    private CacheManager cacheManager;

    
    /**
     * 功能描述: <br>
     * 获取Cache类
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/8/16 上午 10:55
     */
    public Cache getCache(String cacheName){
        return cacheManager.getCache(cacheName);
    }

    /**
     *  添加缓存
     */
    public void put(String cacheName, String key, Object value){
        try{
            Cache cache = cacheManager.getCache(cacheName);
            Element element = new Element(key, value);
            cache.put(element);
        }catch (Exception e){
            log.error("添加ehcache缓存失败:{}",e);
        }
    }

    /**
     *  获取缓存
     */
    public Object get(String cacheName, String key){
        try{
            Cache cache = cacheManager.getCache(cacheName);
            Element element = cache.get(key);
            return element == null ? null : element.getObjectValue();
        }catch (Exception e){
            log.error("获取ehcache缓存失败:{}",e);
        }
        return null;
    }

    /**
     *  删除缓存
     */
    public void del(String cacheName, String key){
        try{
            Cache cache = cacheManager.getCache(cacheName);
            cache.remove(key);
        }catch (Exception e){
            log.error("删除ehcache缓存失败:{}",e);
        }
    }
}
