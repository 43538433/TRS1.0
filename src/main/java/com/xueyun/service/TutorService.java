package com.xueyun.service;

import com.xueyun.entity.Tutor;

import java.util.List;

/**
 * @author XueYun
 * @create 2020-10-26 21:08
 */
public interface TutorService {

    /**
     * 实现模糊查询导师时间的请求
     * @param value 查询的方式
     * @param key 关键字
     * @return Tutor
     */
    List<Tutor> searchTime(String value, String key);

    /**
     * 查询该学生的所有预约记录
     * @param userSid 学生的工学号
     * @return Tutor
     */
    List<Tutor> searchAppointTime(String userSid);

    /**
     * 管理员查询所有学生的预约信息
     * @return 返回一个Tutor集合
     */
    List<Tutor> searchAllStuAppointTime();
}
