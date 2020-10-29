package com.xueyun.service;

import com.xueyun.entity.Time;
import com.xueyun.entity.Tutor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author XueYun
 * @create 2020-10-26 20:24
 */
public interface TimeService {

    /**
     * 添加导师时间
     * @param time 时间类
     */
    void addTime(Time time);

    /**
     * 导师审批预约
     * @param id 传入的结果集的id,将对应的status改为2，表示该预约申请已通过
     */
    void updateTimeStatus(Integer id);

    /**
     * 在time表中根据user_id删除导师
     * @param userId 导师的id
     */
    void deleteByTimeId(Integer userId);
}
