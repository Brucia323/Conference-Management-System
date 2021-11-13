<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ZZZCNY
  Date: 2021/11/12
  Time: 下午 4:27
  To change this template use File | Settings | File Templates.
--%>
<%--
    预定会议页面
    从MeetingAddServlet.java页面跳转
    需要从localStorage加载staff_id 员工id
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>预定会议</title>
    <script src="node_modules/jquery/dist/jquery.js"></script>
    <script src="scripts/meeting_add.js"></script>
</head>
<body onload="getStaffListByDepartmentId()">
<header></header>
<main>
    <aside></aside>
    <nav></nav>
    <div>会议信息</div>
    <table>
        <tr>
            <td>会议名称</td>
            <td><input type="text" id="meeting_name" required></td>
        </tr>
        <tr>
            <td>预计参加人数</td>
            <td><input type="text" id="meeting_number" required></td>
        </tr>
        <tr>
            <td>预计开始时间</td>
            <td>
                <%--                限制只能选择明天开始的日期--%>
                <input type="datetime-local" id="start_time" required min="${date}">
            </td>
        </tr>
        <tr>
            <td>预计结束时间</td>
            <td>
                <input type="datetime-local" id="end_time" required min="${date}">
            </td>
        </tr>
        <tr>
            <td>会议室名称</td>
            <td>
                <select id="meeting_room_name" onchange="checkMeetingRoom()">
                    <c:forEach var="meeting_room" items="${meetingRooms}">
                        <option id="${meeting_room.meetingRoomId}"
                                value="${meeting_room.meetingRoomId}">${meeting_room.meetingRoomName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>会议说明</td>
            <td><textarea id="meeting_description" required></textarea></td>
        </tr>
        <tr>
            <td>选择参会人员</td>
            <td>
                <select id="department" onchange="getStaffListByDepartmentId()">
                    <c:forEach var="department" items="${departments}">
                        <option value="${department.departmentId}">${department.departmentName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <div id="staff"></div>
            </td>
        </tr>
    </table>
    <div>
        <button onclick="addMeeting()">预定会议</button>
        <button onclick="reset()">重置</button>
    </div>
</main>
<footer></footer>
</body>
</html>
