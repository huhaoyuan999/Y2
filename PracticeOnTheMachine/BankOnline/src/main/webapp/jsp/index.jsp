<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/30
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>个人网上银行主页</title>
</head>
<link href="${pageContext.request.contextPath }/static/css/index.css" rel="stylesheet">
<body>
<div id="context">
    <form action="javascript:;" method="post">
        <div id="center">
            <table>
                <tr>
                    <th colspan="2"><h3>个人网上银行</h3></th>
                </tr>
                <tr>
                    <td>卡号:</td>
                    <td><input type="text" name="cardNo" id="cardNo"/></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input type="password" name="password" id="password"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="button" value="登入网上银行" id="submit"/></td>
                </tr>
            </table>
        </div>
    </form>
</div>

<script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/static/js/index.js" type="text/javascript"></script>
</body>
</html>
