package com.xueyun.service.impl;

import com.xueyun.dao.ResultMapper;
import com.xueyun.entity.Result;
import com.xueyun.service.ResultService;
import com.xueyun.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author XueYun
 * @create 2020-10-26 23:35
 */
public class ResultServiceImpl implements ResultService {

    /**
     * 获得SqlSession对象
     */
    private SqlSession sqlSession = MybatisUtil.getSqlSession();
    /**
     * 通过SqlSession对象，创建ResultMapper接口代理对象
     */
    private ResultMapper mapper = sqlSession.getMapper(ResultMapper.class);

    @Override
    public boolean searchStuStatus(String userSid) {

        List<Result> list=mapper.stuStatus(userSid);

        if(list.isEmpty()){
            sqlSession.close();
            return true;
        }

        for (Result result : list) {
            if(result.getStuStatus()==1){
                sqlSession.close();
                return false;
            }
        }
        sqlSession.close();
        return true;
    }

    @Override
    public void addResult(String userSid, Integer timeId) {

        mapper.addStatus(userSid,timeId,1);
        sqlSession.close();
    }

    @Override
    public void updateResultStatus(Integer rid) {

        mapper.updateResultStatus(rid);
        sqlSession.close();
    }

    @Override
    public void deleteBySid(String userSid) {

        mapper.deleteBySid(userSid);
        sqlSession.close();
    }
}
