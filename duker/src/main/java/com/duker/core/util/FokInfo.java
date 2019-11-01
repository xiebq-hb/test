package com.duker.core.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author xiebq
 * @create 2019/9/18 0018
 * @since 1.0.0
 */
@Data
public class FokInfo {
    private String infoId;
    private int number;
    private String name;
    private Date uploadTime;
}
