<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/29
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>空气质量信息检测主页面</title>
    <link href="${pageContext.request.contextPath }/static/css/index.css" rel="stylesheet">
</head>
<body>
<div id="all">
    <h1>空气质量检测信息库</h1>
    <div id="header">
        <form action="${pageContext.request.contextPath }/quality/districtId" method="post" style="display: inline">
            按区域查询:<select id="type" name="districtId">
            <option value="0">不限</option>
            <c:forEach items="${district}" var="distric" varStatus="indexs">
                <option value="${distric.id}">${distric.name}</option>
            </c:forEach>
        </select>
            <input type="submit" value="&nbsp;查询&nbsp;" id="submit1"/>
        </form>
        <a href="${pageContext.request.contextPath }/jsp/addUpdateDelete.jsp" id="add">添加空气质量信息</a>
    </div>
    <c:choose>
        <c:when test="${page.pages==0}">
            <h3>抱歉，暂无数据！</h3>
        </c:when>
        <c:otherwise>
            <div id="context">
                <table id="tables">
                    <tr>
                        <th>序号</th>
                        <th>区域</th>
                        <th>检测时间</th>
                        <th>PM10数据</th>
                        <th>PM2.5数据</th>
                        <th>监测站</th>
                    </tr>
                    <c:forEach items="${page.list}" var="airQuality" varStatus="indexs">
                        <tr
                                <c:if test="${indexs.index%2==0}">style="background-color:cornflowerblue" </c:if>
                        >
                            <td>${airQuality.id}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${airQuality.districtId==1}">
                                        <a href="${pageContext.request.contextPath }/quality/airQualityId/${airQuality.id}">西城区</a>
                                    </c:when>
                                    <c:when test="${airQuality.districtId==2}">
                                        <a href="${pageContext.request.contextPath }/quality/airQualityId/${airQuality.id}">东城区</a>
                                    </c:when>
                                    <c:when test="${airQuality.districtId==3}">
                                        <a href="${pageContext.request.contextPath }/quality/airQualityId/${airQuality.id}">海定区</a>
                                    </c:when>
                                    <c:when test="${airQuality.districtId==4}">
                                        <a href="${pageContext.request.contextPath }/quality/airQualityId/${airQuality.id}">朝阳区</a>
                                    </c:when>
                                    <c:when test="${airQuality.districtId==5}">
                                        <a href="${pageContext.request.contextPath }/quality/airQualityId/${airQuality.id}">丰台区</a>
                                    </c:when>
                                    <c:when test="${airQuality.districtId==6}">
                                        <a href="${pageContext.request.contextPath }/quality/airQualityId/${airQuality.id}">房山区</a>
                                    </c:when>
                                    <c:when test="${airQuality.districtId==7}">
                                        <a href="${pageContext.request.contextPath }/quality/airQualityId/${airQuality.id}">昌平区</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="${pageContext.request.contextPath }/quality/airQualityId/${airQuality.id}">大兴区</a>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>${airQuality.monitorTime}</td>
                            <td>${airQuality.pm10}</td>
                            <td>${airQuality.pm25}</td>
                            <td>${airQuality.monitoringStation}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </c:otherwise>
    </c:choose>
    <div id="footer">
        <a href="${pageContext.request.contextPath }/quality/init/${page.firstPage}/5">首页 | </a>
        <a href="${pageContext.request.contextPath }/quality/init/${page.prePage}/5"><< 上一页 | </a>
        <a href="${pageContext.request.contextPath }/quality/init/${page.nextPage}/5">下一页>>| </a>
        <a href="${pageContext.request.contextPath }/quality/init/${page.lastPage}/5">末页 </a>
        <span>  第${page.pageNum}页/共${page.pages}页    (共${page.pageSize}条数据)</span>
    </div>
</div>

<script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.js" type="text/javascript"></script>
</body>
</html>
