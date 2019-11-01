package com.duker.core.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiebq
 * @create 2019/9/19 0019
 * @since 1.0.0
 */
public class Test {

    private static final int loopNum = 1*80;
    private static final int poolsize = 10;
    private static ExecutorService executor = null;

    public static void main(String args[]) throws InterruptedException {
        Test TestThreadPool = new Test();
        long bt = System.currentTimeMillis();
        TestThreadPool.m1();
        long et2 = System.currentTimeMillis();
        System.out.println("[1]耗时:"+(et2 - bt)+ "ms");
//        Thread thread = new Thread();
//        long at = System.currentTimeMillis();
//        TestThreadPool.m2();
//        long et3 = System.currentTimeMillis();
//        System.out.println("[2]耗时:"+(et3 - at)+ "ms");

    }

    public void m1() {

        int number = 10000;
        executor = new ThreadPoolExecutor(poolsize, poolsize, 0L,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(number));

        for (int i = 0; i < 1000; i++) {
            System.out.println(" " + i);

//            for (int index = 0; index < loopNum; in executor.execute(new TestTask(i));dex++) {
//            Runnable run = new Runnable() {
//                public void run() {
//                    try {
//                        new Thread().sleep(1000);  //模拟耗时操作
//                        System.out.println("[1]" + Thread.currentThread().getName());
//                    } catch (Exception e) {
//                    }
//                }
//            };
//            pool.execute(run);
//            }
            System.out.println("[1] done!");
        }
        executor.shutdown();
    }

    public void m2() {
        AtomicInteger connectionIds = new AtomicInteger(0);
        for (int index = 0; index < loopNum; index++) {
            try {
                new Thread().sleep(1000);  //模拟耗时操作
                System.out.println("[2]" + Thread.currentThread().getName());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("[2] done!");
    }
}
