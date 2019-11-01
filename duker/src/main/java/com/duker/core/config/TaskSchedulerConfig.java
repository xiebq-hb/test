package com.duker.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * 配置线程池线程数，解决：springboot默认同时单线程执行任务，
 * 也就是说一次只能执行一个任务。
 * @author xiebq
 * @create 2019/9/18 0018
 * @since 1.0.0
 */
@Configuration
public class TaskSchedulerConfig {

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);//设置线程数10
        return taskScheduler;
    }
}
