package com.xueyun.servelet;

import com.xueyun.entity.Time;
import com.xueyun.entity.Tutor;
import com.xueyun.entity.User;
import com.xueyun.exception.CustomerErrorMsgException;
import com.xueyun.service.impl.ResultServiceImpl;
import com.xueyun.service.impl.TimeServiceImpl;
import com.xueyun.service.impl.TutorServiceImpl;
import com.xueyun.service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author XueYun
 * @create 2020-10-26 16:57
 */

@WebServlet(name = "UserServlet", urlPatterns = "/UserServlet")
public class UserServlet extends BaseServlet {

    private UserServiceImpl userService = new UserServiceImpl();
    private TimeServiceImpl timeService = new TimeServiceImpl();
    private TutorServiceImpl tutorService = new TutorServiceImpl();
    private ResultServiceImpl resultService = new ResultServiceImpl();

    /**
     * 实现用户退出登录业务
     *
     * @param request 退出登录请求
     */
    private void loginOut(HttpServletRequest request) {
        //销毁session
        request.getSession().invalidate();
    }

    /**
     * 实现用户登录业务
     *
     * @param request  用户名、工学号与密码
     * @param response status状态
     * @throws CustomerErrorMsgException 登录失败抛出自定义异常
     * @throws IOException               response.getWriter().print()
     */
    private void login(HttpServletRequest request, HttpServletResponse response) throws CustomerErrorMsgException, IOException {

        //从前端页面获取登录的用户名、工学号与密码
        String name = request.getParameter("name");
        String sid = request.getParameter("sid");
        String password = request.getParameter("password");

        User loginUser = userService.login(name, sid, password);

        //登录成功将登录数据写入session
        request.getSession().setAttribute("name", loginUser.getName());
        request.getSession().setAttribute("sid", loginUser.getSid());
        request.getSession().setAttribute("college", loginUser.getCollege());
        request.getSession().setAttribute("id", loginUser.getId());

        //根据不同的status状态进入不同的页面
        int status = loginUser.getStatus();
        if (status == 0) {
            response.getWriter().print("student");
        } else if (status == 1) {
            response.getWriter().print("tutor");
        } else if (status == 2) {
            response.getWriter().print("administrators");
        }
    }

    /**
     * 实现添加时间请求业务
     *
     * @param request 获取表单提交信息
     */
    private void time(HttpServletRequest request) {

        //获取表单提交所有用户数据封装到Time对象中
        String time = request.getParameter("time");

        Integer userId = -1;
        //因为request.getParameter获取的数据为String类型，强制转换userId为Integer型
        if (!"".equals(request.getParameter("userId")) && request.getParameter("userId") != null) {
            Integer id = Integer.parseInt(request.getParameter("userId"));
            userId = id;
        }

        Time time2 = new Time(null, userId, time, 0);

        timeService.addTime(time2);
    }

    /**
     * 实现模糊查询导师业务
     *
     * @param request  获取前端页面传过来的select和key
     * @param response 返回查询到的数据
     * @throws IOException               response.sendRedirect();
     * @throws CustomerErrorMsgException 自定义异常
     */
    private void searchTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException, CustomerErrorMsgException {

        //获取前端页面传过来的参数
        String value = request.getParameter("select");
        String key = request.getParameter("key");

        List<Tutor> list = tutorService.searchTime(value, key);

        if (!list.isEmpty()) {
            //放进session域中
            HttpSession session = request.getSession();
            session.setAttribute("list", list);
            //重定向
            response.sendRedirect("/searchList.jsp");
        } else {
            throw new CustomerErrorMsgException("不存在该数据！请重新查询");
        }
    }

    /**
     * 实现预约请求业务
     *
     * @param request 获取学生的学号和将要预约的时间的id
     * @throws CustomerErrorMsgException 自定义异常
     */
    private void orderTime(HttpServletRequest request) throws CustomerErrorMsgException {

        Integer timeId = -1;
        //因为request.getParameter获取的数据为String类型，强制转换timeId为Integer型
        if (!"".equals(request.getParameter("timeId")) && request.getParameter("timeId") != null) {
            Integer id = Integer.parseInt(request.getParameter("timeId"));
            timeId = id;
        }

        String sid = request.getParameter("sid");
        boolean flag = resultService.searchStuStatus(sid);

        if (flag) {
            resultService.addResult(sid, timeId);
        } else {
            throw new CustomerErrorMsgException("您已有预约申请，待老师审核后才可继续预约！");
        }
    }

    /**
     * 实现查看预约记录业务
     *
     * @param request  获取学生的sid
     * @param response 返回查询到的预约记录集合
     * @throws IOException               response.sendRedirect()
     * @throws CustomerErrorMsgException 自定义异常
     */
    private void sAppointTime(HttpServletRequest request, HttpServletResponse response) throws IOException, CustomerErrorMsgException {

        //获取学生的sid
        String sid = request.getParameter("sid");

        List<Tutor> list = tutorService.searchAppointTime(sid);

        if (!list.isEmpty()) {
            //放进session域中
            HttpSession session = request.getSession();
            session.setAttribute("list2", list);
            //重定向
            response.sendRedirect("/sAppointTime.jsp");
        } else {
            throw new CustomerErrorMsgException("不存在该数据！请重新查询");
        }
    }

    /**
     * 实现导师审批业务
     *
     * @param request 获取timeId和resultId
     */
    private void dealAppoint(HttpServletRequest request) {

        Integer timeId = -1;
        Integer resultId = -1;
        //因为request.getParameter获取的数据为String类型，强制转换为Integer型
        if (!"".equals(request.getParameter("timeId")) && request.getParameter("timeId") != null) {
            Integer id1 = Integer.parseInt(request.getParameter("timeId"));
            timeId = id1;
        }
        if (!"".equals(request.getParameter("resultId")) && request.getParameter("resultId") != null) {
            Integer id2 = Integer.parseInt(request.getParameter("resultId"));
            resultId = id2;
        }

        //带调用service里的方法实现业务
        timeService.updateTimeStatus(timeId);
        resultService.updateResultStatus(resultId);
    }

    /**
     * 管理员删除用户
     *
     * @param request 获取该用户的id和sid
     */
    private void searchAllUser(HttpServletRequest request) {

        String sid = request.getParameter("sid");
        Integer id = -1;
        //因为request.getParameter获取的数据为String类型，强制转换timeId为Integer型
        if (!"".equals(request.getParameter("id")) && request.getParameter("id") != null) {
            Integer id2 = Integer.parseInt(request.getParameter("id"));
            id = id2;
        }

        //调用方法删除用户
        userService.deleteUser(sid, id);
    }

    /**
     * 管理员查询所有的预约信息
     *
     * @param request 接收预约请求
     * @param response 返回查询到的数据
     * @throws IOException response.sendRedirect
     * @throws CustomerErrorMsgException 自定义异常
     */
    private void searchAllStuAppointTime(HttpServletRequest request, HttpServletResponse response) throws IOException, CustomerErrorMsgException {

        List<Tutor> list = tutorService.searchAllStuAppointTime();

        if (!list.isEmpty()) {
            //放进session域中
            HttpSession session = request.getSession();
            session.setAttribute("list2", list);
            //重定向
            response.sendRedirect("/searchAllTime.jsp");
        } else {
            throw new CustomerErrorMsgException("还未有预约数据!");
        }
    }

}
