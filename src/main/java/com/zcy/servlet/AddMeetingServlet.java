package com.zcy.servlet;

import com.zcy.service.AddMeeting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "AddMeetingServlet", value = "/AddMeetingServlet")
public class AddMeetingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String meetingName = request.getParameter("meeting_name");
        int meetingNumber = Integer.parseInt(request.getParameter("meeting_number"));
        String startTime = request.getParameter("start_time");
        String endTime = request.getParameter("end_time");
        int meetingRoomId = Integer.parseInt(request.getParameter("meeting_room"));
        String description = request.getParameter("meeting_description");
        String staffList = request.getParameter("staff_list");
        int staffId = Integer.parseInt(request.getParameter("staff_id"));
        AddMeeting addMeeting = new AddMeeting();
        try {
            addMeeting.addMeeting(meetingName, meetingNumber, startTime, endTime, meetingRoomId, description, staffList, staffId);
            PrintWriter out = response.getWriter();
            out.print("success");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
