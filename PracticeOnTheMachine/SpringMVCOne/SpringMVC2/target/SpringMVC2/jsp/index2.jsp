<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/7/24
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax测试</title>
</head>
<script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.js" type="text/javascript"></script>


<button id="test1">List集合测试</button>
</br><p></p>
<button id="test2">javaBEan测试</button>
</br><p></p>
<button id="test3">数组测试</button>
</br><p></p>
<button id="test4">简单Map集合测试</button>
</br><p></p>
<button id="test6">复杂Map集合测试</button>
</br><p></p>


<script>
    /**
     * List集合测试
     */
    $("#test1").click(function () {
        $.ajax({
            url: "/SpringMVC2/user2/list",
            type: "get",
            // data:"fff",
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    document.writeln("姓名是：" + data[i].name + "  年龄是：" + data[i].age + "<br/>");
                }
            }
        })
    });

    /**
     * javaBEan测试
     */
    $("#test2").click(function () {
        $.ajax({
            url: "/SpringMVC2/user2/show3",
            type: "post",
            success: function (data) {
                document.writeln("姓名是：" + data.name + "   年龄是：" + data.age);
            }
        })
    });

    /**
     * 数组测试
     */
    $("#test3").click(function () {
        $.ajax({
            url: "/SpringMVC2/user2/show4",
            type: "post",
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    document.writeln("姓名是:" + data[i].name + "   年龄:" + data[i].age + "<br/>");
                }
            }
        })
    });

    /**
     * 简单Map集合测试
     */
    $("#test4").click(function () {
        $.ajax({
            url: "/SpringMVC2/user2/show5",
            type: "post",
            success: function (data) {
                document.writeln("姓名是:" + data.user1.name + "年龄是:" + data.user1.age + "<br/>");
                document.writeln("姓名是:" + data.user2.name + "年龄是:" + data.user2.age + "<br/>");
                document.writeln("姓名是:" + data.user3.name + "年龄是:" + data.user3.age + "<br/>");
            }
        })
    });

    /**
     * 复杂Map集合测试
     */
    $("#test6").click(function () {
        $.ajax({
            url: "/SpringMVC2/user2/show6",
            type: "post",
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    document.writeln(i+ "轮<br/>")
                    document.writeln("主人姓名是:" + data[0].user.name + "   年龄是:" + data[0].user.age
                        + "        狗狗名字是:" + data[0].dog.name + "   狗狗年龄是:" + data[0].dog.age + "<br/>");
                }
            }
        })
    });
</script>

</body>
</html>
