package com.zcy.servlet;

import com.zcy.entity.MeetingList;
import com.zcy.service.GetMyBookMeeting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "MyBookServlet", value = "/MyBookServlet")
public class MyBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int staffId = Integer.parseInt(request.getParameter("staff_id"));
        int currentPage = 1;
        String page = request.getParameter("currentPage");
        if (page != null) {
            currentPage = Integer.parseInt(page);
        }
        GetMyBookMeeting getMyBookMeeting = new GetMyBookMeeting();
        try {
            MeetingList meetingList = getMyBookMeeting.getMyBookMeeting(staffId, currentPage);
            request.setAttribute("meetingList", meetingList);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/my_book.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
}
