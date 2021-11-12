package com.zcy.servlet;

import com.zcy.dao.Inquire;
import com.zcy.entity.Department;
import com.zcy.entity.MeetingRoom;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "MeetingAddServlet", value = "/MeetingAddServlet")
public class MeetingAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Inquire inquire = new Inquire();
        try {
            List<MeetingRoom> meetingRooms=inquire.inquireMeetingRoom();
            request.setAttribute("meetingRooms",meetingRooms);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            List<Department> departments=inquire.inquireDepartment();
            request.setAttribute("departments",departments);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/meeting_add.jsp").forward(request,response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
}
