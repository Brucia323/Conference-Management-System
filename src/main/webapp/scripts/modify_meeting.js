/**
 * 点击修改按钮，将会议信息存入localStorage，跳转到修改页面
 * @param meeting_id 会议id
 * @param meeting_name 会议名称
 * @param meeting_number 预计参与人数
 * @param meeting_start_time 会议开始时间
 * @param meeting_end_time 会议结束时间
 * @param meeting_description 会议描述
 */
function modify_meeting(meeting_id, meeting_name, meeting_number, meeting_start_time, meeting_end_time, meeting_description) {
    localStorage.meeting_id = meeting_id;
    localStorage.meeting_name = meeting_name;
    localStorage.meeting_number = meeting_number;
    localStorage.meeting_start_time = meeting_start_time;
    localStorage.meeting_end_time = meeting_end_time;
    localStorage.meeting_description = meeting_description;
    $(location).attr('href', 'ModifyMeetingServlet?meeting_id=' + meeting_id);
}

/**
 * 显示存在localStorage中的会议信息
 */
function show_meeting() {
    var meeting_name = localStorage.meeting_name;
    var meeting_number = localStorage.meeting_number;
    var meeting_start_time = localStorage.meeting_start_time;
    var meeting_end_time = localStorage.meeting_end_time;
    var meeting_description = localStorage.meeting_description;
    $("#meeting_name").text(meeting_name);
    $("#meeting_number").text(meeting_number);
    $("#meeting_start_time").text(meeting_start_time);
    $("#meeting_end_time").text(meeting_end_time);
    $("#description").val(meeting_description);
}
