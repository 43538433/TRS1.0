<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: 86135
  Date: 2020/10/17
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>审批用户</title>
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
            color: #9a0000;
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

        input{
            color: #9b0202;
            box-sizing: border-box;
            border: 2px solid #9a0000;
            font-size: 15px;
            border-radius: 5px;
            padding: 9px 15px;
        }
        input[disabled] {
            color: #e8d5e0;
            font-size: 15px;
            opacity:1
        }
    </style>

    <script type="text/javascript">
        $(function () {
            $(".submit").each(function () {
                $(this).click(function () {
                    var r = confirm("是否确定删除该用户，请谨慎操作！")
                    if (r == true) {
                    //获取变化的button的id，拼接起来成为表单的id
                    var keyId = $(this).attr('id');
                    var indexId = 'allUserForm' + keyId;

                    //让点击一次后的按钮不能再次点击
                    var btn = document.getElementById(keyId);
                    btn.disabled = true;

                    $.post({
                        url: "UserServlet",
                        data: $("#" + indexId).serialize(),
                        success: function (result) {
                            alert("删除成功")
                        },
                        error: function () {
                            alert("删除失败");
                        }
                    });
                }else {
                        alert("已取消")
                    }
                })
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

<table>

    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>学号</th>
        <th>学院</th>
        <th>专业</th>
        <th>联系电话</th>
        <th>用户权限</th>
        <th>操作</th>
    </tr>

    <%--使用forEach遍历元素--%>
    <c:choose>
        <c:when test="${empty list}">
            <tr>
                <td colspan="5">暂无数据，请重新查询</td>
            </tr>
        </c:when>
        <c:otherwise>
            <c:forEach items="${list}" var="c" varStatus="row">

                <form id="allUserForm${row.index}" method="post">
                    <input type="hidden" id="allUser${row.index}" name="action" value="searchAllUser">
                    <tr>
                        <td>${row.index+1}</td>
                        <td>${c.name}</td>
                        <td>${c.sid}</td>
                        <td>${c.college}</td>
                        <td>${c.grade}</td>
                        <td>${c.tel}</td>
                        <td>${c.status}</td>
                        <input type="hidden" id="sid" name="sid" value="${c.sid}">
                        <input type="hidden" id="id" name="id" value="${c.id}">
                        <td>
                            <input id="${row.index}" type="button" class="submit" value="删除该用户">
                        </td>
                    </tr>
                </form>

            </c:forEach>
        </c:otherwise>
    </c:choose>
</table>

<div>
    <a href="home03.jsp">返回首页</a>
</div>
</body>
</html>
