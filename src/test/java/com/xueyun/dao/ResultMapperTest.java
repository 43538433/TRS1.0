package com.xueyun.dao;

import com.xueyun.entity.Result;
import com.xueyun.entity.Tutor;
import com.xueyun.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

/**
 * @author XueYun
 * @create 2020-10-25 23:38
 */
public class ResultMapperTest {
    private Logger logger = Logger.getLogger(ResultMapperTest.class);

    @Test
    public void stuStatusTest() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        ResultMapper mapper = sqlSession.getMapper(ResultMapper.class);
        List<Result> list = mapper.stuStatus("3219005060");

        for (Result result : list) {
            int status = result.getStuStatus();
            if (status == 1) {
                System.out.println("已有预约，不能重复预约！");
            }
            System.out.println("-------------------");
            System.out.println("status:" + status);
            System.out.println(result);

        }
        sqlSession.close();
    }

    @Test
    public void addStatusTest() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        ResultMapper mapper = sqlSession.getMapper(ResultMapper.class);

        int row = mapper.addStatus("3219005064", 5, 1);
        System.out.println("影响行数：" + row);
        sqlSession.close();
    }

    @Test
    public void deleteBySidTest() {
        SqlSession session = MybatisUtil.getSqlSession();

        ResultMapper mapper = session.getMapper(ResultMapper.class);

        mapper.deleteBySid("3219005084");
        session.close();
    }

    @Test
    public void updateResultStatusTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        ResultMapper mapper = sqlSession.getMapper(ResultMapper.class);

        mapper.updateResultStatus(9);

        sqlSession.close();
    }
}
