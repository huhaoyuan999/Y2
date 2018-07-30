<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/25
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.js" type="text/javascript"></script>
<head>
    <title>JSON 数据传递到后台的问题</title>
</head>
<body>

<button id="bt1">ajax下提交json数据</button>
<div style="height: 35px"></div>
<button id="bt2">ajax下提交一组json数据</button>


<script>
    $(function () {
        /**
         *ajax下提交json数据
         */
        $("#bt1").click(function () {

            //创建一个JSON格式的对象
            var user1 = {
                "name": "段誉",
                "age": 26,
                "dateBirth": "2002-3-9 23:12:58"
            }

            $.ajax({
                url: "/SpringMVC3/user/add4",
                type: "post",
                dataType: "JSON",
                contentType: 'application/json;charset=UTF-8',
                data: JSON.stringify(user1),
                success: function (data) {
                    alert(data.getName)
                }
            })
        });

        /**
         *ajax下提交一组json数据
         */
        $("#bt2").click(function () {

            //创建第一个SON格式的对象
            var user1 = {
                "name": "段誉",
                "age": 26,
                "dateBirth": "2002-3-9 23:12:58"
            }
            //创建第二个SON格式的对象
            var user2 = {
                "name": "虚竹",
                "age": 21,
                "dateBirth": "2012-03-09 23:12:28"
            }
            //把对象封装成集合
            var list = [user1, user2];

            $.ajax({
                url: "/SpringMVC3/user/add5",
                type: "post",
                contentType: 'application/json;charset=UTF-8',
                data: JSON.stringify(list),
                dataType: "JSON",
                // dataType: "HTML",
                // dataType: "TEXT",
                // dataType: "XML",
                success: function (data) {
                    alert(data.getName)
                }
            })
        });
    })
</script>
</body>
</html>
