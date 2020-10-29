package com.xueyun.dao;

import com.xueyun.entity.Student;
import com.xueyun.entity.Time;
import com.xueyun.entity.User;
import com.xueyun.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @author XueYun
 * @create 2020-10-25 19:57
 */
public class TimeMapperTest {

    @Test
    public void addTimeTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        TimeMapper mapper = sqlSession.getMapper(TimeMapper.class);

        Time time=new Time(null,12,"2020-11-11",0);

        int status=mapper.addTime(time);
        System.out.println(status);

        sqlSession.close();
    }

    @Test
    public void deleteByTimeIdTest() {
        SqlSession session = MybatisUtil.getSqlSession();

        TimeMapper mapper = session.getMapper(TimeMapper.class);

        mapper.deleteByTimeId(9);
        session.close();
    }

    @Test
    public void updateTimeStatusTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        TimeMapper mapper = sqlSession.getMapper(TimeMapper.class);

        mapper.updateTimeStatus(9);

        sqlSession.close();
    }

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> list= mapper.searchAppointTime(2);

        for (Student student : list) {

            System.out.println(student);
        }

        sqlSession.close();
    }
}
