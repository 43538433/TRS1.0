package com.xueyun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XueYun
 * @create 2020-10-25 17:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Time {
    /**
     * 每条时间对应的主键id
     */
    private Integer id;
    /**
     * 用户的id
     */
    private Integer userId;
    /**
     * 导师的时间
     */
    private String time;
    /**
     * 对应该条时间的状态
     */
    private Integer tStatus;
}
