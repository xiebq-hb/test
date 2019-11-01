package com.duker.core.activemq.service.impl;

import com.duker.core.activemq.service.IProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author xiebq
 * @create 2019/10/18 0018
 * @since 1.0.0
 */
@Service
public class ProducerServiceImpl implements IProducerService {

    @Autowired
    private JmsMessagingTemplate template;
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;


    @Override
    public void sendMessage(Destination destination, String message) {
        template.convertAndSend(destination, message);
    }

    @Override
    public void sendMessage(String message) {
        template.convertAndSend(this.queue, message);
    }

    @Override
    public void publish(String message) {
        template.convertAndSend(this.topic, message);
    }

    @Override
    public void publish(Destination destination, String message) {
        template.convertAndSend(destination, message);
    }
}
