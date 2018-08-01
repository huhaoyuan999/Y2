<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/30
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>个人网上银行</title>
</head>
<link href="${pageContext.request.contextPath }/static/css/record.css" rel="stylesheet">
<body>
<div id="body">
    <div id="head">
        <p>卡号：<span id="cardNo">${cardNo}</span><a href="javascript:;" id="dropOut">&nbsp;&nbsp;&nbsp;&nbsp;退出登入</a></p>
    </div>
    <div id="left">
        <a href="javascript:;" id="query">查询余额</a><br/>
        <a href="javascript:;" id="Transfer">转账</a><br/>
        <a href="javascript:;" id="recording">查询交易记录</a><br/>
        <a href="javascript:;" id="password">修改密码</a><br/>
    </div>
    <div id="right">
        <c:choose>
            <c:when test="${empty welcome}">
                <h1 style="margin: 120px 85px;">欢迎使用个人网上银行</h1>
            </c:when>
            <c:when test="${!empty balances}">
                <h3 style="margin: 90px 120px 40px 120px;">您 的 账 户 余 额 是 :</h3><br/>
                <span style="font-size: 19px;font-weight: bold;margin-left: 110px">人民币：</span>
                <span style="font-size: 19px;font-weight: bold;margin-left: 35px">${balances}元</span>
            </c:when>
            <c:when test="${!empty Transfer}">
                <h4 style="margin: 70px 0px 40px 50px;">当前操作：转账。请输入转入账号和金额后点“转账”按钮</h4><br/>
                <form action="#" method="post">
                    <p style="margin: 0px 0px 20px 120px;">输入账号：<input type="text" id="accountNumber"/></p><br/>
                    <p style="margin: 0px 0px 20px 120px;">转入金额：<input type="text" id="amountInfo"/></p><br/>
                    <p style="margin: 0px 0px 20px 250px;"><input type="button" value="转账" id="submitAccount"/></p><br/>
                </form>
            </c:when>
            <c:when test="${!empty recording}">
                <h4 style="margin: 10px 0px 10px 30px;">当前操作：查询交易记录。请选择时间范围后点击“查询”按钮</h4>
                <p>
                <form action="javascript:;" method="post" style="display:inline-block">
                    &nbsp;&nbsp;&nbsp;查询日期范围：<input type="text" style="width: 130px" id="before"/>
                    &nbsp;&nbsp;到：<input type="text" style="width: 130px" id="after"/>
                    &nbsp;&nbsp;&nbsp;<input type="button" value="查询" id="transaction"/>
                </form>
                </p>
            </c:when>
            <c:when test="${!empty recording2}">
                <h4 style="margin: 10px 0px 10px 30px;">当前操作：查询交易记录。请选择时间范围后点击“查询”按钮</h4>
                <p>
                <form action="javascript:;" method="post" style="display:inline-block">
                    &nbsp;&nbsp;&nbsp;查询日期范围：<input type="text" style="width: 130px" id="before1"
                                                    value="${before}"/>
                    &nbsp;&nbsp;到：<input type="text" style="width: 130px" id="after1" value="${after}"/>
                    &nbsp;&nbsp;&nbsp;<input type="button" value="查询" id="transaction1"/>
                </form>
                </p>
                <c:if test="${!empty page.list}">
                    <table id="tables" border="1px solid" style="margin-left: 10px">
                        <tr>
                            <th style="width: 150px">交易日期</th>
                            <th style="width: 90px">交易额</th>
                            <th style="width: 90px">账户金额</th>
                            <th style="width: 80px">交易类型</th>
                            <th style="width: 46px">备注</th>
                        </tr>
                        <c:forEach items="${page.list}" var="pageInfo" varStatus="indexs">
                            <tr
                                    <c:if test="${indexs.index%2==0}">style="background-color:mintcream" </c:if>
                            >
                                <td><fmt:formatDate value="${pageInfo.transactionDate}"
                                                    pattern="yyyy-MM-dd"></fmt:formatDate></td>
                                <td>${pageInfo.transactionAmount}</td>
                                <td>${pageInfo.balance}</td>
                                <td>${pageInfo.transactionType}</td>
                                <td>${pageInfo.remark}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <div id="footer" style="margin: 15px 0px 0px 80px">
                        <a href="${pageContext.request.contextPath }/transaction/pages/${page.firstPage}/6/${before}/${after}">首页</a>&nbsp;&nbsp;
                        <a href="${pageContext.request.contextPath }/transaction/pages/${page.prePage}/6/${before}/${after}">上一页</a>&nbsp;&nbsp;
                        <a href="${pageContext.request.contextPath }/transaction/pages/${page.nextPage}/6/${before}/${after}">下一页</a>&nbsp;&nbsp;
                        <a href="${pageContext.request.contextPath }/transaction/pages/${page.lastPage}/6/${before}/${after}">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <span>第${page.pageNum}页/共${page.pages}页&nbsp;&nbsp;&nbsp;（共${page.total}条信息）</span>
                    </div>
                </c:if>
                <c:if test="${empty page.list}">
                    <h4 style="margin: 100px 0px 10px 125px;">此 范 围 内 没 有 任 何 交 易 记 录</h4>
                </c:if>
            </c:when>
            <c:when test="${!empty password}">
                <h4 style="margin: 50px 0px 40px 50px;">当前操作：修改密码。请按要求填写完整后点“修改”按钮</h4><br/>

                <form action="javascript:;" method="post">
                    <p style="margin: 0px 0px 20px 90px;">请输入现在的密码：<input type="text" id="cardNoPwd"/></p><br/>

                    <p style="margin: 0px 0px 20px 90px;">请输入新密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
                            type="text" id="newPwd"/></p>
                    <br/>

                    <p style="margin: 0px 0px 20px 90px;">请再次输入新密码：<input type="text" id="newPwd2"/></p><br/>

                    <p style="margin: 0px 0px 20px 270px;"><input type="button" value="修改" id="updatePwd"/></p><br/>
                </form>
            </c:when>
        </c:choose>
    </div>
</div>

<script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/static/js/record.js" type="text/javascript"></script>
</body>
</html>
