
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增书籍</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- 原来还必须引入 JQuery 这个 js 的库 -->
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript">
        // 页面加载完成之后
        $(function () {
            $("#sub_btn").click(function () {
                // 正则表达式参考：https://zhuanlan.zhihu.com/p/83080230
                var bookNameText = $("#bookName").val();
                // 只能为汉字
                var bookNamePatt = /^[\u4E00-\u9FA5A-Za-z0-9]+$/;
                if(!bookNamePatt.test(bookNameText)){
                    $("span.errorMsg").text("书籍名不合法，不能有特殊符号！");
                    return false;
                }

                // 去掉错误信息
                $("span.errorMsg").text("");
            });
        })
    </script>
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增书籍</small>
                </h1>
                <span class="errorMsg" style="color:red;font-weight: bold">
                </span>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/addBooks" method="post">
        书籍名称：<input type="text" name="bname" id="bookName" required><br><br><br>
        书籍作者：<input type="text" name="aname" id="bookAuthor" required><br><br><br>
        书籍详情：<input type="text" name="bdescribe" id="bookDdescribe" required><br><br><br>
        书籍书籍类型：<input type="text" name="tname" id="bookTypes" required><br><br><br>

      <p><span class="span_error">${msg}</span></p>

        <input type="submit" value="添加" id="sub_btn">
    </form>

</div>