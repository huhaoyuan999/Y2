<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/27
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="frm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>增加电子文档</title>
</head>
<link href="${pageContext.request.contextPath }/static/css/add.css" rel="stylesheet">
<body>
<div id="div1">
    <table border="1px solid">
        <tr>
            <th colspan="2">
                <c:if test="${empty entry}"><h1>增加电子文档</h1></c:if>
                <c:if test="${!empty entry}"><h1>更新电子文档</h1></c:if>
            </th>
        </tr>
        <c:if test="${!empty entry}">
            <tr>
                <td>文档编号</td>
                <td><input type="text" name="id" id="sid" value="${entry.id}" readonly="readonly"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>文档名称<span>(*)</span></td>
            <td><input type="text" name="title" id="title" value="${entry.title}"/></td>
        </tr>
        <tr>
            <td>文档摘要</td>
            <td><textarea style="font-weight:bold;font-size:14px; color:#333; border:1px solid #CCCCCC; " cols="45"
                          rows="6" name="summary" id="summary">${entry.summary}</textarea></td>
        </tr>
        <tr>
            <td>上传人</td>
            <td><input type="text" name="uploaduser" id="saddress" value="${entry.uploaduser}"/></td>
        </tr>
        <tr>
            <td>上传时间<span>(*)</span></td>
            <td><input type="text" name="createdate" id="semail"
                       value="<fmt:formatDate value="${entry.createdate}" pattern="yyyy-MM-dd"></fmt:formatDate>"/>(yyyy-MM-dd)
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="button" value="提交" id="submit"/>
                <form action="${pageContext.request.contextPath }/jsp/index2.jsp" method="post"
                      style="display: inline;">
                    <input type="submit" value="返回" id="kate"/>
                </form>
            </td>
        </tr>
    </table>
</div>

<script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/static/js/add.js" type="text/javascript"></script>
</body>
</html>
