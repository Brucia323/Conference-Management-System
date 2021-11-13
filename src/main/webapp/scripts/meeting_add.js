var staff_list = [];

/**
 * 通过部门ID获得员工列表
 */
function getStaffListByDepartmentId() {
    var department_id = $("#department").val();
    $.get("GetStaffListByDepartmentIdServlet", {department_id: department_id}, function (data) {
        var json = JSON.parse(data);
        $("#staff").empty();
        for (var i = 0; i < json.length; i++) {
            var flag = 0;
            for (var j = 0; j < staff_list.length; j++) {
                if (json[i].staffId == staff_list[j]) {
                    $("#staff").append("<input type='checkbox' name='staff' value='" + json[i].staffId + "' onchange='saveCheckbox()' checked>+" + json[i].staffName + "</input>");
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                $("#staff").append("<input type='checkbox' name='staff' value='" + json[i].staffId + "' onchange='saveCheckbox()'>+" + json[i].staffName + "</input>");
            }
        }
    });
}

/**
 * 点击复选框后保存复选框选择情况
 */
function saveCheckbox() {
    $("input[name='staff']:checked").each(function () {
        staff_list.push($(this).val());
    });
    removeCheckbox();
    staff_list = Array.from(new Set(staff_list));
}

/**
 * 复选框取消选择时从staff_list中去掉对应value的值
 */
function removeCheckbox() {
    $("input[name='staff']:not(:checked)").each(function () {
        var index = staff_list.indexOf($(this).val());
        if (index > -1) {
            staff_list.splice(index, 1);
        }
    });
}

/**
 * 重置界面上所有输入框和复选框
 */
function reset() {
    $("#staff").empty();
    $("#meeting_name").val("");
    $("#meeting_number").val("");
    $("#start_date").val("");
    $("#start_time").val("");
    $("#end_date").val("");
    $("#end_time").val("");
    $("#meeting_description").val("");
    getStaffListByDepartmentId();
    staff_list = [];
}

/**
 * 预定会议
 */
function addMeeting() {
    var meeting_name = $("#meeting_name").val();
    var meeting_number = $("#meeting_number").val();
    var start_time = $("#start_time").val();
    var end_time = $("#end_time").val();
    var meeting_room = $("#meeting_room_name").val();
    var meeting_description = $("#meeting_description").val();
    var staff_list_str = JSON.stringify(staff_list);
    var staff_id = localStorage.staff_id;
    $.post("AddMeetingServlet", {
        meeting_name: meeting_name,
        meeting_number: meeting_number,
        start_time: start_time,
        end_time: end_time,
        meeting_room: meeting_room,
        meeting_description: meeting_description,
        staff_list: staff_list_str,
        staff_id: staff_id
    }, function (data) {
        if (data == "success") {
            alert("预定成功");
            reset();
        } else {
            alert("预定失败");
        }
    });
}

/**
 * 查询会议室冲突
 */
function checkMeetingRoom() {
    var start_time = $("#start_time").val();
    var end_time = $("#end_time").val();
    var meeting_room = $("#meeting_room_name").val();
    $.post("CheckMeetingRoomServlet", {
        start_time: start_time,
        end_time: end_time,
        meeting_room: meeting_room
    }, function (data) {
        if (data == "success") {
            alert("会议室可用");
        } else {
            alert("会议室已被预定");
            removeMeetingRoom(meeting_room);
        }
    });
}

/**
 * 把冲突的会议室从下拉列表中删除
 */
function removeMeetingRoom(meetingRoomId) {
    $("#" + meetingRoomId).remove();
}
