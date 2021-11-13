package com.zcy.servlet;

import com.zcy.dao.Inquire;
import com.zcy.entity.Staff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ModifyMeetingServlet", value = "/ModifyMeetingServlet")
public class ModifyMeetingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int meetingId = Integer.parseInt(request.getParameter("meeting_id"));
        Inquire inquire = new Inquire();
        try {
            List<Staff> staff = inquire.inquireStaff(meetingId);
            request.setAttribute("staff", staff);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/modify_meeting.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
}
