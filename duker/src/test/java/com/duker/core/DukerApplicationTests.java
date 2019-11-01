package com.duker.core;

import com.alibaba.fastjson.JSON;
import com.duker.core.component.EhcacheCacheHelper;
import com.duker.core.component.HttpClientHelper;
import com.duker.core.component.RedisCacheHelper;
import com.duker.core.component.SignHelper;
import com.duker.core.enums.EcacheEnum;
import com.duker.core.util.FokInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DukerApplicationTests {

    @Autowired
    private RedisCacheHelper redisCacheHelper;
    @Autowired
    private EhcacheCacheHelper ehcacheCacheHelper;
    @Autowired
    private HttpClientHelper httpClientHelper;
    @Autowired
    private SignHelper signHelper;

    private static final  String redis_key = "user:1002:list";

    @Test
    public void contextLoads() {
    }


    /**
     * 功能描述: <br>
     * Reis服务测试-缓存
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/8/15 0015 下午 17:25
     */
    @Test
    public void redis_put() {
        List<String> list = Arrays.asList("Tjgg","Kay","Hjuyt","Gtts");

        //缓存
        //boolean f = redisCacheHelper.set(redis_key, list);
        boolean b = redisCacheHelper.lSet(redis_key, list);

        //设置生命周期,秒单位
        //redisCacheHelper.expire(redis_key,120);
        if (b){
            log.info("redis 缓存成功");
        }else {
            log.info("redis 缓存失败");
        }
    }

    /**
     * 功能描述: <br>
     * Reis服务测试-删除
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/8/15 0015 下午 17:25
     */
    @Test
    public void redis_del() {
        redisCacheHelper.del(redis_key);
        log.info("redis 清除缓存");
    }

    /**
     * 功能描述: <br>
     * Reis服务测试-获取
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/8/15 0015 下午 17:25
     */
    @Test
    public void redis_get() {
        //获取
        List<String> getlist = (List<String>)redisCacheHelper.get(redis_key);
        if (!getlist.isEmpty()){
            System.out.println(JSON.toJSON(getlist));
            log.info("redis 获取缓存成功");
        }
    }

    /**
     * 功能描述: <br>
     * ehcache服务测试
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/8/15 0015 下午 17:25
     */
    @Test
    public void ehcache_put() {
        int num  = 5555;
        ehcacheCacheHelper.put(EcacheEnum.USER_CACHE.getCacheName(),EcacheEnum.USER_CACHE.getKey(),num);
        log.info(".......................缓存成功.......................");
        Integer o = (Integer)ehcacheCacheHelper.get(EcacheEnum.USER_CACHE.getCacheName(), EcacheEnum.USER_CACHE.getKey());
        System.out.println("获取缓存值：" + o);
    }

    /**
     * 功能描述: <br>
     * ehcache服务测试
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/8/15 0015 下午 17:25
     */
    @Test
    public void ehcache_get() {
        Integer num = (Integer)ehcacheCacheHelper.get(EcacheEnum.USER_CACHE.getCacheName(), EcacheEnum.USER_CACHE.getKey());
        System.out.println("获取缓存值：" + num);
    }

    /**
     * 功能描述: <br>
     * http服务测试
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/8/15 0015 下午 17:25
     */
    @Test
    public void http_get() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("username", "xiaoming");
        String url="http://127.0.0.1:9528/api/v1/httpClientResponse?sign=HDIUEW3243DWD222DW";
        String s = httpClientHelper.doGet(url, param);
        System.out.println("http请求接口结果:"+ s);
    }


    /**
     * 功能描述: <br>
     * http服务测试
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/8/15 0015 下午 17:25
     */
    @Test
    public void http_post() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("username", "xiaoming");
        String url="http://127.0.0.1:9528/api/v1/httpClientResponse/post?sign=HDIUEW3243DWD222DW";
        String s = httpClientHelper.doPost(url, param);
        System.out.println("http请求接口结果:"+ s);
    }

    /**
     * 功能描述: <br>
     * http服务测试
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/8/15 0015 下午 17:25
     */
    @Test
    public void http_doPostJson() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("username", "xiaoming");
        String url="http://127.0.0.1:9528/api/v1/httpClientResponse/postjson?sign=HDIUEW3243DWD222DW";
        String s = httpClientHelper.doPostJson(url, JSON.toJSONString(param));
        System.out.println("http请求接口结果:"+ s);
    }


    // *******************************************************************************************************************


    /**
     * 功能描述: <br>
     * 全局日期格式测试
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/8/15 下午 17:25
     */
    @Test
    public void dateTest() {
        FokInfo info = new FokInfo();

        info.setInfoId("12113344300011");
        info.setName("长安广汽有限责任公司");
        info.setNumber(5);
        info.setUploadTime(new Date());

        //格式化DATE类型的字段
        log.info(JSON.toJSONStringWithDateFormat(info,"yyyy-MM-dd HH:ss:mm"));
    }


}
