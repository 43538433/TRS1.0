package com.xueyun.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * @author XueYun
 * @create 2020-10-25 17:30
 */
public class MybatisUtil {

    private static SqlSessionFactory sqlSessionFactory = null;
    private static ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();

    //初始化 SqlSessionFactory 对象
    static {
        try{
            //1 读取配置文件
            String resource ="mybatis-config.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader );
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    /**
     * 关闭资源并自动提交事务
     * @return SqlSession
     */
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(true);
    }
}
