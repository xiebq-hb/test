package com.duker.core.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * activemq配置类
 * @author xiebq
 * @create 2019/10/18 0018
 * @since 1.0.0
 */
@Configuration
@Slf4j
public class ActivemqConfiguration {

    /**
     * 默认的点对点的消息队列名称
     */
    private static final String DEFAULT_QUEUE_NAEM = "common.queue";

    /**
     * 默认的订阅消息队列名称
     */
    private static final String DEFAULT_TOPIC_NAEM = "common.topic";

    @Bean(name = "queue")
    public Queue queue(){
        return new ActiveMQQueue(DEFAULT_QUEUE_NAEM);
    }

    @Bean(name = "topic")
    public Topic topic(){
        return new ActiveMQTopic(DEFAULT_TOPIC_NAEM);
    }

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        //使用消息转换器
        bean.setMessageConverter(jacksonJmsMessageConverter());
        return bean;
    }

    /**
     * queue模式的ListenerContainer
     * @param activeMQConnectionFactory
     * @return
     */
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setConnectionFactory(activeMQConnectionFactory);
        //使用消息转换器
        bean.setMessageConverter(jacksonJmsMessageConverter());
        return bean;
    }

    /**
     * 消息转换器
     * @return
     */
    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}
