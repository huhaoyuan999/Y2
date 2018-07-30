/**
 * 删除指定信息
 * @param id
 */
function deleteInfo(id) {
    //创建一个JSON格式的对象
    var entry = {
        "id": id
    }
    $.ajax({
        url: "/EDOC/category/delete",
        type: "post",
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify(entry),
        dataType: "text",
        success: function (data) {
            if (data == "true") {
                // $("#delete" + id + "").remove();
                //重新刷新页面
                window.location.reload();
                // var str = "  <tr>\n" +
                //     "                <td colspan=\"6\"><span id=\"prompt\" style=\"color: red;text-align:center;vertical-align:middle;\"></span>\n" +
                //     "                </td>\n" +
                //     "            </tr>";
                // $("#tables").append(str);
                // $("#prompt").html("删除成功");
            } else {
                alert("删除失败！")
            }
        }
    })
}


