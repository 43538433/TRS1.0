package com.xueyun.dao;

import com.xueyun.entity.Time;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author XueYun
 * @create 2020-10-25 17:18
 */
public interface TimeMapper {

    /**
     * 添加导师时间
     * @param time 导师的id和时间
     * @return 影响的行数，大于0表示添加成功
     */
    int addTime(Time time);

    /**
     * 在time表中根据user_id删除导师
     * @param userId 导师的id
     */
    void deleteByTimeId(@Param("userId")Integer userId);

    /**
     * 导师审批预约
     * @param id 传入的结果集的id,将对应的status改为2，表示该预约申请已通过
     */
    void updateTimeStatus(@Param("id")Integer id);
}
