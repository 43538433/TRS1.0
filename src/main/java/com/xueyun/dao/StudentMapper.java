package com.xueyun.dao;

import com.xueyun.entity.Student;
import com.xueyun.entity.Tutor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author XueYun
 * @create 2020-10-27 16:40
 */
public interface StudentMapper {

    /**
     * 查询该导师的所有预约信息
     * @param userId 导师的id
     * @return 返回所有预约信息
     */
    List<Student> searchAppointTime(@Param("userId")Integer userId);
}
