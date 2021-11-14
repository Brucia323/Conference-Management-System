<%--
  Created by IntelliJ IDEA.
  User: ZZZCNY
  Date: 2021/11/12
  Time: 下午 3:33
  To change this template use File | Settings | File Templates.
--%>
<%--
    查看会议室页面
    需要从MeetingRoomListServlet.java跳转
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查看会议室</title>
</head>
<body>
<header></header>
<main>
    <aside></aside>
    <nav></nav>
    <div>所有会议室：</div>
    <table>
        <tr>
            <th>门牌编号</th>
            <th>会议室名称</th>
            <th>容纳人数</th>
            <th>当前状态</th>
        </tr>
        <c:forEach items="${meetingRoomList.meetingRooms}" var="meetingRoom">
            <tr>
                <td>${meetingRoom.roomNumber}</td>
                <td>${meetingRoom.meetingRoomName}</td>
                <td>${meetingRoom.meetingRoomMax}</td>
                <td>${meetingRoom.meetingRoomState}</td>
            </tr>
        </c:forEach>
    </table>
    <div class="page">
        <a href="MeetingRoomListServlet?currentPage=1">
            <button>首页</button>
        </a>
        <a href="MeetingRoomListServlet?currentPage=${meetingRoomList.currentPage==1?1:currentPage-1}">
            <button>上一页</button>
        </a>
        第${meetingRoomList.currentPage}页/共${meetingRoomList.totalPage}页
        <a href="MeetingRoomListServlet?currentPage=${meetingRoomList.currentPage==meetingRoomList.totalPage?meetingRoomList.totalPage:meetingRoomList.currentPage+1}">
            <button>下一页</button>
        </a>
        <a href="MeetingRoomListServlet?currentPage=${meetingRoomList.totalPage}">
            <button>尾页</button>
        </a>
    </div>
</main>
<footer></footer>
</body>
</html>
