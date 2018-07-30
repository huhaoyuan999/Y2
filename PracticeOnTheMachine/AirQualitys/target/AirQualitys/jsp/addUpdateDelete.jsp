<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/29
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>空气质量信息检测</title>
    <link href="${pageContext.request.contextPath }/static/css/add.css" rel="stylesheet">
</head>
<body>
<div id="div1">
    <table>
        <tr>
            <th colspan="2">
                <c:choose>
                    <c:when test="${!empty airQuality}">
                        <h3>空气质量信息维护页面</h3>
                    </c:when>
                    <c:otherwise>
                        <h3>添加空气质量信息</h3>
                    </c:otherwise>
                </c:choose>
            </th>
        </tr>
        <tr>
            <td name="names">检测区域：</td>
            <td><select id="districtId" name="districtId">
                <c:if test="${!empty airQuality}">
                    <c:choose>
                        <c:when test="${airQuality.districtId==1}">
                            <option value="0">不限</option>
                            <option value="1" selected>西城区</option>
                            <option value="2">东城区</option>
                            <option value="3">海定区</option>
                            <option value="4">朝阳区</option>
                            <option value="5">丰台区</option>
                            <option value="6">房山区</option>
                            <option value="7">昌平区</option>
                            <option value="8">大兴区</option>
                        </c:when>
                        <c:when test="${airQuality.districtId==2}">
                            <option value="0">不限</option>
                            <option value="1">西城区</option>
                            <option value="2" selected>东城区</option>
                            <option value="3">海定区</option>
                            <option value="4">朝阳区</option>
                            <option value="5">丰台区</option>
                            <option value="6">房山区</option>
                            <option value="7">昌平区</option>
                            <option value="8">大兴区</option>
                        </c:when>
                        <c:when test="${airQuality.districtId==3}">
                            <option value="0">不限</option>
                            <option value="1">西城区</option>
                            <option value="2">东城区</option>
                            <option value="3" selected>海定区</option>
                            <option value="4">朝阳区</option>
                            <option value="5">丰台区</option>
                            <option value="6">房山区</option>
                            <option value="7">昌平区</option>
                            <option value="8">大兴区</option>
                        </c:when>
                        <c:when test="${airQuality.districtId==4}">
                            <option value="0">不限</option>
                            <option value="1">西城区</option>
                            <option value="2">东城区</option>
                            <option value="3">海定区</option>
                            <option value="4" selected>朝阳区</option>
                            <option value="5">丰台区</option>
                            <option value="6">房山区</option>
                            <option value="7">昌平区</option>
                            <option value="8">大兴区</option>
                        </c:when>
                        <c:when test="${airQuality.districtId==5}">
                            <option value="0">不限</option>
                            <option value="1">西城区</option>
                            <option value="2">东城区</option>
                            <option value="3">海定区</option>
                            <option value="4">朝阳区</option>
                            <option value="5" selected>丰台区</option>
                            <option value="6">房山区</option>
                            <option value="7">昌平区</option>
                            <option value="8">大兴区</option>
                        </c:when>
                        <c:when test="${airQuality.districtId==6}">
                            <option value="0">不限</option>
                            <option value="1">西城区</option>
                            <option value="2">东城区</option>
                            <option value="3">海定区</option>
                            <option value="4">朝阳区</option>
                            <option value="5">丰台区</option>
                            <option value="6" selected>房山区</option>
                            <option value="7">昌平区</option>
                            <option value="8">大兴区</option>
                        </c:when>
                        <c:when test="${airQuality.districtId==7}">
                            <option value="0">不限</option>
                            <option value="1">西城区</option>
                            <option value="2">东城区</option>
                            <option value="3">海定区</option>
                            <option value="4">朝阳区</option>
                            <option value="5">丰台区</option>
                            <option value="6">房山区</option>
                            <option value="7" selected>昌平区</option>
                            <option value="8">大兴区</option>
                        </c:when>
                        <c:when test="${airQuality.districtId==8}">
                            <option value="0">不限</option>
                            <option value="1">西城区</option>
                            <option value="2">东城区</option>
                            <option value="3">海定区</option>
                            <option value="4">朝阳区</option>
                            <option value="5">丰台区</option>
                            <option value="6">房山区</option>
                            <option value="7">昌平区</option>
                            <option value="8" selected>大兴区</option>
                        </c:when>
                    </c:choose>
                </c:if>
                <c:if test="${empty airQuality}">
                    <option value="0">不限</option>
                    <option value="1">西城区</option>
                    <option value="2">东城区</option>
                    <option value="3">海定区</option>
                    <option value="4">朝阳区</option>
                    <option value="5">丰台区</option>
                    <option value="6">房山区</option>
                    <option value="7">昌平区</option>
                    <option value="8">大兴区</option>
                </c:if>
            </select></td>
        </tr>
        <tr>
            <td name="names">检测日期：</td>
            <td>
                <input type="text" name="monitorTime" id="monitorTime"
                       value="<c:if test="${!empty airQuality}">${airQuality.monitorTime}</c:if>"/>
            </td>
        </tr>
        <tr>
            <td name="names">PM10值：</td>
            <td><input type="text" name="pm10" id="pm10"
                       value="<c:if test="${!empty airQuality}">${airQuality.pm10}</c:if>"/></td>
        </tr>
        <tr>
            <td name="names">PM2.5值：</td>
            <td><input type="text" name="pm25" id="pm25"
                       value="<c:if test="${!empty airQuality}">${airQuality.pm25}</c:if>"/></td>
        </tr>
        <tr>
            <td name="names">监测站：</td>
            <td><input type="text" name="monitoringStation" id="monitoringStation"
                       value="<c:if test="${!empty airQuality}">${airQuality.monitoringStation}</c:if>"/></td>
        </tr>
        <c:if test="${!empty airQuality}">
            <tr>
                <td name="names">最后修改时间：</td>
                <td><input type="text" name="lastModifyTime" id="lastModifyTime"
                           value="<c:if test="${!empty airQuality}">${airQuality.lastModifyTime}</c:if>"/></td>
            </tr>
        </c:if>
        <tr>
            <td colspan="2">
                <c:choose>
                    <c:when test="${!empty airQuality}">
                        <input type="button" value="更新" id="update"/>
                        <input type="button" value="删除" id="delete"/>
                    </c:when>
                    <c:otherwise>
                        <input type="button" value="保存" id="add"/>
                        <input type="button" value="重置" id="reset"/>
                    </c:otherwise>
                </c:choose>
                <input type="button" value="返回" id="return"/>
                <input type="hidden" value="${airQuality.id}" id="hiddenId"/>
            </td>
        </tr>
    </table>
</div>

<script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/static/js/add.js" type="text/javascript"></script>
</body>
</html>
