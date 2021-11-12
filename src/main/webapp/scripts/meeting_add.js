/**
 * 通过部门ID获得员工列表
 */
function getStaffListByDepartmentId() {
    var department_id = $("#department").val();
    $.get("GetStaffListByDepartmentIdServlet", {department_id: department_id}, function (data) {
        var json = JSON.parse(data);
        $("#false").empty();
        for (var i = 0; i < json.length; i++) {
            $("#false").append("<button id='" + department_id + json[i].staffId + "' onclick='move_to_true(" + json[i].staffId + "," + department_id + "," + json[i].staffName + ")'>+" + json[i].staffName + "</button>");
        }
    });
}

/**
 * 将被点击的员工加到id="ture"的div中
 * @param staff_id 员工id
 * @param department_id 部门id
 * @param staff_name 员工姓名
 */
function move_to_true(staff_id, department_id, staff_name) {
    $("#" + department_id + staff_id).remove();
    $("#true").append("<button id='" + department_id + staff_id + "'>-" + staff_name + "</button>");
}
