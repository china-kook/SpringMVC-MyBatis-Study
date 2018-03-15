<%--
  Created by IntelliJ IDEA.
  User: ikook
  Date: 2018/3/15
  Time: 下午10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Json Test</title>
</head>
<body>
<textarea id="jsonMsg" cols="30" rows="5" placeholder="请输入json格式信息">
    </textarea><br/>
<button onclick="submitMsg()">发送</button>
</body>
<script type="text/javascript"
        src="http://code.jquery.com/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
    //请求格式为json，输出格式为json
    function submitMsg() {
        var message = $('#jsonMsg').val();
        $.ajax({
            type: 'post',
            url: '${pageContext.request.contextPath}/JsonTest.action',
            contentType: 'application/json;charset=utf-8',
            data: message,//数据格式是json串
            success: function (data) {//返回json结果
                alert("username=" + data["username"] +
                    ",password=" + data["password"]);
            }
        });
    }
</script>
</html>
