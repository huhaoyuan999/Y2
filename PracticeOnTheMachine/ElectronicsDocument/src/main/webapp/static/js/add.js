/**
 *（增加/修改）电子文档信息
 */
$("#submit").click(function () {
    //获取文档编号
    var sid = $("#sid").val();
    //获取文档名称
    var title = $("#title").val();
    //获取文档摘要
    var summary = $("#summary").val();
    //获取上传人
    var uploaduser = $("#saddress").val();
    //获取上传时间
    var createdate = $("#semail").val();
    //日期格式的正则表达式
    var time = /^\d{4}\-\d{2}\-\d{2}$/;

<<<<<<< HEAD
=======

>>>>>>> origin/master
    /**
     * 非空判断
     * @type {*|jQuery}
     */
    if (title == null || title == '') {
        alert("文档名称不能为空！");
    } else if (summary == null || summary == '') {
        alert("文档摘要不能为空！");
    } else if (uploaduser == null || uploaduser == '') {
        alert("上传人不能为空！");
    } else if (createdate == null || createdate == '') {
        alert("上传时间不能为空！");
    } else if (!time.test(createdate)) {
        alert("上传时间格式不正确。");
    } else {

        /**
         * 判断功能修改或增加
         */
        if (sid == null || sid == '' || sid == undefined) {
            //创建一个JSON格式的对象
            var entry = {
                "categoryId": 1,
                "title": title,
                "summary": summary,
                "uploaduser": uploaduser,
                "createdate": createdate
            }
            $.ajax({
                url: "/EDOC/category/add",
                type: "post",
                dataType: "text",
                contentType: 'application/json;charset=UTF-8',
                data: JSON.stringify(entry),
                success: function (data) {
                    if (data == "true") {
                        alert("添加成功！");
                        window.location.href = "/EDOC/index.jsp";
                        // window.open("http://localhost:8080/EDOC/index.jsp")
                    } else {
                        alert("添加失败！");
                    }
                }
            })
        } else {
            //创建一个JSON格式的对象
            var entry = {
                "id": sid,
                "title": title,
                "summary": summary,
                "uploaduser": uploaduser,
                "createdate": createdate
            }
            $.ajax({
                url: "/EDOC/category/update",
                type: "post",
                dataType: "text",
                contentType: 'application/json;charset=UTF-8',
                data: JSON.stringify(entry),
                success: function (data) {
                    if (data == "true") {
                        alert("修改成功！");
                        window.location.href = "/EDOC/index.jsp";
                        // window.open("http://localhost:8080/EDOC/index.jsp")
                    } else {
                        alert("修改失败！");
                    }
                }
            })
        }
    }
});