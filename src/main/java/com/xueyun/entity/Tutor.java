package com.xueyun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XueYun
 * @create 2020-10-25 20:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tutor {
    /**
     * 每条时间的主键id
     */
    private Integer id;
    /**
     * 学生的学号
     */
    private String sid;
    /**
     * 用户的专业
     */
    private String grade;
    /**
     * 用户的姓名
     */
    private String name;
    /**
     * 用户的学院
     */
    private String college;
    /**
     * 导师的时间
     */
    private String time;
    /**
     * 显示在前端的状态
     */
    private String status;
    /**
     * 数据库对应的状态
     */
    private Integer stuStatus;
}
