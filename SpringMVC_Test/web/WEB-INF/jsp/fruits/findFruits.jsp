<%--
  Created by IntelliJ IDEA.
  User: ikook
  Date: 2018/3/14
  Time: 下午7:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>水果列表</title>
</head>
<body>
<form action="queryFruitsByCondition.action" method="post">
    名称：<input type="text" name="name" />&nbsp;&nbsp;
    产地：<input type="text" name="producing_area" />
    <input type="submit" value="搜索"/> <br/>
</form>

<hr/>
<h3>搜索结果</h3>
<table width="300px;" border=1>
    <tr>
        <td>名称</td>
        <td>价格</td>
        <td>产地</td>
    </tr>
    <c:forEach items="${fruitsList }" var="fruits">
        <tr>
            <td>${fruits.name }</td>
            <td>${fruits.price }</td>
            <td>${fruits.producing_area }</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>