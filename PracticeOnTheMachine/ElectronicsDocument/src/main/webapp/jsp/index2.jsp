<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/27
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>电子文档列表主页面</title>
    <link href="${pageContext.request.contextPath }/static/css/edoc.css" rel="stylesheet">
</head>
<c:if test="${empty indexCategory }">
    <jsp:forward page="/category/init/1/5/0"></jsp:forward>
</c:if>
<body>
<div id="all">
    <div id="header">
        <form action="${pageContext.request.contextPath }/category/categoryIdName" method="post"
              style="display: inline;">
            文档分类:<select id="type" name="categoryId">
            <option value="0">全部</option>
            <c:forEach items="${category}" var="categor" varStatus="indexs">
                <option value="${categor.id}"
                        <c:if test="${categoryId==categor.id}">selected</c:if>
                >${categor.name}</option>
            </c:forEach>
        </select>
            <input type="submit" value="&nbsp;查询&nbsp;" id="chaxun1"/>
        </form>

        <form action="${pageContext.request.contextPath }/category/categoryIdName" method="post"
              style="display: inline;">
            请输入文档名称:<input type="text" name="title" id="text2"/>
            <input type="submit" value="&nbsp;查询&nbsp;" id="chaxun2"/>
        </form>

        <form action="${pageContext.request.contextPath }/jsp/add.jsp" method="post" style="display: inline;">
            <input type="submit" value="新增电子文档"/>
        </form>

    </div>
    <div id="context">
        <h1>电子文档列表</h1>
        <table id="tables" border="1px solid">
            <tr>
                <th>文档编号</th>
                <th>文档名称</th>
                <th>文档摘要</th>
                <th>上传人</th>
                <th>上传时间</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${page.list}" var="entry" varStatus="indexs">
                <tr
                        <c:if test="${indexs.index % 2==0 }">style="background-color: azure"</c:if>
                        id="delete${entry.id}">
                    <td>${entry.id}</td>
                    <td>${entry.title}</td>
                    <td>${entry.summary}</td>
                    <td>${entry.uploaduser}</td>
                    <td><fmt:formatDate value="${entry.createdate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                    <td><a href="${pageContext.request.contextPath }/category/query/${entry.id}">修改</a><a
                            href="javascript:;" onclick="deleteInfo(${entry.id})">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="footer">
        <a href="${pageContext.request.contextPath }/category/init/${page.firstPage}/5/${categoryId}">首页</a>
        <a href="${pageContext.request.contextPath }/category/init/${page.prePage}/5/${categoryId}">上一页</a>
        <a href="${pageContext.request.contextPath }/category/init/${page.nextPage}/5/${categoryId}">下一页</a>
        <a href="${pageContext.request.contextPath }/category/init/${page.lastPage}/5/${categoryId}">末页</a>
        <span>第<span id="pageNum">${page.pageNum}</span>页/共${page.pages}页</span>
    </div>
</div>

<script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/static/js/index.js" type="text/javascript"></script>
</body>
</html>
