<%--
  Created by IntelliJ IDEA.
  User: ikook
  Date: 2018/3/15
  Time: 下午9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>上传图片测试</title>
</head>
<body>
<form action="uploadImg.action" method="post" enctype="multipart/form-data">
    <c:if test="${image !=null}">
        <img src="/pic/${image}" width=100 height=100/>
        <br/>
    </c:if>
    <input type="file" name="file"/><br/>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
