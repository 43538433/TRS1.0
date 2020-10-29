package com.xueyun.service;

import com.xueyun.entity.User;
import com.xueyun.exception.CustomerErrorMsgException;
import com.xueyun.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author XueYun
 * @create 2020-10-26 19:22
 */
public class UserServiceTest {

    @Test
    public void UserServiceTest1() throws CustomerErrorMsgException {

        UserServiceImpl userService = new UserServiceImpl();

        User user=userService.login("小红","3219005061","123456");

        System.out.println(user);
    }

    @Test
    public void Test2(){

        UserServiceImpl userService = new UserServiceImpl();

        userService.deleteUser("3219005084",15);
    }
}
