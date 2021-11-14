<%--
  Created by IntelliJ IDEA.
  User: ZZZCNY
  Date: 2021/11/12
  Time: 上午 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加会议室</title>
    <script src="node_modules/jquery/dist/jquery.js"></script>
    <script src="scripts/meeting_room_add.js"></script>
</head>
<body>
<header></header>
<main>
    <aside></aside>
    <nav></nav>
    <div>会议室信息</div>
    <table>
        <tr>
            <td>门牌号</td>
            <td><input type="text" id="room_number" required maxlength="255" minlength="1"></td>
        </tr>
        <tr>
            <td>会议室名称</td>
            <td><input type="text" id="room_name" required maxlength="255" minlength="1"></td>
        </tr>
        <tr>
            <td>最多容纳人数</td>
            <td><input type="number" id="room_max" required max="99" min="1"></td>
        </tr>
        <tr>
            <td>当前状态</td>
            <td>
                <select id="room_status">
                    <option value="启用">启用</option>
                    <option value="禁用">禁用</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>备注</td>
            <td><textarea id="remark" maxlength="255"></textarea></td>
        </tr>
    </table>
    <button onclick="add()">添加</button>
    <button onclick="reset()">重置</button>
</main>
<footer></footer>
</body>
</html>
