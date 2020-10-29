package com.xueyun.dao;

import com.xueyun.entity.User;
import com.xueyun.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;

/**
 * @author XueYun
 * @create 2020-10-25 18:10
 */
public class UserMapperTest {

    private Logger logger= Logger.getLogger(UserMapperTest.class);
    @Test
    public void loginTest() {
        SqlSession session = MybatisUtil.getSqlSession();

        UserMapper mapper = session.getMapper(UserMapper.class);

        User user = mapper.login("3219005084");
        System.out.println("--------------------------");
        System.out.println(user);
        session.close();
    }

    @Test
    public void deleteByIdTest() {
        SqlSession session = MybatisUtil.getSqlSession();

        UserMapper mapper = session.getMapper(UserMapper.class);

        mapper.deleteById(9);
        session.close();
    }
}
