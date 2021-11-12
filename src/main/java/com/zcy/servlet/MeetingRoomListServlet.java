package com.zcy.servlet;

import com.zcy.entity.MeetingRoomList;
import com.zcy.service.GetMeetingRoom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "MeetingRoomListServlet", value = "/MeetingRoomListServlet")
public class MeetingRoomListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage = 1;
        String currentPageStr = request.getParameter("currentPage");
        if (currentPageStr != null) {
            currentPage = Integer.parseInt(currentPageStr);
        }
        GetMeetingRoom getMeetingRoom = new GetMeetingRoom();
        try {
            MeetingRoomList meetingRoomList = getMeetingRoom.getMeetingRoom(currentPage);
            request.setAttribute("meetingRoomList", meetingRoomList);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/meeting_room_list.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
}
