<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: L1223
  Date: 2022-07-09
  Time: 2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap 框架的 cdn -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- 原来还必须引入 JQuery 这个 js 的库 -->
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<%--
<div><shiro:guest>&lt;%&ndash;当用户没有登录的时候，这个标签中的内容会展示出来&ndash;%&gt;访客登录</shiro:guest></div>
<div><shiro:guest><a href="book/allBook">去登录</a></shiro:guest></div>
<div><shiro:authenticated>如果当前用户通过用户名密码认证了，那么这个标签中的内容就会展示出来</shiro:authenticated></div>
&lt;%&ndash;<shiro:principal/> 展示当前登录用户名&ndash;%&gt;
<div><shiro:authenticated>欢迎 <shiro:principal/></shiro:authenticated></div>
<div><shiro:user>如果是通过 RememberMe 或者用户名密码的方式认证的，那么这个标签中的内容就会展示出来</shiro:user></div>
<div><shiro:user>欢迎 <shiro:principal/>（RememberMe 登录）</shiro:user></div>

<shiro:hasRole name="admin"><shiro:principal/>具备管理员角色</shiro:hasRole>
<shiro:hasRole name="user"><shiro:principal/>具备user角色</shiro:hasRole>
<div><shiro:user>
    <a href="/book/selectUser">selectUser</a> <br>
</shiro:user></div>

<shiro:authenticated>
    &lt;%&ndash;这些超链接，必须以用户名密码登录的方式登录成功之后，才可以点击&ndash;%&gt;
    <shiro:hasPermission name="user:delete">
        <a href="/book/deleteUser">deleteUser</a> <br>
    </shiro:hasPermission>
    <shiro:hasPermission name="user:update">
        <a href="/book/updateUser">updateUser</a> <br>
    </shiro:hasPermission>
    <shiro:hasPermission name="user:add">
        <a href="/book/addUser">addUser</a> <br>
    </shiro:hasPermission>
</shiro:authenticated>
<shiro:user>
    <a href="/book/rememberMe">rememberMe</a> <br>
    <a href="/book/logout">注销登录</a>
</shiro:user>
--%>

<style type="text/css">
    .top{
        /* 设置宽度高度背景颜色 */
        height: 50px;
        width:100%;
        background:rgb(189, 181, 181);
        position: fixed; /*固定在顶部*/
        top: 0;/*离顶部的距离为0*/
    }
    .top ul{
        /* 清除ul标签的默认样式 */
        width: 80%;
        list-style-type: none;
        margin: 0;
        padding: 0;
        overflow: hidden;

    }
    .top li {
        float:left; /* 使li内容横向浮动，即横向排列  */
        margin-right:50px;  /* 两个li之间的距离*/
    }

    .top li a{
        /* 设置链接内容显示的格式*/
        display: block; /* 把链接显示为块元素可使整个链接区域可点击 */
        color:white;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none; /* 去除下划线 */
    }
    .top li a:hover{
        /* 鼠标选中时背景变为黑色 */
        background-color: #111;
    }
    .top ul li ul{
        /* 设置二级菜单 */
        width: auto;
        background:rgb(189, 181, 181);
        position: absolute;
        display: none; /* 默认隐藏二级菜单的内容 */

    }
    .top ul li ul li{
        /* 二级菜单li内容的显示 */
        margin-right:0;
        float:none;
        text-align: center;
    }
    .top ul li:hover ul{
        /* 鼠标选中二级菜单内容时 */
        display: block;
    }
    .dddd{
        height: 150px;
    }
</style>
<body>


<div class="dddd"></div>



<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>用户列表 —— 显示所有用户</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 column">
            <shiro:hasPermission name="user:add">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/addbook">新增用户</a>
            </shiro:hasPermission>


            <a class="btn btn-primary" href="${pageContext.request.contextPath}/allBook">显示全部用户</a>
        </div>

        <div class="col-md-8 column">
            <form class="form-inline" action="${pageContext.request.contextPath}/queryBookByName" method =
                    "post" style="float:right">
                <%-- span 标签就是用来接收传回前端的错误信息 --%>
                <span style="color:red;font-weight: bold">${error}</span>
                <input type="text" name="name" class="form-control" placeholder="请输入要查询的用户的名称">
                <input type="submit" value="查询" class="btn btn-primary">
            </form>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>用户编号</th>
                    <th>用户名</th>
                    <th>角色</th>
                    <th>权限</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <%-- requestScope 是 EL 表达式获取到的 request 域中的数据 --%>
                <c:forEach var="UserPermission" items="${requestScope.get('UserPermission')}">
                    <tr>
                            <%-- setter 方法要和实体类中的 setter 方法一致 --%>
                        <td>${UserPermission.getUid()}</td>
                        <td>${UserPermission.getUname()}</td>
                        <td>${UserPermission.getRname()}</td>
                        <td>${UserPermission.getName()}</td>
                        <td>
                                <%--权限--%>
                            <shiro:hasPermission name="user:update">
                                <a href="${pageContext.request.contextPath}/toUpdateBook?id=${UserPermission.getUid()}">更改</a>
                            </shiro:hasPermission>
                            <shiro:hasPermission name="user:delete">
                                <a href="${pageContext.request.contextPath}/deleteBook?bid=${UserPermission.getUid()}">删除</a>
                            </shiro:hasPermission>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


            <a href="${pageContext.request.contextPath}/allBook">首页</a>

            <c:if test="${pageNum>1}">
            <a href="${pageContext.request.contextPath}/allBook?pageNum=${pageNum-1}"> 上一页</a>
            </c:if>

            <c:if test="${pageNum<pages}">
            <a href="${pageContext.request.contextPath}/allBook?pageNum=${pageNum+1}">下一页</a>
            </c:if>


            <a href="${pageContext.request.contextPath}/allBook?pageNum=${pages}">末页</a>
</body>
</div>
</div>
</div>
</body>
</html>
</body>
<script>
    $(function () {
        $("#about-dialog-button-bar").click(function () {
            window.alert("订阅成功")
        })

    });
</script>
</html>
