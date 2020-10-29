package com.xueyun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XueYun
 * @create 2020-10-27 16:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    /**
     * 学生的姓名
     */
    private String name;
    /**
     * 学生的学号
     */
    private String userSid;
    /**
     * 学生的学院
     */
    private String college;
    /**
     * 学生预约的时间
     */
    private String time;
    /**
     * 预约的状态
     */
    private Integer tStatus;
    /**
     * 显示在前端的状态
     */
    private String status;
    /**
     *time表的主键id
     */
    private Integer id;
    /**
     * result表的主键rid
     */
    private Integer rid;
    /**
     * 导师审批时与tStatus进行比较的值，恒为1
     */
    private Integer compare;
}
