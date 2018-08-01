/**
 * 退出登入
 */
$("#dropOut").click(function () {
    var flag = confirm("确认要退出网上银行吗？");
    if (flag) {
        $.ajax({
            url: "/BankOnline/account/destroy",
            type: "post",
            dataType: "text",
            contentType: 'application/json;charset=UTF-8',
            success: function (data) {
                window.location.href = "/BankOnline/jsp/index.jsp";
            }
        })
    }
});

/**
 * 查询余额
 */
$("#query").click(function () {
    //获取卡号
    var cardNo = $("#cardNo").text();
    window.location.href = "/BankOnline/account/queryCardNo/" + cardNo;
});

/**
 * 转账操作
 */
$("#Transfer").click(function () {
    window.location.href = "/BankOnline/transaction/Transfer";
});

/**
 * 查询交易记录
 */
$("#recording").click(function () {
    window.location.href = "/BankOnline/transaction/recording";
});

/**
 * 修改密码
 */
$("#password").click(function () {
    window.location.href = "/BankOnline/transaction/password";
});

/**
 * 提交转账信息
 */
$("#submitAccount").click(function () {
    //获取卡号
    var cardNo = $("#cardNo").text();
    //获取转入卡号
    var accountNumber = $("#accountNumber").val();
    //获取金额
    var amountInfo = $("#amountInfo").val();
    var float = parseFloat(amountInfo);
    //判断卡号正则表达式
    var card = /^\d{16}$/;
    //判断金额的正则表达式
    var amount = /^-?\d+\.?\d{1,4}$/;

    //格式以及非空判断
    if (accountNumber == null || accountNumber == '') {
        alert("卡号不能为空")
    } else if (!card.test(accountNumber)) {
        alert("请正确填写您的16位卡号")
    } else if (amountInfo == null || amountInfo == '') {
        alert("金额不能为空")
    } else if (!amount.test(amountInfo)) {
        alert("请填写正确的金额")
    } else {
        //分装成JSON对象
        var account = {
            "cardNo": cardNo,
            "accountNumber": accountNumber,
            "balance": float
        }
        $.ajax({
            url: "/BankOnline/transaction/submitTransfer",
            type: "post",
            dataType: "text",
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(account),
            success: function (data) {
                if (data == "true") {
                    var successInfo = "<h3 style=\"margin: 120px 85px;\">操作已成功！请继续选择其他服务！</h3>";
                    $("#right").children().remove();
                    $("#right").append(successInfo);
                } else {
                    alert(data);
                }
            }
        })
    }
});

/**
 * 查询交易记录信息
 */
$("#transaction").click(function () {
    var before = $("#before").val();
    var after = $("#after").val();
    var str = /\d{4}-\d{1,2}-\d{1,2}/;
    if (before == null || before == '' || after == null || after == '') {
        alert("日期不能为空")
    } else if (!str.test(before) || !str.test(after)) {
        alert("日期格式不正确")
    } else {
        window.location.href = "/BankOnline/transaction/page/" + before + "/" + after + "";
    }
});

/**
 * 查询交易记录信息
 */
$("#transaction1").click(function () {
    var before = $("#before1").val();
    var after = $("#after1").val();
    var str = /\d{4}-\d{1,2}-\d{1,2}/;
    if (before == null || before == '' || after == null || after == '') {
        alert("日期不能为空")
    } else if (!str.test(before) || !str.test(after)) {
        alert("日期格式不正确")
    } else {
        window.location.href = "/BankOnline/transaction/page/" + before + "/" + after + "";
    }
});

/**
 * 修改密码
 */
$("#updatePwd").click(function () {
    var cardNoPwd = $("#cardNoPwd").val();
    var newPwd = $("#newPwd").val();
    var newPwd2 = $("#newPwd2").val();
    //获取卡号
    var cardNo = $("#cardNo").text();
    //判断密码的正则表达式
    var pwd = /^\d{6}$/;
    if (cardNoPwd == null || cardNoPwd == '' || newPwd == null || newPwd == '' || newPwd2 == null || newPwd2 == '') {
        alert("请将表单填写完整");
    } else if (!pwd.test(cardNoPwd) || !pwd.test(newPwd) || !pwd.test(newPwd2)) {
        alert("密码只能是6位数字");
    } else if (newPwd != newPwd2) {
        alert("两次输入密码不一致");
    } else {
        $.ajax({
            url: "/BankOnline/account/update/"+cardNoPwd+"/"+newPwd+"/"+cardNo+"",
            type: "post",
            dataType: "text",
            contentType: 'application/json;charset=UTF-8',
            success: function (data) {
                if (data == "true") {
                    var successInfo = "<h3 style=\"margin: 120px 85px;\">密码修改成功！请继续选择其他服务！</h3>";
                    $("#right").children().remove();
                    $("#right").append(successInfo);
                } else {
                    alert(data);
                }
            }
        })
    }
});

