<%--
  Created by IntelliJ IDEA.
  User: ikook
  Date: 2018/3/15
  Time: 下午4:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<form action="login.action" method="post">

    账号：<input type="text" name="username"/> <br>
    密码：<input type="password" name="password"/> <br>
    <input type="submit" value="登录"/>
    <c:if test="${errorMsg != null}">
        <font color="red">${errorMsg}</font>
    </c:if>

    <c:if test="${allErrors != null}">
        <c:forEach items="${allErrors}" var="error">
            <br/><font color="red">${error.defaultMessage}</font>
        </c:forEach>
    </c:if>

</form>

</body>
</html>
