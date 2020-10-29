package com.xueyun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XueYun
 * @create 2020-10-25 17:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * 每个用户的主键id
     */
    private Integer id;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 用户的工学号
     */
    private String sid;
    /**
     * 用户的密码
     */
    private String password;
    /**
     * 用户的联系电话
     */
    private String tel;
    /**
     * 用户所在的学院
     */
    private String college;
    /**
     * 用户的专业
     */
    private String grade;
    /**
     * 用户的权限
     */
    private Integer status;
}
