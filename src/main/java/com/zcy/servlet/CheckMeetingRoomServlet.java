package com.zcy.servlet;

import com.zcy.dao.Inquire;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * 检查会议室冲突
 *
 * @author ZZZCNY
 */
@WebServlet(name = "CheckMeetingRoomServlet", value = "/CheckMeetingRoomServlet")
public class CheckMeetingRoomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String startTime = request.getParameter("start_time");
        String endTime = request.getParameter("end_time");
        int meetingRoomId = Integer.parseInt(request.getParameter("meeting_room"));
        Inquire inquire = new Inquire();
        try {
            if (!inquire.inquireMeetingRoomConflict(meetingRoomId, startTime, endTime)) {
                out.print("success");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
