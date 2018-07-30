<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/26
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:if test="${empty index }">
    <jsp:forward page="/jsp/index2.jsp"></jsp:forward>
</c:if>
<head>
    <title>Title</title>
</head>
<body>
<h1>OK</h1>
</body>
</html>
