package com.xueyun.dao;

import com.xueyun.entity.Tutor;
import com.xueyun.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @author XueYun
 * @create 2020-10-25 20:50
 */
public class TutorMapperTest {

    private Logger logger= Logger.getLogger(TutorMapperTest.class);
    @Test
    public void addTimeTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        TutorMapper mapper = sqlSession.getMapper(TutorMapper.class);

        List<Tutor> list=mapper.searchAllTime();
        System.out.println("------查询成功------");
        for (Tutor tutor : list) {
            System.out.println(tutor);
        }

        sqlSession.close();
    }
    @Test
    public void searchAppointTimeTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        TutorMapper mapper = sqlSession.getMapper(TutorMapper.class);

        List<Tutor> list=mapper.searchAppointTime("3219005060");
        System.out.println("------查询成功------");
        for (Tutor tutor : list) {
            System.out.println(tutor);
        }

        sqlSession.close();
    }

    @Test
    public void searchTimeTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        TutorMapper mapper = sqlSession.getMapper(TutorMapper.class);

//        List<Tutor> list=mapper.searchAllTime();
//        System.out.println("------查询成功------");
//        for (Tutor tutor : list) {
//            System.out.println(tutor);
//        }
//
//        List<Tutor> list2=mapper.searchByName("%张%");
//        System.out.println("------查询成功------");
//        for (Tutor tutor : list2) {
//            System.out.println(tutor);
//        }

        List<Tutor> list3=mapper.searchByTime("%10%");
        System.out.println("------查询成功------");
        for (Tutor tutor : list3) {
            System.out.println(tutor);
        }
        sqlSession.close();
    }

    @Test
    public void test1(){

        SqlSession sqlSession = MybatisUtil.getSqlSession();

        TutorMapper mapper = sqlSession.getMapper(TutorMapper.class);

        List<Tutor> list=mapper.searchAllStuAppointTime();

        for (Tutor tutor : list) {
            System.out.println(tutor);
        }

    }
}
