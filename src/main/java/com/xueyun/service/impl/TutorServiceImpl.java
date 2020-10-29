package com.xueyun.service.impl;

import com.xueyun.dao.TimeMapper;
import com.xueyun.dao.TutorMapper;
import com.xueyun.entity.Tutor;
import com.xueyun.service.TutorService;
import com.xueyun.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XueYun
 * @create 2020-10-26 21:09
 */
public class TutorServiceImpl implements TutorService {

    /**
     * 获得SqlSession对象
     */
    private SqlSession sqlSession = MybatisUtil.getSqlSession();
    /**
     * 通过SqlSession对象，创建TutorMapper接口代理对象
     */
    private TutorMapper mapper = sqlSession.getMapper(TutorMapper.class);

    @Override
    public List<Tutor> searchTime(String value, String key) {

        String select1 = "all";
        String select2 = "name";
        String select3 = "college";
        String select4 = "time";
        //拼接字符串
        String changeKey = "%" + key + "%";

        //使用TimeMapper接口代理对象完成数据库操作
        if (value.equals(select1)) {

            List<Tutor> list1 = mapper.searchAllTime();
            sqlSession.close();
            return list1;

        } else if (value.equals(select2)) {

            List<Tutor> list2 = mapper.searchByName(changeKey);
            sqlSession.close();
            return list2;

        } else if (value.equals(select3)) {

            List<Tutor> list3 = mapper.searchByCollege(changeKey);
            sqlSession.close();
            return list3;

        } else {
            List<Tutor> list4 = mapper.searchByTime(changeKey);
            sqlSession.close();
            return list4;
        }
    }

    @Override
    public List<Tutor> searchAppointTime(String userSid) {

        List<Tutor> list = mapper.searchAppointTime(userSid);

        //初始化一个集合，用于返回集合
        List<Tutor> list2 = new ArrayList<Tutor>();

        for (Tutor tutor : list) {
            String name = tutor.getName();
            String college = tutor.getCollege();
            String time = tutor.getTime();
            int status0 = tutor.getStuStatus();

            String status = "审批中";
            switch (status0) {
                case 0:
                    status = "审批未通过";
                    break;
                case 1:
                    status = "待审批";
                    break;
                case 2:
                    status = "审批已通过";
                    break;
                default:
                    status = "状态出错";
            }

            //将老师的信息再次封装到tutor实体类中
            Tutor tutor2 = new Tutor(null,null,null,name, college, time, status,null);
            list2.add(tutor2);
        }
        sqlSession.close();
        return list2;
    }

    @Override
    public List<Tutor> searchAllStuAppointTime() {

        List<Tutor> list=mapper.searchAllStuAppointTime();

        //初始化一个集合，用于返回集合
        List<Tutor> list2 = new ArrayList<Tutor>();

        for (Tutor tutor : list) {
            String name = tutor.getName();
            String sid = tutor.getSid();
            String grade = tutor.getGrade();
            String time = tutor.getTime();

            int status0 = tutor.getStuStatus();

            String status = "审批中";
            switch (status0) {
                case 0:
                    status = "审批未通过";
                    break;
                case 1:
                    status = "待审批";
                    break;
                case 2:
                    status = "审批通过";
                    break;
                default:
                    status = "状态出错";
            }

            //将老师的信息再次封装到tutor实体类中
            Tutor tutor2 = new Tutor(null,sid,grade,name, null, time, status,null);
            list2.add(tutor2);
        }

        sqlSession.close();
        return list2;
    }
}
