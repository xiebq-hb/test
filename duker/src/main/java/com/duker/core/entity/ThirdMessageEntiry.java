package com.duker.core.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiebq
 * @create 2019/10/18 0018
 * @since 1.0.0
 */
@Data
public class ThirdMessageEntiry implements Serializable {
    private static final long serialVersionUID = 1L;
    String id;
    String type;
    Integer level;
}
