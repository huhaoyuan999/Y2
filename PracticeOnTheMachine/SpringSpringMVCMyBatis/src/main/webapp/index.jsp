<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/26
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页面</title>
</head>
<body>
<h1>新增用户</h1>
<form action="${pageContext.request.contextPath }/user/add" method="post">
    ID： <input type="text" name="id"> <br>
    姓名： <input type="text" name="userName"> <br>
    密码： <input type="text" name="userPassword"> <br>
    <input type="submit" value="确定">
</form>
</body>
</html>
