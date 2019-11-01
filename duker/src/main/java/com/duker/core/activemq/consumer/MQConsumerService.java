package com.duker.core.activemq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @author xiebq
 * @create 2019/10/18 0018
 * @since 1.0.0
 */
@Service
@Slf4j
public class MQConsumerService {

    @JmsListener(destination = "portal.admin.topic",containerFactory = "jmsListenerContainerTopic") // 监听指定消息主题
    public void receiveTopic(String message) {
        System.out.println("portal.admin.topic");
        System.out.println(message);
    }

    @JmsListener(destination = "portal.admin.topic2",containerFactory = "jmsListenerContainerTopic") // 监听指定消息主题
    public void receiveTopic2(String message) {
        System.out.println("portal.admin.topic2");
        System.out.println(message);
    }


    @JmsListener(destination = "portal.admin.queue",containerFactory = "jmsListenerContainerQueue") // 监听指定消息队列
    public void receiveQueue(String message) {
        System.out.println("portal.admin.queue");
        System.out.println(message);
    }

    @JmsListener(destination = "portal.admin.queue2",containerFactory = "jmsListenerContainerQueue") // 监听指定消息队列
    public void receiveQueue2(String message) {
        System.out.println("portal.admin.queue2");
        System.out.println(message);
    }

}
