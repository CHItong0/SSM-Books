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

    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
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
        <form action="doRegister" method="post">


                <input class="input_account" type="text" name="uname" id="uname" placeholder="用户名" />


                <input class="input_pwd" type="password" name="upassword" id="password" placeholder="密码" />


            <input class="input_pwd" type="text" name="Email" id="Email" placeholder="邮箱">



            <input class="input_pwd" type="text" name="Phone" id="Phone" placeholder="手机号码">

            <div class="div_error">
                <span class="span_error"> ${msg}</span>
            </div>
                <span class="errorMsg" style="color:red;font-weight: bold"></span>

            <div class="div_button_login">
                <input class="button_login" type="submit" id="sub_btn" value="注册"/>
            </div>

        </form>

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

                    var bookAname = $("#password").val();

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




                    // 去掉错误信息
                    $("span.errorMsg").text("");

                });

            })

        </script>

    </div>
</div>




</div>

</div>
</body>

</html>
