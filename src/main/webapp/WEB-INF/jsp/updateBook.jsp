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

    <form action="${pageContext.request.contextPath}/updateBook" method="post">
        <%-- 只有在表单提交时在隐藏域中增加 bookId 信息，保存到数据库的时候才不会出错 --%>
        <%-- 不能使用 ${book.bookId()} 来获得数据，因为 bookId 是私有变量  --%>
        <input type="hidden" name="bid" value="${books.getBid()}"/>
        书籍名称：<input type="text" name="bname" id="bookName" value="${books.getBname()}"/>
        作者：<input type="text" name="aname" id="bookAname" value="${books.getAname()}"/>
        书籍描述：<input type="text" name="bdescribe" id="bookBdescribe" value="${books.getBdescribe()}"/>
        书籍类型：<input type="text" name="tname"  id="bookTname" value="${books.getTname()}"/>

        <%--书籍详情：<input type="text" name="detail" value="${book.getDetail() }"/>--%>
        <input type="submit" id="sub_btn" value="提交"/>
    </form>

    <script>
        $(function () {
            $("#sub_btn").click(function () {

                // 正则表达式参考：https://zhuanlan.zhihu.com/p/83080230
                var bookName = $("#bookName").val();
                // 只能为汉字
                var bookNamePatt = /^[\u4E00-\u9FA5A-Za-z0-9]+$/;
                if(!bookNamePatt.test(bookName)){
                    $("span.errorMsg").text("书籍名不合法！");
                    return false;
                }

                var bookAname = $("#bookAname").val();

                var bookCountPatt1 = /^[\u4E00-\u9FA5A-Za-z0-9]{2,20}$/;
                if(!bookCountPatt1.test(bookAname)){
                    $("span.errorMsg").text("不能出现特殊符号");
                    return false;
                }

                var bookBdescribe = $("#bookBdescribe").val();
                // 非负整数
                var bookCountPatt2 = /^[\u4E00-\u9FA5A-Za-z0-9]{2,20}$/;
                if(!bookCountPatt2.test(bookBdescribe)){
                    $("span.errorMsg").text("不能出现特殊符号");
                    return false;
                }
                var bookTname = $("#bookTname").val();
                // 非负整数
                var bookCountPatt3 = /^[\u4E00-\u9FA5A-Za-z0-9]{2,20}$/;
                if(!bookCountPatt3.test(bookTname)){
                    $("span.errorMsg").text("不能出现特殊符号");
                    return false;
                }

                alert("修改成功,下次登录生效")

                // 去掉错误信息
                $("span.errorMsg").text("");

            });

        })

    </script>

</div>