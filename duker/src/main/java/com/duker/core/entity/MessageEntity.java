package com.duker.core.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 消息实体
 * @author xiebq
 * @create 2019/10/18 0018
 * @since 1.0.0
 */
@Data
public class MessageEntity implements Serializable {
    // 序列化
    private static final long serialVersionUID = 1L;

    // 消息内容
    private Map<String,Object> alarm_event_mes;
    // 消息标题
    private String alarm_event_title;
    // 消息类型ID
    private Integer alarm_type_id;
    // 动作ID
    private String alarm_action_code;
    // 消息备注
    private String remark;
    //创建时间
    private Date create_time;
    //ip
    private String equip_ip;

    public void add(String key,Object value){
        alarm_event_mes.put(key,value);
    }
    public Object get(String key){
        return alarm_event_mes.get(key);
    }

    public MessageEntity(){
        create_time = new Date();
        alarm_event_mes = new HashMap<>();
    }
}
