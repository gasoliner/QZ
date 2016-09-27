<%--
  Created by IntelliJ IDEA.
  User: wan
  Date: 2016/9/15
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>QuanZ-注册</title>
    <script type="text/javascript">
        function checkpwd(){
            var p1=document.getElementById("pwd1");//获取密码框的值
            var p2=document.getElementById("qwd2");//获取重新输入的密码值
            if(p1==""){
                alert("请输入密码！");//检测到密码为空，提醒输入//
                document.form1.pwd1.focus();//焦点放到密码框
                return false;//退出检测函数
            }//如果允许空密码，可取消这个条件

            if(p1!=p2){//判断两次输入的值是否一致，不一致则显示错误信息
                document.getElementById("msg").innerHTML="两次输入密码不一致，请重新输入";//在div显示错误信息
                return false;
            }else{
//                document.getElementById("msg").innerHTML="  ";
            }
        }

    </script>
    <script type="text/javascript">
         function changeImage(img){
         img.src=img.src+"?"+new Date ().getTime();
         }
    </script>

</head>
<body>
<div>已有账号?直接<a href="/UI_login">登录</a></div>



<div>
    <form action="/register" method="post">
    <table align="center">
        <tr>
            <td>用户名</td>
            <th><input type="text" name="username"></th>
            <th>${formbean.errors.username}</th>
        </tr>
        <tr>
            <td>昵称</td>
            <th><input type="text" name="nickname"></th>
            <th>${formbean.errors.nickname}</th>
        </tr>
        <tr>
            <td>请输入密码</td>
            <th> <input type="password" name="password1" id="pwd1"></th>
            <th>${formbean.errors.password1}</th>
        </tr>
        <tr>
            <td>请再次输入密码</td>
            <th> <input type="password" name="password2" id="pwd2" ></th>
            <%--onchange="checkpwd()"--%>
            <th><div id="msg"></div>${formbean.errors.password2}</th>
        </tr>
        <tr>
            <td>请输入邮箱</td>
            <th><input type="text" name="email"></th>
            <th>${formbean.errors.email}</th>
        </tr>
        <tr>
            <td>请输入验证码</td>
            <th><input type="text" name="checkcode"></th>
            <th><img src="/sjpicture" style="cursor:hand" onclick="changeImage(this)"></th>
        </tr>
        <tr>
            <th colspan="2"><input type="submit" value="注册" ></th>
        </tr>
    </table>
    </form>

</div>
</body>
</html>
