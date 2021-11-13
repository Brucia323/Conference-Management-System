<%--
  Created by IntelliJ IDEA.
  User: ZZZCNY
  Date: 2021/11/13
  Time: 下午 2:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改会议预定</title>
    <script src="node_modules/jquery/dist/jquery.js"></script>
    <script src="scripts/modify_meeting.js"></script>
</head>
<body onload="show_meeting()">
<main>
    <table>
        <tr>
            <td>会议名称</td>
            <td id="meeting_name"></td>
        </tr>
        <tr>
            <td>预计参加人数</td>
            <td id="meeting_number"></td>
        </tr>
        <tr>
            <td>预计开始时间</td>
            <td id="meeting_start_time"></td>
        </tr>
        <tr>
            <td>预计结束时间</td>
            <td id="meeting_end_time"></td>
        </tr>
        <tr>
            <td>会议说明</td>
            <td>
                <textarea id="description" rows="5" cols="50"></textarea>
            </td>
        </tr>
        <tr>
            <td>参会人员</td>
            <td>
                <table>
                    <tr>
                        <th>姓名</th>
                        <th>联系电话</th>
                        <th>电子邮件</th>
                    </tr>
                    <c:forEach var="person" items="${staff}">
                        <tr>
                            <td>${person.staffName}</td>
                            <td>${person.telephone}</td>
                            <td>${person.email}</td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
    </table>
    <div>
        <a href="#">
            <button>返回</button>
        </a>
    </div>
</main>
</body>
</html>
