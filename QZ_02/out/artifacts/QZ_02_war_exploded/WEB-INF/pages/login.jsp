<%--
  Created by IntelliJ IDEA.
  User: wan
  Date: 2016/9/15
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hey,Dude</title>
</head>
<body>
<div>没有账号，点击<a href="/UI_register">注册</a></div>
<div>
    <form action="/login" method="post">
        <table align="center">
            <tr>
                <td>用户名</td>
                <th><input type="text" name="username"></th>
                <th>${formbean.errors.username}</th>
            </tr>
            <tr>
                <td>请输入密码</td>
                <th><input type="password" name="password"></th>
                <th>${formbean.errors.password1}</th>
            </tr>
            <tr>
                <th colspan="2"><input type="submit" value="登录" ></th>
            </tr>
        </table>
    </form>

</div>
</body>
</html>
