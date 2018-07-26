<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/26
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工信息显示</title>
</head>
<body>

<h2>员工信息表</h2>
<table>
    <thead>
    <tr>
        <th>员工编号</th>
        <th>员工姓名</th>
        <th>员工密码</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${page.list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.userPassword}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="3">
            <a href="${pageContext.request.contextPath }/user/page/${page.firstPage}/5">首页</a>
            <a href="${pageContext.request.contextPath }/user/page/${page.prePage}/5">上一页</a>
            <a href="${pageContext.request.contextPath }/user/page/${page.nextPage}/5">下一页</a>
            <a href="${pageContext.request.contextPath }/user/page/${page.lastPage}/5">尾页</a>
            第${page.pageNum}页 共${page.pages}页
        </td>
    </tr>
    </tbody>
</table>

</body>
</html>
