package com.duker.core.activemq.service;

import javax.jms.Destination;

/**
 * 消息推送接口服务
 * @author xiebq
 * @create 2019/10/18 0018
 * @since 1.0.0
 */
public interface IProducerService {

    /**
     * 功能描述: 指定消息队列，还有消息
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/10/18  上午 9:17
     */
    public void sendMessage(Destination destination, final String message);

    /**
     * 功能描述: 使用默认的消息队列，发送消息
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/10/18 0018 上午 9:19
     */
    public void sendMessage(final String message);

    /**
     * 功能描述: 指定消息队列发布订阅
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/10/18 上午 9:20
     */
    public void publish(Destination destination, String message);

    /**
     * 功能描述: 消息发布订阅
     * @return:
     * @since: 1.0.0
     * @Author:
     * @Date: 2019/10/18 上午 9:20
     */
    public void publish(String message);

}
