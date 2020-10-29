<%--
  Created by IntelliJ IDEA.
  User: 86135
  Date: 2020/5/13
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%
    String path = request.getContextPath();
    //获得应用的根url,以后寻找资源的相对路径就是<base>所描述的
    String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>添加时间</title>
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" href="css/home.css">
    <!--导入jquery-->
    <script src="js/jquery-3.3.1.min.js"></script>
    <!--导入将jq对象转换为json字符串插件-->
    <script type="text/javascript" src="js/json.js"></script>

    <style type="text/css">
        .box2 {
            float: left;
            padding: 0px 0px;
            letter-spacing: 30px
        }

        input {
            box-sizing: border-box;
            border: 2px solid #8ad8e1;
            border-radius: 5px;
            padding: 9px 15px;
        }

        table {
            border: 5px solid;
            color: #8ad8e1;
            margin: auto;
            width: 1000px;
        }

        td, th {
            text-align: center;
            border: 2px solid;
        }

        div {
            text-align: center;
            margin: 20px;
        }
    </style>

    <script type="text/javascript">
        $(function () {
            $("#addBtn").click(function () {
                $.post({
                    url: "UserServlet",
                    data: $("#timeForm").serialize(),
                    success: function (result) {
                        //获取服务器异步请求返回的结果
                        if (result == "true") {
                            //结果1：返回true
                            alert("添加成功");
                        } else {
                            //结果2：返回失败的消息，更新到页面上显示让用户解决
                            alert("添加失败")
                        }
                    },
                    error: function () {
                        //结果3：返回系统异常，在error回调函数中弹出服务器忙
                        alert("服务器忙");
                    }
                });
            });
        });
    </script>
</head>
<body>

<hr color="#9a0000" width=100%/>

<div class="box2">
    <font color="#9a0000" size="20">欢迎登录导师预约系统</font>
</div>
<hr size="55px" noshade=false width="100%" color="#9a0000"/>

<form id="timeForm" method="post">
    <!--增加一个表单项存储请求标识符数据action-->
    <input type="hidden" name="action" value="time">
    <div>
        <%String name = (String) session.getAttribute("name");%>
        <%String sid = (String) session.getAttribute("sid");%>
        <%String college = (String) session.getAttribute("college");%>
        <%Integer user_id = (Integer) session.getAttribute("id");%>
        <input type="text" id="name" name="name" disabled="disabled" value="<%=name%>">
        <input type="text" id="sid" name="sid" disabled="disabled" value="<%=sid%>">
        <input type="text" id="college" name="college" disabled="disabled" value="<%=college%>">
        <input type="hidden" id="id" name="userId" value="<%=user_id%>">
        <input type="date" id="time" name="time" placeholder="请输入时间" value="<fmt:formatDate value="${Time}" pattern="yyyy-MM-dd"/>">
        <input type="button" value="添加" id="addBtn" class="submit">
    </div>
</form>

<table>
    <caption><b><font size="5px">时间添加信息表</font></b></caption>
    <tr>
        <th>姓名</th>
        <th>学号</th>
        <th>学院</th>
        <th>时间</th>
        <th>操作</th>
    </tr>

    <tr>
        <td>xxx</td>
        <td>xxxxxxxxxx</td>
        <td>计算机学院</td>
        <td>2020-05-08</td>
        <td>
            删除
        </td>
    </tr>
</table>

<script>
    /**
     分析：
     1.添加：
     1.给添加按钮绑定单击事件
     2.获取文本框的内容
     3.创建td,设置td的文本为文本框的内容
     4.创建tr
     5.将td添加到tr中
     6.获取table，将tr添加到table中
     2.删除
     1.确定点击的是哪个超链接
     2.removeChild();通过父节点删除子节点
     */

    //1.获取addBtn按钮
    document.getElementById("addBtn").onclick = function () {
        //2.获取文本框的内容
        var name = document.getElementById("name").value;
        var sid = document.getElementById("sid").value;
        var college = document.getElementById("college").value;
        var time = document.getElementById("time").value;

        //3.创建td,赋值td的标签
        //name的td
        var td_name = document.createElement("td");
        var text_name = document.createTextNode(name);
        td_name.appendChild(text_name);
        //sid的td
        var td_sid = document.createElement("td");
        var text_sid = document.createTextNode(sid);
        td_sid.appendChild(text_sid);
        //college的td
        var td_college = document.createElement("td");
        var text_college = document.createTextNode(college);
        td_college.appendChild(text_college);
        //time的td
        var td_time = document.createElement("td");
        var text_time = document.createTextNode(time);
        td_time.appendChild(text_time);
        //a标签的td
        var td_a = document.createElement("td");
        var ele_a = document.createElement("a");
        ele_a.setAttribute("href", "javascript:void(0);");
        ele_a.setAttribute("onclick", "delTr(this);");
        var text_a = document.createTextNode("删除");
        ele_a.appendChild(text_a);
        td_a.appendChild(ele_a);

        //4.创建tr
        var tr = document.createElement("tr");

        //5.添加td到tr中
        tr.appendChild(td_name);
        tr.appendChild(td_sid);
        tr.appendChild(td_college);
        tr.appendChild(td_time);
        tr.appendChild(td_a);

        //6.获取table
        var table = document.getElementsByTagName("table")[0];
        table.appendChild(tr);
    }

    //删除方法
    function delTr(obj) {
        //获取的父节点(td)的父节点的(tr)的父节点(table)
        var table = obj.parentNode.parentNode.parentNode;
        var tr = obj.parentNode.parentNode;
        table.removeChild(tr);
    }
</script>

<div>
    <a href="home02.jsp">返回首页</a>
</div>

</body>
</html>
