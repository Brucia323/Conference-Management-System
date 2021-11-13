package com.zcy.servlet;

import com.zcy.dao.Inquire;
import com.zcy.dao.Update;
import com.zcy.entity.Staff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 * 加载修改会议页面
 *
 * @author ZZZCNY
 */
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
        request.setCharacterEncoding("utf-8");
        PrintWriter out= response.getWriter();
        int meetingId= Integer.parseInt(request.getParameter("meeting_id"));
        String description= request.getParameter("description");
        Update update=new Update();
        try {
            update.updateMeetingDescription(meetingId,description);
            out.print("success");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
