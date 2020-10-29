package com.xueyun.service;

import com.xueyun.entity.Student;

import java.util.List;

/**
 * @author XueYun
 * @create 2020-10-27 16:51
 */
public interface StudentService {

    /**
     * 查询该导师的所有时间信息记录
     * @param userId 导师的id
     * @return student集合
     */
    List<Student> searchAppointTime(Integer userId);
}
