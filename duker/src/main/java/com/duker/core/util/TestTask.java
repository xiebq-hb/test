package com.duker.core.util;

/**
 * @author xiebq
 * @create 2019/9/19 0019
 * @since 1.0.0
 */
public class TestTask implements Runnable{
    private int index;

    public TestTask(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                new Thread().sleep(1000);  //模拟耗时操作
                System.out.println("[1]" + " "+ index + " "+ Thread.currentThread().getName());
            } catch (Exception e) {
            }
        }
    }
}
