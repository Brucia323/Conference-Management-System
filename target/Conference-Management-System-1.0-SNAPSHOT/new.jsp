<%--
  Created by IntelliJ IDEA.
  User: ZZZCNY
  Date: 2021/11/13
  Time: 下午 6:43
  To change this template use File | Settings | File Templates.
--%>
<%--
    最新通知页面
    从NewServlet.java跳转
    需要传入参数：
        1. staff_id 员工id
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>最新通知</title>
</head>
<body>
<header></header>
<main>
    <aside></aside>
    <nav></nav>
    <div>未来7天我要参加的会议</div>
    <table>
        <tr>
            <th>会议名称</th>
            <th>会议室</th>
            <th>起始时间</th>
            <th>结束时间</th>
        </tr>
        <c:forEach items="${myMeetingsIn7Days}" var="meeting">
            <tr>
                <td>${meeting.meetingName}</td>
                <td>${meeting.roomName}</td>
                <td>${meeting.startTime}</td>
                <td>${meeting.endTime}</td>
            </tr>
        </c:forEach>
    </table>
    <div>已取消的会议</div>
    <table>
        <tr>
            <th>会议名称</th>
            <th>会议室</th>
            <th>起始时间</th>
            <th>结束时间</th>
        </tr>
        <c:forEach items="${canceledMeetings}" var="meeting">
            <tr>
                <td>${meeting.meetingName}</td>
                <td>${meeting.roomName}</td>
                <td>${meeting.startTime}</td>
                <td>${meeting.endTime}</td>
            </tr>
        </c:forEach>
    </table>
</main>
<footer></footer>
</body>
</html>
