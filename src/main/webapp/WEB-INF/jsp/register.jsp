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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="">

    <title>注册</title>
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
                var unameText = $("#uname").val();
                // 只能为英文
                var bookNamePatt = /^[A-Za-z]+$/;
                if(!bookNamePatt.test(unameText)){
                    $("span.errorMsg").text("书籍名不合法，必须为汉字！");
                    return false;
                }

                var passwordText = $("#password").val();
                // 非负整数
                var bookCountPatt = /^[1-9]\d*|0$/;
                if(!bookCountPatt.test(passwordText)){
                    $("span.errorMsg").text("书籍数量不合法，必须为非负整数！");
                    return false;
                }

                // 去掉错误信息
                $("span.errorMsg").text("");

            });

        })
    </script>
</head>
<style>
    body {
        background-color: gainsboro;
        font-size: 16px;
    }

    .div_top_1 {
        height: 140px;
        width: 100%;
    }

    .div_top_2 {
        height: 50px;
        width: 100%;
    }

    .main {
        width: 417.683px;
        height: 440px;
        background-color: #FFFFFF;
        margin: 0 auto;

    }

    .login {

        width: 360px;
        height: 360px;
        background-color: #FFFFFF;
        margin: 0 auto
    }

    .div_login_head {
        height: 36px;
        background-color: #FFFFFF;
        margin: 0 auto;
        line-height: 36px;
        text-align: center;
        color: #666;
        border-bottom: 3px solid #21b351;
        font-size: 18px;
        line-height: 24px;
        margin-bottom: -1px;
        font-family: "PingFang SC", "Microsoft yahei", "Helvetica Neue", "Helvetica", "Arial", sans-serif;
    }

    .div_input_account {
        width: 360px;
        height: 40px;

    }

    .div_input_pwd {
        width: 360px;
        height: 24px;

    }

    .input_account, .input_pwd {
        width: 360px;
        height: 40px;
        border: none;
        border-bottom: #ddd 1px solid;
        border-radius: 0;
        outline: 0;
        font: inherit;
        font-size: .875rem;
    }

    .div_button_login {
        width: 360px;
        height: 40px;
        margin-top: 36px;
        text-align: center;

    }

    .button_login {
        width: 180px;
        height: 40px;
        background: #1fa54a;
        font-size: 16px;
        cursor: pointer;
        color: white;
        border: none;
        border-radius: 2px;
        outline: 0;

    }

    .div_empty {
        width: 360px;
        height: 24px;

    }
    .div_error {
        width: 360px;
        height: 24px;
        text-align: center;
    }
    .span_error{

        color: #e35b5a;
        font-size: 13px;
    }
</style>
<body>
<div class="div_top_1">


</div>
<div class="main">
    <div class="login">
        <div class="div_top_2">

        </div>
        <div class="div_login_head">
            注册
        </div>

        <div class="div_empty">
        </div>
        <form action="/day13_war/doRegister" method="post">
            <div class="div_input_account">
                <input class="input_account" type="text" name="uname" id="uname" placeholder="用户名" />
            </div>

            <div class="div_empty">
            </div>


            <div class="div_input_pwd">
                <input class="input_pwd" type="password" name="password" id="password" placeholder="密码" />
            </div>
            <div class="div_empty">

             <div class="div_empty">
            </div>
            <div class="div_error">
                <span class="span_error">${msg}</span>
            </div>
            <div class="div_button_login">
                <input class="button_login" type="submit" id="sub_btn" value="注册"/>
            </div>
                </div>
        </form>


    </div>


</div>

</div>
</body>
</html>
