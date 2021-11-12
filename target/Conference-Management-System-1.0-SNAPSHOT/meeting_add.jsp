<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ZZZCNY
  Date: 2021/11/12
  Time: 下午 4:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>预定会议</title>
    <script src="node_modules/jquery/dist/jquery.js"></script>
    <script src="scripts/meeting_add.js"></script>
</head>
<body>
<main>
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
                <input type="date" id="start_date" required>
                <input type="time" id="start_time" required>
            </td>
        </tr>
        <tr>
            <td>预计结束时间</td>
            <td>
                <input type="date" id="end_date" required>
                <input type="time" id="end_time" required>
            </td>
        </tr>
        <tr>
            <td>会议室名称</td>
            <td>
                <select id="meeting_room_name">
                    <c:forEach var="meeting_room" items="${meetingRooms}">
                        <option value="${meeting_room.meetingRoomId}">${meeting_room.meetingRoomName}</option>
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
                <div id="staff">
                    <div id="false"></div>
                    <div id="true"></div>
                </div>
            </td>
        </tr>
    </table>
</main>
</body>
</html>
