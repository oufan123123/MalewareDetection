<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="css/mdb.min.css" rel="stylesheet">
    <!-- 自己定义的css样式 -->
    <link href="css/style.min.css" rel="stylesheet">
    <!--fontawesome图标库-->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <script src="js/jQuery-3.4.1.js"></script>
    <script src="js/jquery.base64.js" type="text/javascript"></script>
    <script type="text/javascript">
        var user=new Object();
        var btnlogin=$('#login');

        function checkInCorrect()      //判断用户名和密码是否为空
        {
            if (document.getElementById('name').value == "") {
                alert('请输入用户名！')
                document.getElementById('name').focus();
                return false
            }
            if (document.getElementById('password').value == "") {
                alert('请输入密码！')
                document.getElementById('password').focus();
                return false
            }
            else {
                saveInfo();
                return true;
            }
        }

        saveInfo = function () {
            try {
                var isSave = document.getElementById('remember_password').checked;   //保存按键是否选中
                if (isSave) {
                    var name = document.getElementById('name').value;
                    var password = document.getElementById('password').value;
                    if (name != "" && password != "") {
                        SetCookie(name, password);
                    }
                } else {
                    SetCookie("", "");
                }
            } catch (e) {

            }
        }

        function SetCookie(name, password) {
            var Then = new Date();

            Then.setTime(Then.getTime() + 1866240000000);
            document.cookie = "name=" + name + "%%" + password + ";expires=" + Then.toGMTString();
        }

        function GetCookie() {
            var nmpsd;
            var nm;
            var psd;
            var cookieString = new String(document.cookie);
            var cookieHeader = "name=";
            var beginPosition = cookieString.indexOf(cookieHeader);
            cookieString = cookieString.substring(beginPosition);
            var ends = cookieString.indexOf(";");
            if (ends != -1) {
                cookieString = cookieString.substring(0, ends);
            }
            if (beginPosition > -1) {
                nmpsd = cookieString.substring(cookieHeader.length);
                if (nmpsd != "") {
                    beginPosition = nmpsd.indexOf("%%");
                    nm = nmpsd.substring(0, beginPosition);
                    psd = nmpsd.substring(beginPosition + 2);
                    document.getElementById('name').value = nm;
                    document.getElementById('password').value = psd;
                    if (nm != "" && psd != "") {
                        // document.forms[0].checkbox.checked = true;
                        document.getElementById('remember_password').checked = true;
                    }
                }
            }
        }



        $(document).ready(function(){
            GetCookie();
            $('#login').click(function(){
                user.name=$.trim($('#name').val());
                user.password=$.trim($('#password').val());
                $.ajax({
                    type: "POST",
                    url: "user/varifylogin",
                    data: {ObjectJson:JSON.stringify(user)},
                    dataType: "text",
                    timeout: '1000',
                    success: function (result) {

                        if($.trim(result) === "success"){
                            console.log("yes");
                            window.location.href='repacked_detection.jsp';
                        } else{
                            console.log("no");
                            window.location.href='index.jsp';
                        }
                    }
                })
            })


        })

    </script>

</head>
<body>
<div  class="position-absolute" style="width:600px;height: 495px;top: 20%;left: 35%">

<form class="border border-light p-5">

    <p class="h4 mb-4 text-center">系统登陆</p>

    <input type="text" id="name" class="form-control mb-4" placeholder="用户名">

    <input type="password" id="password" class="form-control mb-4" placeholder="密码">

    <div class="d-flex justify-content-between">
        <div>
            <div class="custom-control custom-checkbox">
                <input type="checkbox" class="custom-control-input" id="remember_password">
                <label class="custom-control-label" for="remember_password">记住密码</label>
            </div>
        </div>
        <div>
            <a href="">忘记密码？</a>
        </div>
    </div>

    <button id="login" class="btn btn-info btn-block my-4" type="submit">登录</button>

    <div class="text-center">
        <p>
            <a href="user_register.html">注册</a>
        </p>

        <!--<p>或者换其他方式登录</p>
        <a type="button" class="light-blue-text mx-2">
            <i class="fa fa-weixin" aria-hidden="true"></i>
        </a>
        <a type="button" class="light-blue-text mx-2">
            <i class="fa fa-qq" aria-hidden="true"></i>
        </a>
        <a type="button" class="light-blue-text mx-2">
            <i class="fa fa-weibo" aria-hidden="true"></i>
        </a>
        <a type="button" class="light-blue-text mx-2">
            <i class="fa fa-github" aria-hidden="true"></i>
        </a>-->
    </div>

</form>

</div>


</body>

</html>