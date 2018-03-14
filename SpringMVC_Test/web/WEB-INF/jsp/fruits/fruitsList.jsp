<%--
  Created by IntelliJ IDEA.
  User: ikook
  Date: 2018/3/14
  Time: 下午3:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>水果列表</title>
</head>
<body>
<h3>新鲜水果</h3>
<table width="300px" border="1">

    <tr>
        <td>名称</td>
        <td>价格</td>
        <td>产地</td>
    </tr>

    <c:forEach items="${fruitsList}" var="fruits">

        <tr>
            <td>${fruits.name}</td>
            <td>${fruits.price}</td>
            <td>${fruits.producing_area}</td>
        </tr>

    </c:forEach>

</table>


</body>
</html>
