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
<div><shiro:guest>当用户没有登录的时候，这个标签中的内容会展示出来</shiro:guest></div>
<div><shiro:guest><a href="/day13_war/login">去登录</a></shiro:guest></div>
<div><shiro:authenticated>如果当前用户通过用户名密码认证了，那么这个标签中的内容就会展示出来</shiro:authenticated></div>
<%--<shiro:principal/> 展示当前登录用户名--%>
<div><shiro:authenticated>欢迎 <shiro:principal/></shiro:authenticated></div>
<div><shiro:user>如果是通过 RememberMe 或者用户名密码的方式认证的，那么这个标签中的内容就会展示出来</shiro:user></div>
<div><shiro:user>欢迎 <shiro:principal/>（RememberMe 登录）</shiro:user></div>

<shiro:hasRole name="admin"><shiro:principal/>具备管理员角色</shiro:hasRole>
<shiro:hasRole name="user"><shiro:principal/>具备user角色</shiro:hasRole>
<div><shiro:user>
    <a href="/day13_war/selectUser">selectUser</a> <br>
</shiro:user></div>

<shiro:authenticated>
    <%--这些超链接，必须以用户名密码登录的方式登录成功之后，才可以点击--%>
    <shiro:hasPermission name="user:delete">
        <a href="/day13_war/deleteUser">deleteUser</a> <br>
    </shiro:hasPermission>
    <shiro:hasPermission name="user:update">
        <a href="/day13_war/updateUser">updateUser</a> <br>
    </shiro:hasPermission>
    <shiro:hasPermission name="user:add">
        <a href="/day13_war/addUser">addUser</a> <br>
    </shiro:hasPermission>
</shiro:authenticated>
<shiro:user>
    <a href="/day13_war/rememberMe">rememberMe</a> <br>
    <a href="/day13_war/logout">注销登录</a>
</shiro:user>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表 —— 显示所有书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 column">
            <shiro:hasPermission name="user:add">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/addbook">新增书籍</a>
            </shiro:hasPermission>


            <a class="btn btn-primary" href="${pageContext.request.contextPath}/allBook">显示全部书籍</a>
        </div>

        <div class="col-md-8 column">
            <form class="form-inline" action="${pageContext.request.contextPath}/queryBookByName" method =
                    "post" style="float:right">
                <%-- span 标签就是用来接收传回前端的错误信息 --%>
                <span style="color:red;font-weight: bold">${error}</span>
                <input type="text" name="name" class="form-control" placeholder="请输入要查询的书籍的名称">
                <input type="submit" value="查询" class="btn btn-primary">
            </form>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>书籍名字</th>
                    <th>作者</th>
                    <th>书籍详情</th>
                    <th>书籍类型</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <%-- requestScope 是 EL 表达式获取到的 request 域中的数据 --%>
                <c:forEach var="fallback" items="${requestScope.get('fallback')}">
                    <tr>
                            <%-- setter 方法要和实体类中的 setter 方法一致 --%>
                                <td>${fallback.bid}</td>
                                <td>${fallback.bname}</td>
                                <td>${fallback.aname}</td>
                                <td>${fallback.bdescribe}</td>
                                <td>${fallback.tname}</td>
                        <td>
                            <%--权限--%>
                            <shiro:hasPermission name="user:update">
                                <a href="${pageContext.request.contextPath}/toUpdateBook?id=${fallback.bid}">更改</a>
                            </shiro:hasPermission>
                            <shiro:hasPermission name="user:delete">
                                <a href="${pageContext.request.contextPath}/deleteBook?id=${fallback.bid}">删除</a>
                            </shiro:hasPermission>
                                <a href="${pageContext.request.contextPath}/Lookbooks?id=${fallback.bid}" id="about-dialog-button-bar">订阅</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <nav aria-label="Page navigation">

                <ul class="pagination pagination-lg" style="padding-left: 40%">
                    <li>
                        <c:if test="${users.pageNum!=1}">
                            <a href="findAll?currPage=${users.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">上一页</span>
                            </a>
                        </c:if>
                    </li>
                    <c:forEach begin="1" end="${users.pages}" var="page">
                        <li><a href="findAll?currPage=${page}">${page}</a></li>
                    </c:forEach>
                    <li>
                        <c:if test="${users.pageNum<users.pages}">
                            <a href="findAll?currPage=${users.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">下一页</span>
                            </a>
                        </c:if>
                    </li>
                </ul>
            </nav>

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
