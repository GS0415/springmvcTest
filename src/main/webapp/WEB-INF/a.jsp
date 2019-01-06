<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/4
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<a href="add.do">添加</a>
<table>
    <tr>
        <th hidden="hidden">id</th>
        <th>名字</th>
        <th>电话</th>
        <th>性别</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${lists}" var="user">
        <tr>
            <td hidden="hidden">${user.userId}</td>
            <td>${user.userName}</td>
            <td>${user.tel}</td>
            <td>${user.sex}</td>
            <td><a href="delete.do?userId=${user.userId}">删除</a>
                <a href="update.do?userId=${user.userId}">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
