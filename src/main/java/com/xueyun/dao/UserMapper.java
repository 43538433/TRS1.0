package com.xueyun.dao;

import com.xueyun.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author XueYun
 * @create 2020-10-25 17:17
 */
public interface UserMapper {
    /**
     * 实现登录方法
     * @param sid 传入的登录用户的工学号
     * @return 是否登录成功
     */
    User login(@Param("sid")String sid);

    /**
     * 在user表中根据id删除
     * @param id 用户的id
     */
    void deleteById(@Param("id")int id);

    /**
     * 管理员查看所有用户
     * @return User集合
     */
    List<User> allUser();

}
