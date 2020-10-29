package com.xueyun.dao;

import com.xueyun.entity.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author XueYun
 * @create 2020-10-25 17:18
 */
public interface ResultMapper {

    /**
     *在result表中查看学生的预约状态
     * @param userSid 学生的学号
     * @return Tutor
     */
    List<Result> stuStatus(@Param("userSid")String userSid);

    /**
     * 添加学生的预约状态
     * @param userSid 学生的学号
     * @param timeId 预约的时间id
     * @param stuStatus 修改后的学生预约状态
     * @return 影响行数
     */
    int addStatus(@Param("userSid")String userSid,@Param("timeId")Integer timeId,@Param("stuStatus")Integer stuStatus);

    /**
     * 根据sid在result表中删除学生
     * @param userSid 学生的学号
     */
    void deleteBySid(@Param("userSid")String userSid);


    /**
     * 导师审批预约
     * @param rid 传入的结果集的id,将对应的status改为2，表示该预约申请已通过
     */
    void updateResultStatus(@Param("rid")Integer rid);
}
