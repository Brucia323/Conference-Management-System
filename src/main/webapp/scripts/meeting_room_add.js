function add() {
    var room_number = $("#room_number").val();
    var room_name = $("#room_name").val();
    var room_max = $("#room_max").val();
    var state = $("#room_status").val();
    var remark = $("#remark").val();
    $.get("MeetingRoomAddServlet", {
        room_number: room_number,
        room_name: room_name,
        room_max: room_max,
        state: state,
        remark: remark
    }, function (data) {
        if (data == "success") {
            alert("添加成功");
            window.location.href = "MeetingRoomListServlet";
        } else {
            alert("添加失败");
        }
    });
}
