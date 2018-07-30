<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/25
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>

<form action="${pageContext.request.contextPath }/File/single1" method="post" enctype="multipart/form-data">
    文件： <input type="file" name="file"> <br>
    姓名： <input type="text" name="username"> <br>
    <input type="submit" value="上传">
</form>

<div style="height: 35px"></div>

<form action="${pageContext.request.contextPath }/File/single2" method="post" enctype="multipart/form-data">
    文件： <input type="file" name="file"> <br>
    姓名： <input type="text" name="username"> <br>
    <input type="submit" value="上传">
</form>

<div style="height: 35px"></div>

<form action="${pageContext.request.contextPath }/File/Multiple3" method="post" enctype="multipart/form-data">
    文件： <input type="file" name="file"> <br>
    文件： <input type="file" name="file"> <br>
    文件： <input type="file" name="file"> <br>
    文件： <input type="file" name="file"> <br>
    姓名： <input type="text" name="username"> <br>
    <input type="submit" value="上传">
</form>

</body>
</html>
