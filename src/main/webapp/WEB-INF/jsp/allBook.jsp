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
    <title>书籍列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap 框架的 cdn -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

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
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">新增书籍</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allBook">显示全部书籍</a>
        </div>

        <div class="col-md-8 column">
            <form class="form-inline" action="${pageContext.request.contextPath}/book/queryBookByName" method =
                    "post" style="float:right">
                <%-- span 标签就是用来接收传回前端的错误信息 --%>
                <span style="color:red;font-weight: bold">${error}</span>
                    <span class="span_error">${error}</span>
                <input type="text" name="bookName" class="form-control" placeholder="请输入要查询的书籍的名称">
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
                    <th>数据类型</th>
                    <th>操作</th>

                </tr>
                </thead>

                <tbody>
                <%-- requestScope 是 EL 表达式获取到的 request 域中的数据 --%>
                <c:forEach var="fallback" items="${requestScope.get('fallback')}">
                    <tr>
                        <%-- setter 方法要和实体类中的 setter 方法一致 --%>
                        <td>${fallback.getBid()}</td>
                        <td>${fallback.getBname()}</td>
                        <td>${fallback.getAname()}</td>
                        <td>${fallback.getBdescride()}</td>
                            <td>${fallback.getTname()}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/fallback/toUpdateBook?id=${book.getBookId()}">更改</a>
                            |
                            <a href="${pageContext.request.contextPath}/fallback/deleteBook?id=${book.getBookId()}">删除</a>
<%--                            <a href="#">更改</a> |--%>
<%--                            <a href="#">删除</a>--%>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
