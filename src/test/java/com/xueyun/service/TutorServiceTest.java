package com.xueyun.service;

import com.xueyun.entity.Tutor;
import com.xueyun.service.impl.TutorServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author XueYun
 * @create 2020-10-26 22:04
 */
public class TutorServiceTest {

    @Test
    public void test1(){
        TutorServiceImpl tutorService = new TutorServiceImpl();

//        List<Tutor> list=tutorService.searchTime("all",null);

        List<Tutor> list=tutorService.searchTime("name","张");

        for (Tutor tutor : list) {
            System.out.println(tutor);
        }

    }

    @Test
    public void test2(){
        TutorServiceImpl tutorService = new TutorServiceImpl();

        List<Tutor> list=tutorService.searchAppointTime("3219005060");

        for (Tutor tutor : list) {
            System.out.println(tutor);
        }
    }
}
