package com.duker.core.idgenerator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xiebq
 * @create 2019/10/25 0025
 * @since 1.0.0
 */
@Component
public class GuuidUtil {

    @Value("${idworker.machineid}")
    private static long machineId;
    @Value("${idworker.datacenterid}")
    private static long datacenterId;


    /**
     * 单例模式创建学法算法对象
     * */
    private enum SnowFlakeSingleton{
        Singleton;
        private SnowFlake snowFlake;
        SnowFlakeSingleton(){
            snowFlake = new SnowFlake(datacenterId,machineId);
        }
        public SnowFlake getInstance(){
            return snowFlake;
        }
    }

    public static long getUUID(){
        return SnowFlakeSingleton.Singleton.getInstance().nextId();
    }

    public static void main(String[] args) {

        Set<Long> set = new HashSet<>();
        set.clear();

        System.out.println("开始........");

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            //System.out.println(GuuidUtil.getUUID());
            set.add(GuuidUtil.getUUID());
        }
        System.out.print("雪花算法用时： ");
        System.out.println(System.currentTimeMillis() - start);

        System.out.println("set.size:" + set.size());
        System.out.println("已结束");
    }
}
