package com.duker.core.config;

import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiebq
 * @create 2019/8/16 0016
 * @since 1.0.0
 */
@Configuration
@Slf4j
public class EhcacheConfiguration {

    /**
     * 功能描述: <br>
     * 不配置ehcache.xml的话会默认查找/ehcache.xml
     * 如果需要自定义xml路径，则使用CacheManager.newInstance(path);
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/8/16 0016 上午 10:51
     */
    @Bean(name = "ehcacheManager")
    public CacheManager cacheManager(){
        return CacheManager.newInstance();
    }
}
