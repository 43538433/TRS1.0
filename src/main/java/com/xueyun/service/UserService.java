package com.xueyun.service;

import com.xueyun.entity.User;
import com.xueyun.exception.CustomerErrorMsgException;

import java.util.List;

/**
 * @author XueYun
 * @create 2020-10-26 17:05
 */
public interface UserService {

    /**
     * 实现登录方法
     * @param name 用户姓名
     * @param sid 工学号
     * @param password 密码
     * @return User 若存在此用户，返回用户的所有信息
     * @throws CustomerErrorMsgException 抛出自定义异常：用户名或密码错误
     */
    User login(String name, String sid, String password) throws CustomerErrorMsgException;

    /**
     * 实现删除用户方法
     * @param sid 用户的工学号
     * @param id 用户的id
     */
    void deleteUser(String sid,int id);

    /**
     * 管理员查看所有用户
     * @return User集合
     */
    List<User> allUser();
}
