package com.xueyun.service;


/**
 * @author XueYun
 * @create 2020-10-26 23:34
 */
public interface ResultService {

    /**
     * 在result表中查看该学生的预约记录
     * @param userSid 学生的学号
     * @return 是否可以进行预约
     */
    boolean searchStuStatus(String userSid);

    /**
     *将学生的预约结果插入result表中
     * @param userSid 学生的sid
     * @param timeId 该条时间的id
     */
    void addResult(String userSid,Integer timeId);

    /**
     * 导师审批预约
     * @param rid 传入的结果集的id,将对应的status改为2，表示该预约申请已通过
     */
    void updateResultStatus(Integer rid);

    /**
     * 根据sid在result表中删除学生
     * @param userSid 学生的学号
     */
    void deleteBySid(String userSid);
}
