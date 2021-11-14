package com.zcy.servlet;

import com.zcy.dao.Inquire;
import com.zcy.entity.Department;
import com.zcy.entity.MeetingRoom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * 加载会议预定页
 *
 * @author ZZZCNY
 */
@WebServlet(name = "MeetingAddServlet", value = "/MeetingAddServlet")
public class MeetingAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        Inquire inquire = new Inquire();
        try {
            List<MeetingRoom> meetingRooms = inquire.inquireMeetingRoom();
            request.setAttribute("meetingRooms", meetingRooms);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            List<Department> departments = inquire.inquireDepartment();
            request.setAttribute("departments", departments);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String date = getTomorrowDate() + "T00:00:00";
        request.setAttribute("date", date);
        request.getRequestDispatcher("/meeting_add.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
    
    /**
     * 获取当前日期
     *
     * @deprecated
     */
    public String getDate() {
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
    
    /**
     * 获取明天日期
     */
    public String getTomorrowDate() {
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(java.util.Calendar.DATE, 1);
        return dateFormat.format(calendar.getTime());
    }
    
    /**
     * 获取明天的日期时间
     *
     * @deprecated
     */
    public String getTomorrowDateTime() {
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(java.util.Calendar.DATE, 1);
        return dateFormat.format(calendar.getTime());
    }
}
