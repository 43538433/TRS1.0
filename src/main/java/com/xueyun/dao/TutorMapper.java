package com.xueyun.dao;

import com.xueyun.entity.Tutor;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author XueYun
 * @create 2020-10-25 20:45
 */
public interface TutorMapper {

    /**
     * 查询所有状态为1和0的时间
     * @return Tutor
     */
    List<Tutor> searchAllTime();

    /**
     * 根据导师姓名模糊查询导师时间
     * @param name 导师姓名
     * @return List集合
     */
    List<Tutor> searchByName(@Param("name")String name);

    /**
     * 根据学院模糊查询导师时间
     * @param college 导师的学院
     * @return List集合
     */
    List<Tutor> searchByCollege(@Param("college")String college);

    /**
     * 根据时间模糊查询导师时间
     * @param time 导师的学院
     * @return List集合
     */
    List<Tutor> searchByTime(@Param("time")String time);

    /**
     * 查询该学生的所有预约信息
     * @param userSid 学生的学号
     * @return 返回该学生的所有预约信息
     */
    List<Tutor> searchAppointTime(@Param("userSid")String userSid);

    /**
     * 管理员查询所有学生的预约信息
     * @return 返回一个Tutor集合
     */
    List<Tutor> searchAllStuAppointTime();

}
