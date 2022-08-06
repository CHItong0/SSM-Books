<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>修改信息</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- 引入 Bootstrap -->
  <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

  <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<div class="container">

  <div class="row clearfix">
    <div class="col-md-12 column">
      <div class="page-header">
        <h1>
          <small>修改信息</small>

        </h1>
        <span class="errorMsg" style="color:red;font-weight: bold"></span>
      </div>
    </div>
  </div>

  <form action="${pageContext.request.contextPath}/upMeans" method="post">
    <%-- 只有在表单提交时在隐藏域中增加 bookId 信息，保存到数据库的时候才不会出错 --%>
    <%-- 不能使用 ${book.bookId()} 来获得数据，因为 bookId 是私有变量  --%>
    <input type="hidden" name="uid" value="${user1.uid}"/>
    用户名：<input type="text" name="uname" id="uname" value="${user1.uname}"/>
    密码：<input type="password" name="upassword" id="upassword" value="${user1.upassword}"/>
    邮箱：<input type="text" name="Email"  id="Email" value="${user1.email}"/>
      手机号：<input type="text" name="Phone"  id="Phone" value="${user1.phone}"/>

    <%--书籍详情：<input type="text" name="detail" value="${book.getDetail() }"/>--%>
    <input type="submit" id="sub_btn" value="修改信息"/>
  </form>
  <div>
    <div>订阅书籍信息</div>
    <table class="table table-hover table-striped">
      <thead>
      <tr>
        <th>书籍编号</th>
        <th>书籍名字</th>

      </tr>
      </thead>

      <tbody>
      <%-- requestScope 是 EL 表达式获取到的 request 域中的数据 --%>
      <c:forEach var="book" items="${requestScope.get('book')}">
        <tr>
            <%-- setter 方法要和实体类中的 setter 方法一致 --%>
          <td>${book.getBid()}</td>
          <td>${book.getBname()}</td>

          <td>
            <a href="${pageContext.request.contextPath}/deleteUserBook?id=${book.getBid()}">取消订阅</a>
                                          <%--<a href="#">更改</a> |
                                          <a href="#">删除</a>--%>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>

  </div>

  <script>
    $(function () {
      $("#sub_btn").click(function () {

        // 正则表达式参考：https://zhuanlan.zhihu.com/p/83080230
        var bookName = $("#uname").val();
        // 只能为汉字
        var bookNamePatt = /^[\u4E00-\u9FA5A-Za-z0-9]+$/;
        if(!bookNamePatt.test(bookName)){
          $("span.errorMsg").text("用户名不能出现特殊符号！");
          return false;
        }

        var bookAname = $("#upassword").val();

        var bookCountPatt1 = /^[A-Za-z0-9]+$/;
        if(!bookCountPatt1.test(bookAname)){
          $("span.errorMsg").text("密码不能出现特殊符号");
          return false;
        }

        var bookBdescribe = $("#Email").val();
        // 非负整数
        var bookCountPatt2 = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        if(!bookCountPatt2.test(bookBdescribe)){
          $("span.errorMsg").text("邮箱不合法");
          return false;
        }
        var bookTname = $("#Phone").val();
        // 非负整数
        var bookCountPatt3 = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
        if(!bookCountPatt3.test(bookTname)){
          $("span.errorMsg").text("手机号不合法");
          return false;
        }



        alert("修改成功")

        // 去掉错误信息
        $("span.errorMsg").text("");

      });

    })

  </script>

</div>