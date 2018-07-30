<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/25
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>传统form表单提交数据的问题</title>
</head>
<body>


<form action="${pageContext.request.contextPath }/user/add1" method="post">
    产品名称: <input type="text" name="name"><br>
    产品价格： <input type="text" name="age"><br>
    生产日期： <input type="text" name="dateBirth"><br>
    <input type="submit" value="传统提交">
</form>


<form action="${pageContext.request.contextPath }/user/add2" method="post">
    姓名: <input type="text" name="name"><br>
    年龄： <input type="text" name="age"><br>
    <%--出生日期： <input type="text" name="dateBirth"><br>--%>
    <input type="submit" value="基于springmvcform单个值分开提交">
</form>


<form action="${pageContext.request.contextPath }/user/add3" method="post">
    姓名: <input type="text" name="name"><br>
    年龄： <input type="text" name="age"><br>
    <%--出生日期： <input type="text" name="dateBirth"><br>--%>
    <input type="submit" value="基于springmvcform以javabean提交">
</form>

</body>
</html>
