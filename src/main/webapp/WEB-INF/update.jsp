<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/6
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="doupdate.do" method="post">
    <input type="text" name="userId" value="${user.userId}" hidden="hidden">
    用户名：<input type="text" name="userName" value="${user.userName}"><br>
    密码：<input type="password" name="passWord" value="${user.passWord}"><br>
    性别：<input type="text" name="sex" value="${user.sex}"><br>
    电话：<input type="text" name="tel" value="${user.tel}"><br>
    <input type="submit" value="修改">
</form>
</body>
</html>
