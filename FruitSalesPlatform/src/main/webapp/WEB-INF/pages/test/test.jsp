<%--
  Created by IntelliJ IDEA.
  User: ikook
  Date: 2018/3/16
  Time: 下午11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>test</title>
</head>
<body>

<form action="findUser.action" method="post">
    用户姓名：<input type="text" name="name"/></br>
    <input type="submit" value="查询">
</form>
<table width="300px;" border=1>
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>账号</td>
        <td>电话</td>
    </tr>
    <c:forEach items="${userList}" var="fruit" varStatus="status">
        <tr>
            <td>${status.index+1}</td>
            <td>${fruit.name }</td>
            <td>${fruit.username }</td>
            <td>${fruit.telphone}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
