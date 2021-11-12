package com.zcy.servlet;

import com.zcy.dao.Inquire;
import com.zcy.entity.Staff;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "GetStaffListByDepartmentIdServlet", value = "/GetStaffListByDepartmentIdServlet")
public class GetStaffListByDepartmentIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        int departmentId = Integer.parseInt(request.getParameter("department_id"));
        Inquire inquire = new Inquire();
        try {
            out.print(inquire.getStaffByDepartment(departmentId));
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
