/**
 * 弹出提示确认是否撤销会议
 */
function cancelMeeting(meetingId) {
    var select=confirm("确定要撤销预定吗?");
    if (select){
        $.get("CancelMeetingServlet",{meetingId:meetingId},function (data){
            if (data=="success"){
                alert("撤销成功");
                window.location.reload();
            }else {
                alert("撤销失败");
            }
        });
    }
}
