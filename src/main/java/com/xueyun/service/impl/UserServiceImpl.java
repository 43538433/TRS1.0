package com.xueyun.service.impl;

import com.xueyun.dao.ResultMapper;
import com.xueyun.dao.TimeMapper;
import com.xueyun.dao.UserMapper;
import com.xueyun.entity.Tutor;
import com.xueyun.entity.User;
import com.xueyun.exception.CustomerErrorMsgException;
import com.xueyun.service.UserService;
import com.xueyun.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author XueYun
 * @create 2020-10-26 17:26
 */
public class UserServiceImpl implements UserService {

    /**
     * 获得SqlSession对象
     */
    private SqlSession sqlSession = MybatisUtil.getSqlSession();
    /**
     * 通过SqlSession对象，创建UserMapper接口代理对象
     */
    private UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    @Override
    public User login(String name, String sid, String password) throws CustomerErrorMsgException {

        //使用UserMapper接口代理对象完成数据库操作
        User user = mapper.login(sid);

        //如果数据库中查到有该用户，则比对密码和姓名
        if (user != null) {
            if (user.getName().equals(name) && user.getSid().equals(sid) && user.getPassword().equals(password)) {
                sqlSession.close();
                return user;
            } else {
                sqlSession.close();
                throw new CustomerErrorMsgException("用户名或密码错误!");
            }
        } else {
            sqlSession.close();
            throw new CustomerErrorMsgException("该用户不存在!");
        }
    }

    @Override
    public void deleteUser(String sid, int id) {

        try {
            //在user表中删除用户是id的用户
            mapper.deleteById(id);

            //在time表中删除user_id=id的数据
            TimeMapper timeMapper = sqlSession.getMapper(TimeMapper.class);
            timeMapper.deleteByTimeId(id);

            //在result表中删除user_sid=sid的数据
            ResultMapper resultMapper = sqlSession.getMapper(ResultMapper.class);
            resultMapper.deleteBySid(sid);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<User> allUser() {

        List<User> list = mapper.allUser();
        sqlSession.close();
        return list;
    }


}
