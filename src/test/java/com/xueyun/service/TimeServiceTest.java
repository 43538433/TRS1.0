package com.xueyun.service;

import com.xueyun.entity.Time;
import com.xueyun.service.impl.TimeServiceImpl;
import org.junit.Test;

/**
 * @author XueYun
 * @create 2020-10-26 20:40
 */
public class TimeServiceTest {

    @Test
    public void test1(){

        TimeServiceImpl timeService = new TimeServiceImpl();

        Time time=new Time(null,12,"2020-12-12",0);

        timeService.addTime(time);

    }
}
