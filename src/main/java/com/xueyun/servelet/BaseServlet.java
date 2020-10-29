package com.xueyun.servelet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author XueYun
 * @create 2020-10-26 17:18
 */
public class BaseServlet extends HttpServlet{
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse) res;

        //获取action
        String action=request.getParameter("action");
        System.out.println("---------------");
        System.out.println("action:"+action);
        System.out.println("---------------");

        //根据获取的action的方法名字，使用反射调用方法自动执行
        //1、获取前端传过来的字节码对象
        Class clazz = this.getClass();

        //根据处理请求方法名字符串获取Method反射对象
        try {
            /* Method getDeclareMethod("方法名"，方法的参数类型...类型)
            根据方法名和参数类型获得一个方法对象，包括private修饰的*/
            Method method = clazz.getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);

            /* void setAccessible(boolean flag)
            暴力反射，设置为可以直接调用私有修饰的成员方法*/
            method.setAccessible(true);

            /* Object invoke(Object obj,Object...args)
            根据参数args调用对象obj的该成员方法
            如果obj=null，则表示该方法是静态方法 */
            method.invoke(this,request,response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
