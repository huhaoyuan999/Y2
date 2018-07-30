/**
 *增加空气质量信息检测信息
 */
$("#add").click(function () {
    //获取检测区域
    var districtId = $("#districtId").val();
    //获取PM10值
    var pm10 = $("#pm10").val();
    //获取PM2.5值
    var pm25 = $("#pm25").val();
    //获取监测站
    var monitoringStation = $("#monitoringStation").val();
    //获取检测日期
    var monitorTime = $("#monitorTime").val();
    //日期格式的正则表达式
    var time = /^\d{4}\-\d{2}\-\d{2}$/;
    //判断是否整数的正则表达式.
    var num = /^[0-9]*[1-9][0-9]*$/;

    /**
     * 非空判断
     * @type {*|jQuery}
     */
    if (districtId == 0) {
        alert("请选择检测区域");
    } else if (monitorTime == null || monitorTime == '') {
        alert("检测日期不能为空！");
    } else if (!time.test(monitorTime)) {
        alert("检测日期格式不正确。例：2013-02-03");
    } else if (pm10 == null || pm10 == '') {
        alert("PM10值不能为空！");
    } else if (!num.test(pm10)) {
        alert("PM10值只能是整数！");
    } else if (pm25 == null || pm25 == '') {
        alert("PM2.5值不能为空！");
    } else if (!num.test(pm25)) {
        alert("PM2.5只能是整数！");
    } else if (monitoringStation == null || monitoringStation == '') {
        alert("监测站不能为空！");
    } else {
        //封装JSON数据
        var AirQuality = {
            "districtId": districtId,
            "monitorTime": monitorTime,
            "pm10": pm10,
            "pm25": pm25,
            "monitoringStation": monitoringStation
        }
        $.ajax({
            url: "/AirQuality/quality/add",
            type: "post",
            dataType: "text",
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(AirQuality),
            success: function (data) {
                if (data == "true") {
                    alert("添加成功！");
                    window.location.href = "/AirQuality/index.jsp";
                    // window.open("http://localhost:8080/EDOC/index.jsp")
                } else {
                    alert("添加失败！");
                }
            }
        });
    }
});

/**
 *修改空气质量信息检测信息
 */
$("#update").click(function () {
    //获取Id
    var id = $("#hiddenId").val();
    //获取检测区域
    var districtId = $("#districtId").val();
    //获取PM10值
    var pm10 = $("#pm10").val();
    //获取PM2.5值
    var pm25 = $("#pm25").val();
    //获取监测站
    var monitoringStation = $("#monitoringStation").val();
    //获取检测日期
    var monitorTime = $("#monitorTime").val();
    //日期格式的正则表达式
    var time = /^\d{4}\-\d{2}\-\d{2}$/;
    //判断是否整数的正则表达式.
    var num = /^[0-9]*[1-9][0-9]*$/;

    /**
     * 非空判断
     * @type {*|jQuery}
     */
    if (districtId == 0) {
        alert("请选择检测区域");
    } else if (monitorTime == null || monitorTime == '') {
        alert("检测日期不能为空！");
    } else if (!time.test(monitorTime)) {
        alert("检测日期格式不正确。例：2013-02-03");
    } else if (pm10 == null || pm10 == '') {
        alert("PM10值不能为空！");
    } else if (!num.test(pm10)) {
        alert("PM10值只能是整数！");
    } else if (pm25 == null || pm25 == '') {
        alert("PM2.5值不能为空！");
    } else if (!num.test(pm25)) {
        alert("PM2.5只能是整数！");
    } else if (monitoringStation == null || monitoringStation == '') {
        alert("监测站不能为空！");
    } else {
        //封装成JSON数据
        var AirQuality = {
            "id": id,
            "districtId": districtId,
            "monitorTime": monitorTime,
            "pm10": pm10,
            "pm25": pm25,
            "monitoringStation": monitoringStation
        }
        $.ajax({
            url: "/AirQuality/quality/update",
            type: "post",
            dataType: "text",
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(AirQuality),
            success: function (data) {
                if (data == "true") {
                    alert("修改成功！");
                    window.location.href = "/AirQuality/index.jsp";
                    // window.open("http://localhost:8080/EDOC/index.jsp")
                } else {
                    alert("修改失败！");
                }
            }
        })
    }
});

/**
 * 删除操作
 */
$("#delete").click(function () {
    //获取Id
    var id = $("#hiddenId").val();

    //封装成JSON数据
    var AirQuality = {
        "id": id
    }
    $.ajax({
        url: "/AirQuality/quality/delete",
        type: "post",
        dataType: "text",
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify(AirQuality),
        success: function (data) {
            if (data == "true") {
                alert("删除成功！");
                window.location.href = "/AirQuality/index.jsp";
                // window.open("http://localhost:8080/EDOC/index.jsp")
            } else {
                alert("删除失败！");
            }
        }
    })
});

/**
 * 重置按钮
 */
$("#reset").click(function () {
    //获取检测区域
    var districtId = $("#districtId").val(0);
    //获取PM10值
    var pm10 = $("#pm10").val("");
    //获取PM2.5值
    var pm25 = $("#pm25").val("");
    //获取监测站
    var monitoringStation = $("#monitoringStation").val("");
    //获取检测日期
    var monitorTime = $("#monitorTime").val("");
});

/**
 * 返回按钮
 */
$("#return").click(function () {
    window.location.href = "/AirQuality/index.jsp";
});