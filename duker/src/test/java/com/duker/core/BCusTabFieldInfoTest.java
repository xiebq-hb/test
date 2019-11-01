package com.duker.core;

import com.alibaba.fastjson.JSON;
import com.duker.core.entity.BCusTabFieldInfoEntity;
import com.duker.core.service.IBCusTabFieldInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xiebq
 * @create 2019/10/22 0022
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BCusTabFieldInfoTest {

    @Autowired
    private IBCusTabFieldInfoService ibCusTabFieldInfoService;

    @Test
    public void getBCusTabFieldInfo(){
        BCusTabFieldInfoEntity infoEntity = ibCusTabFieldInfoService.getById(1);
//        System.out.println(JSON.toJSONString(infoEntity));
        System.out.println(JSON.toJSONStringWithDateFormat(infoEntity,"yyyy-MM-dd HH:ss:mm"));
    }
}
