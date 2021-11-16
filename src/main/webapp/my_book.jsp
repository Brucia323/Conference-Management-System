<%--
  Created by IntelliJ IDEA.
  User: ZZZCNY
  Date: 2021/11/13
  Time: 下午 12:03
  To change this template use File | Settings | File Templates.
--%>
<%--
    我预定的会议页面
    从MyBookServlet.java跳转
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我的预定</title>
    <script src="node_modules/jquery/dist/jquery.js"></script>
    <script src="scripts/cancel_meeting.js"></script>
    <script src="scripts/modify_meeting.js"></script>
</head>
<body>
<header></header>
<main>
    <aside></aside>
    <nav></nav>
    <div>我预定的会议：</div>
    <table>
        <tr>
            <th>会议名称</th>
            <th>会议室名称</th>
            <th>会议开始时间</th>
            <th>会议结束时间</th>
            <th>会议预定时间</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${meetingList.meetings}" var="meeting">
            <tr>
                <td>${meeting.meetingName}</td>
                <td>${meeting.roomName}</td>
                <td>${meeting.startTime}</td>
                <td>${meeting.endTime}</td>
                <td>${meeting.bookTime}</td>
                <td>
                    <button onclick="modify_meeting('${meeting.meetingId}','${meeting.meetingName}','${meeting.peopleNum}','${meeting.startTime}','${meeting.endTime}','${meeting.description}')">
                        修改
                    </button>
                    <button onclick="cancelMeeting(${meeting.meetingId})">撤销</button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div class="page">
        <a href="MyBookServlet?currentPage=1">
            <button>首页</button>
        </a>
        <a href="MyBookServlet?currentPage=${meetingList.currentPage==1?1:meetingList.currentPage-1}">
            <button>上一页</button>
        </a>
        第${meetingList.currentPage}页/共${meetingList.totalPage}页
        <a href="MyBookServlet?currentPage=${meetingList.currentPage==meetingList.totalPage?meetingList.totalPage:meetingList.currentPage+1}">
            <button>下一页</button>
        </a>
        <a href="MyBookServlet?currentPage=${meetingList.totalPage}">
            <button>尾页</button>
        </a>
    </div>
</main>
<footer></footer>
</body>
</html>
