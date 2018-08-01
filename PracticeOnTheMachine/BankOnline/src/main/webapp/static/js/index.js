/**
 * 用户登入
 */
$("#submit").click(function () {
    //获取卡号
    var cardNo = $("#cardNo").val();
    //获取密码
    var password = $("#password").val();
    //判断卡号正则表达式
    var card = /^\d{16}$/;
    //判断密码的正则表达式
    var pwd = /^\d{6}$/;

    //格式以及非空判断
    if (cardNo == null || cardNo == '') {
        alert("卡号不能为空")
    } else if (!card.test(cardNo)) {
        alert("请正确填写您的16位卡号")
    } else if (password == null || password == '') {
        alert("密码不能为空")
    } else if (!pwd.test(password)) {
        alert("请正确填写6位登入密码")
    } else {
        //创建一个JSON格式的对象
        var account = {
            "status": 1,
            "cardNo": cardNo,
            "password": password
        }
        $.ajax({
            url: "/BankOnline/account/login",
            type: "post",
            dataType: "text",
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(account),
            success: function (data) {
                if (data == "true") {
                    alert("登入成功！");
                    window.location.href = "/BankOnline/jsp/record.jsp";
                } else {
                    alert(data);
                }
            }
        })
    }
});