package com.duker.core.task;

import com.alibaba.fastjson.JSON;
import com.duker.core.activemq.service.IProducerService;
import com.duker.core.entity.MessageEntity;
import com.duker.core.entity.ThirdMessageEntiry;
import com.duker.core.service.IUserDataService;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import java.util.UUID;

/**
 * 定时通过mq推送消息出去
 * @author xiebq
 * @create 2019/10/18 0018
 * @since 1.0.0
 */
@Slf4j
@Component
public class SendTask {

    @Autowired
    private IProducerService producerService;
    @Autowired
    private IUserDataService userDataService;

    /**
     * 功能描述: <br>
     * 每5分钟执行一次任务
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/10/18 0018 上午 9:53
     */
//    @Scheduled(cron="*/5 * * * * ?")
//    public void send(){
//        List<UserDataEntity> list = userDataService.list();
//        producerService.publish(JSON.toJSONStringWithDateFormat(list,"yyyy-MM-dd HH:ss:mm"));
//        log.info("用户数据包已成功发布（推送）, 时间={}, 数据包={}", DateUtil.Date2Str(new Date(),"yyyy-MM-dd HH:ss:mm"),
//                JSON.toJSONStringWithDateFormat(list,"yyyy-MM-dd HH:ss:mm"));
//    }


    // ******************************************************************************************* //

    /**
     * 功能描述: <br>
     * 每1分钟执行一次任务
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/10/18 0018 上午 9:53
     */
    //@Scheduled(cron="*/5 * * * * ?")
    public void sendToTopic(){
        log.info("portal.admin.topic 消息任务...");
        MessageEntity message = new MessageEntity();
        message.setEquip_ip(UUID.randomUUID().toString());
        Destination destination = new ActiveMQTopic("portal.admin.topic");
        producerService.publish(destination, JSON.toJSONString(message));
    }

    /**
     * 功能描述: <br>
     * 每1分钟执行一次任务
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/10/18 0018 上午 9:53
     */
    //@Scheduled(cron="*/5 * * * * ?")
    public void sendToTopic2(){
        log.info("portal.admin.topic2 消息任务...");
        ThirdMessageEntiry message = new ThirdMessageEntiry();
        message.setId(UUID.randomUUID().toString());
        Destination destination = new ActiveMQTopic("portal.admin.topic2");
        producerService.publish(destination,JSON.toJSONString(message));
    }

    /**
     * 功能描述: <br>
     * 每1分钟执行一次任务
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/10/18 0018 上午 9:53
     */
    //@Scheduled(cron="*/5 * * * * ?")
    public void sendToQueue(){
        log.info("portal.admin.queue 消息任务...");
        MessageEntity message = new MessageEntity();
        message.setEquip_ip(UUID.randomUUID().toString());
        Destination destination = new ActiveMQTopic("portal.admin.queue");
        producerService.sendMessage(destination, JSON.toJSONString(message));
    }

    /**
     * 功能描述: <br>
     * 每1分钟执行一次任务
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/10/18 0018 上午 9:53
     */
    //@Scheduled(cron="*/5 * * * * ?")
    public void sendToQueue2(){
        log.info("portal.admin.queue2 消息任务...");
//        ThirdMessageEntiry message = new ThirdMessageEntiry();
//        message.setId(UUID.randomUUID().toString());
//        producerService.send2Queue("portal.admin.queue2",message);
    }


}
