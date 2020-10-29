package com.xueyun.service.impl;

import com.xueyun.dao.TimeMapper;
import com.xueyun.entity.Time;
import com.xueyun.service.TimeService;
import com.xueyun.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author XueYun
 * @create 2020-10-26 20:26
 */
public class TimeServiceImpl implements TimeService {

    /**
     * 获得SqlSession对象
     */
    private SqlSession sqlSession = MybatisUtil.getSqlSession();
    /**
     * 通过SqlSession对象，创建TimeMapper接口代理对象
     */
    private TimeMapper mapper = sqlSession.getMapper(TimeMapper.class);

    @Override
    public void addTime(Time time) {

        //使用TimeMapper接口代理对象完成数据库操作
        mapper.addTime(time);
        sqlSession.close();
    }

    @Override
    public void updateTimeStatus(Integer id) {

        mapper.updateTimeStatus(id);
        sqlSession.close();
    }

    @Override
    public void deleteByTimeId(Integer userId) {

        mapper.deleteByTimeId(userId);
        sqlSession.close();
    }


}
