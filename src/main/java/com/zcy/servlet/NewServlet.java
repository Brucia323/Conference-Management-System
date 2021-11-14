package com.zcy.servlet;

import com.zcy.dao.Inquire;
import com.zcy.entity.Meeting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * 加载最新通知页面
 *
 * @author ZZZCNY
 */
@WebServlet(name = "NewServlet", value = "/NewServlet")
public class NewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int staffId = Integer.parseInt(request.getParameter("staff_id"));
        Inquire inquire = new Inquire();
        try {
            List<Meeting> myMeetingsIn7Days = inquire.inquireMyMeetingIn7Days(staffId);
            request.setAttribute("myMeetingsIn7Days", myMeetingsIn7Days);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            List<Meeting> cancelMeeting = inquire.inquireMyCancelMeeting(staffId);
            request.setAttribute("cancelMeeting", cancelMeeting);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/new.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
}
