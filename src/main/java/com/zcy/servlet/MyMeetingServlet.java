package com.zcy.servlet;

import com.zcy.entity.MeetingList;
import com.zcy.service.MyMeeting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "MyMeetingServlet", value = "/MyMeetingServlet")
public class MyMeetingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int staffId = Integer.parseInt(request.getParameter("staff_id"));
        int currentPage = 1;
        String currentPageStr = request.getParameter("currentPage");
        if (currentPageStr != null && !currentPageStr.equals("")) {
            currentPage = Integer.parseInt(currentPageStr);
        }
        MyMeeting meeting = new MyMeeting();
        try {
            MeetingList meetingList = meeting.getMyMeeting(staffId, currentPage);
            request.setAttribute("meetingList", meetingList);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/my_meeting.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
}
