package com.zcy.servlet;

import com.zcy.dao.Update;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "MeetingRoomAddServlet", value = "/MeetingRoomAddServlet")
public class MeetingRoomAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String roomNumber = request.getParameter("room_number");
        String roomName = request.getParameter("room_name");
        String roomMax = request.getParameter("room_max");
        String state = request.getParameter("state");
        String remark = request.getParameter("remark");
        Update update = new Update();
        try {
            update.addRoom(roomNumber, roomName, Integer.parseInt(roomMax), state, remark);
            out.print("success");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
}
