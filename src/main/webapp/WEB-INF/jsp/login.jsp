<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: L1223
  Date: 2022-07-09
  Time: 2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<html>
<head>
    <base href="">

    <title>登录</title>
</head>
<style>
    body {
        background-color: gainsboro;
        font-size: 16px;
        border-image: url("/img/1.jpg");
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
            登录
        </div>

        <div class="div_empty">
        </div>
        <form action="doLogin" method="post">
            <div class="div_input_account">
                <input class="input_account" type="text" name="uname" id="uname" placeholder="用户名" />
            </div>

            <div class="div_empty">
            </div>


            <div class="div_input_pwd">
                <input class="input_pwd" type="password" name="password" id="password" placeholder="密码" />
            </div>
            <div class="div_empty">
            </div>
            <div>
                记住登录状态
                <input type="checkbox" name="rememberMe">

            </div>
            <div class="div_error">
                <span class="span_error"> ${error }</span>
            </div>
            <div class="div_button_login">
                <input class="button_login" type="submit" id="sub_btn" value="登录"/>

            </div>

            <div class="div_button_login">
                <a href="/day13_war_exploded/register">注册</a>
            </div>

        </form>
    </div>
    <%--<script>

        $(function () {
            $("#sub_btn").click(function () {

                // 正则表达式参考：https://zhuanlan.zhihu.com/p/83080230
                var uname = $("#uname").val();
                // 只能为汉字
                var unames = /^[\u4E00-\u9FA5A-Za-z0-9]+$/;
                if(!unames.test(uname)){
                    $("span.errorMsg").text("用户名密码只能为数字与英文！");
                    return false;
                }

                var password = $("#password").val();

                var passwords = /^[\u4E00-\u9FA5A-Za-z0-9]{2,20}$/;
                if(!passwords.test(password)){
                    $("span.errorMsg").text("用户名密码只能为数字与英文");
                    return false;
                }

                // 去掉错误信息
                $("span.errorMsg").text("");

            });

        })

    </script>--%>
    </script>


</div>

</div>
</body>

</html>
