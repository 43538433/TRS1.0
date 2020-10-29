package com.xueyun.service.impl;

import com.xueyun.dao.StudentMapper;
import com.xueyun.dao.TimeMapper;
import com.xueyun.entity.Student;
import com.xueyun.entity.Tutor;
import com.xueyun.service.StudentService;
import com.xueyun.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XueYun
 * @create 2020-10-27 16:52
 */
public class StudentServiceImpl implements StudentService {

    /**
     * 获得SqlSession对象
     */
    private SqlSession sqlSession = MybatisUtil.getSqlSession();
    /**
     * 通过SqlSession对象，创建TimeMapper接口代理对象
     */
    private StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

    @Override
    public List<Student> searchAppointTime(Integer userId) {

        //使用StudentMapper接口代理对象完成数据库操作
        List<Student> list = mapper.searchAppointTime(userId);

        //初始化一个集合，用于返回集合
        List<Student> list2 = new ArrayList<Student>();

        for (Student student : list) {
            String name = student.getName();
            String sid = student.getUserSid();
            String college = student.getCollege();
            String time = student.getTime();
            Integer status0 = student.getTStatus();
            Integer id=student.getId();
            Integer rid=student.getRid();

            String status = "审批中";
            switch (status0) {
                case 0:
                    status = "审批未通过";
                    break;
                case 1:
                    status = "审批中";
                    break;
                case 2:
                    status = "审批通过";
                    break;
                default:
                    status = "状态出错";
            }

            Student student1 = new Student(name,sid,college,time,null,status,id,rid,1);
            list2.add(student1);
        }

        sqlSession.close();
        return list2;
    }
}
