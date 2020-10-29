package com.xueyun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XueYun
 * @create 2020-10-25 17:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    /**
     * result表的主键id
     */
    private Integer rid;
    /**
     * 预约该条时间的学生的工学号
     */
    private String userSid;
    /**
     * 该条时间在time表对应的主键id
     */
    private Integer timeId;
    /**
     * 该学生这条预约时间的状态
     */
    private Integer stuStatus;
}
