<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: 86135
  Date: 2020/10/17
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>查看预约请求</title>
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" href="css/home.css">
    <!--导入jquery-->
    <script src="js/jquery-3.3.1.min.js"></script>
    <!--导入将jq对象转换为json字符串插件-->
    <script type="text/javascript" src="js/json.js"></script>

    <style type="text/css">
        .box2 {
            float: left;
            padding: 20px 20px;
            letter-spacing: 30px
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

        input {
            box-sizing: border-box;
            border: 2px solid #8ad8e1;
            border-radius: 10px;
            font-size: 15px;
            padding: 10px 40px;
            letter-spacing: 3px
        }
    </style>

    <script type="text/javascript">
        $(function () {
            $("#timeBtn").click(function () {
                //提交异步请求给后端
                $.post({
                    url: "UserServlet",
                    data: $("#appointTimeForm").serialize(),
                    success: function (result) {
                        alert("查询成功")
                    },
                    error: function () {
                        alert("查询失败");
                    }
                });
            })
        });
    </script>
</head>
<body>
<hr color="#9a0000" width=100%/>
<div class="box2">
    <font color="#9a0000" size="20">欢迎登录导师预约系统</font>
</div>
<hr size="55px" noshade=false width="100%" color="#9a0000"/>

<form id="appointTimeForm" method="post">
    <input type="hidden" id="sAppointTime" name="action" value="searchAllStuAppointTime">
    <center><input id="timeBtn" type="button" class="submit" value="查询预约记录"></center>
</form>

<table>

    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>学号</th>
        <th>专业</th>
        <th>预约时间</th>
        <th>预约状态</th>
    </tr>

    <%--使用forEach遍历元素--%>
    <c:choose>
    <c:when test="${empty list2}">
        <tr>
            <td colspan="5">暂无预约数据</td>
        </tr>
    </c:when>
    <c:otherwise>
    <c:forEach items="${list2}" var="c" varStatus="row">
    <tr>
        <td>${row.index+1}</td>
        <td>${c.name}</td>
        <td>${c.sid}</td>
        <td>${c.grade}</td>
        <td>${c.time}</td>
        <td>${c.status}</td>
        </c:forEach>
        </c:otherwise>
        </c:choose>

</table>
<div>
    <a href="home03.jsp">返回首页</a>
</div>
</body>
</html>