package com.zcy.dao;

import com.google.gson.Gson;
import com.zcy.DBHelper.MySQL;
import com.zcy.entity.Department;
import com.zcy.entity.Meeting;
import com.zcy.entity.MeetingRoom;
import com.zcy.entity.Staff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询数据库
 *
 * @author ZZZCNY
 */
public class Inquire {
    /**
     * 分页查询会议
     *
     * @param staffId     员工ID
     * @param currentPage 当前页
     * @return 会议列表
     */
    public List<Meeting> inquireMeeting(String staffId, int currentPage) throws ClassNotFoundException, SQLException {
        String sql = "select * from meeting where id = (select meeting_id from participants where staff_id = ?) and " +
                "state = '预定' " +
                "limit ?,10";
        Class.forName(MySQL.DRIVER);
        Connection connection = DriverManager.getConnection(MySQL.URL, MySQL.USER, MySQL.PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, staffId);
        preparedStatement.setInt(2, (currentPage - 1) * 10);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Meeting> meetings = new ArrayList<>();
        while (resultSet.next()) {
            Meeting meeting = new Meeting(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),
                    resultSet.getString(4), resultSet.getString(5), inquireMeetingRoomName(resultSet.getInt(6)),
                    resultSet.getString(7), inquireStaffName(resultSet.getInt(8)), resultSet.getString(9),
                    resultSet.getString(10));
            meetings.add(meeting);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return meetings;
    }
    
    /**
     * 通过会议室ID查询会议室名称
     *
     * @param meetingId 会议室ID
     * @return 会议室名称
     */
    public String inquireMeetingRoomName(int meetingId) throws ClassNotFoundException, SQLException {
        String sql = "select name from meeting_room where id = ?";
        Class.forName(MySQL.DRIVER);
        Connection connection = DriverManager.getConnection(MySQL.URL, MySQL.USER, MySQL.PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, meetingId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString(1);
        }
        return null;
    }
    
    /**
     * 通过员工ID查询员工姓名
     *
     * @param staffId 员工ID
     * @return 员工姓名
     */
    public String inquireStaffName(int staffId) throws ClassNotFoundException, SQLException {
        String sql = "select name from staff where id = ?";
        Class.forName(MySQL.DRIVER);
        Connection connection = DriverManager.getConnection(MySQL.URL, MySQL.USER, MySQL.PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, staffId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString(1);
        }
        return null;
    }
    
    /**
     * 分页查询会议室
     *
     * @param currentPage 当前页
     * @return 会议室列表
     */
    public List<MeetingRoom> inquireMeetingRoom(int currentPage) throws ClassNotFoundException, SQLException {
        String sql = "select * from meeting_room order by id limit ?,10";
        Class.forName(MySQL.DRIVER);
        Connection connection = DriverManager.getConnection(MySQL.URL, MySQL.USER, MySQL.PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, (currentPage - 1) * 10);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<MeetingRoom> meetingRooms = new ArrayList<>();
        while (resultSet.next()) {
            MeetingRoom meetingRoom = new MeetingRoom(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)
                    , resultSet.getInt(4), resultSet.getString(5), resultSet.getString(6));
            meetingRooms.add(meetingRoom);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return meetingRooms;
    }
    
    /**
     * 查询参会人员
     *
     * @param meetingId 会议ID
     * @return 员工列表
     */
    public List<Staff> inquireStaff(int meetingId) throws ClassNotFoundException, SQLException {
        String sql = "select staff_id from participants where meeting_id = ?";
        Class.forName(MySQL.DRIVER);
        Connection connection = DriverManager.getConnection(MySQL.URL, MySQL.USER, MySQL.PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, meetingId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Staff> staffs = new ArrayList<>();
        while (resultSet.next()) {
            staffs.add(inquireStaff1(resultSet.getInt(1)));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return staffs;
    }
    
    /**
     * 查询员工信息
     *
     * @param staffId 员工ID
     * @return 员工信息
     */
    public Staff inquireStaff1(int staffId) throws ClassNotFoundException, SQLException {
        String sql = "select * from staff where id = ?";
        Class.forName(MySQL.DRIVER);
        Connection connection = DriverManager.getConnection(MySQL.URL, MySQL.USER, MySQL.PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, staffId);
        ResultSet resultSet = preparedStatement.executeQuery();
        Staff staff = null;
        if (resultSet.next()) {
            staff = new Staff(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                    resultSet.getString(5), resultSet.getString(6), inquireDepartmentName(resultSet.getInt(7)),
                    resultSet.getString(8));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return staff;
    }
    
    /**
     * 通过部门ID查询部门名称
     *
     * @param departmentId 部门ID
     * @return 部门名称
     */
    public String inquireDepartmentName(int departmentId) throws ClassNotFoundException, SQLException {
        String sql = "select name from department where id = ?";
        Class.forName(MySQL.DRIVER);
        Connection connection = DriverManager.getConnection(MySQL.URL, MySQL.USER, MySQL.PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, departmentId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getString(1);
        }
        return null;
    }
    
    /**
     * 查询部门
     *
     * @return 部门列表
     */
    public List<Department> inquireDepartment() throws ClassNotFoundException, SQLException {
        String sql = "select * from department";
        Class.forName(MySQL.DRIVER);
        Connection connection = DriverManager.getConnection(MySQL.URL, MySQL.USER, MySQL.PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Department> departments = new ArrayList<>();
        while (resultSet.next()) {
            Department department = new Department(resultSet.getInt(1), resultSet.getString(2));
            departments.add(department);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return departments;
    }
    
    /**
     * 查询会议总数
     *
     * @param staffId 员工ID
     * @return 会议数量
     */
    public int inquireMeetingCount(int staffId) throws ClassNotFoundException, SQLException {
        String sql = "select count(*) from participants where staff_id = ?";
        Class.forName(MySQL.DRIVER);
        Connection connection = DriverManager.getConnection(MySQL.URL, MySQL.USER, MySQL.PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, staffId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }
    
    /**
     * 查询会议室数量
     *
     * @return 会议室数量
     */
    public int inquireMeetingRoomCount() throws ClassNotFoundException, SQLException {
        String sql = "select count(*) from meeting_room";
        Class.forName(MySQL.DRIVER);
        Connection connection = DriverManager.getConnection(MySQL.URL, MySQL.USER, MySQL.PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }
    
    /**
     * 查询会议室是否冲突
     *
     * @param meetingRoomId 会议室ID
     * @param startTime     开始时间
     * @param endTime       结束时间
     * @return 是否冲突
     */
    public boolean inquireMeetingRoomConflict(int meetingRoomId, String startTime, String endTime) throws ClassNotFoundException, SQLException {
        String sql = "select count(*) from meeting where room = ? and (start between ? and ? or end between ? and ? " +
                "or (start < ? and end > ?))";
        Class.forName(MySQL.DRIVER);
        Connection connection = DriverManager.getConnection(MySQL.URL, MySQL.USER, MySQL.PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, meetingRoomId);
        preparedStatement.setString(2, startTime);
        preparedStatement.setString(3, endTime);
        preparedStatement.setString(4, startTime);
        preparedStatement.setString(5, endTime);
        preparedStatement.setString(6, startTime);
        preparedStatement.setString(7, endTime);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1) > 0;
        }
        return false;
    }
    
    /**
     * 查询刚刚预定的会议
     *
     * @return 会议ID
     */
    public int inquireLastMeeting() throws ClassNotFoundException, SQLException {
        String sql = "select max(id) from meeting";
        Class.forName(MySQL.DRIVER);
        Connection connection = DriverManager.getConnection(MySQL.URL, MySQL.USER, MySQL.PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }
    
    /**
     * 查询我预定的会议
     *
     * @param staffId 员工ID
     * @return 会议列表
     */
    public List<Meeting> inquireMyMeeting(int staffId) throws ClassNotFoundException, SQLException {
        String sql = "select * from meeting where Booker = ? and state = '预定'";
        Class.forName(MySQL.DRIVER);
        Connection connection = DriverManager.getConnection(MySQL.URL, MySQL.USER, MySQL.PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, staffId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Meeting> meetings = new ArrayList<>();
        while (resultSet.next()) {
            Meeting meeting = new Meeting(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),
                    resultSet.getString(4), resultSet.getString(5), inquireMeetingRoomName(resultSet.getInt(6)),
                    resultSet.getString(7), inquireStaffName(resultSet.getInt(8)), resultSet.getString(9),
                    resultSet.getString(10));
            meetings.add(meeting);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return meetings;
    }
    
    /**
     * 查询未来7天我要参加的会议
     *
     * @param staffId 员工ID
     * @return 会议列表
     */
    public List<Meeting> inquireMyMeetingIn7Days(int staffId) throws ClassNotFoundException, SQLException {
        String sql = "select * from meeting where id = (select meeting_id from participants where staff_id = ?) and " +
                "state = " +
                "'预定' and " +
                "start > now() " +
                "and " +
                "start < " +
                "date_add" +
                "(now(),interval 7 day)";
        Class.forName(MySQL.DRIVER);
        Connection connection = DriverManager.getConnection(MySQL.URL, MySQL.USER, MySQL.PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, staffId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Meeting> meetings = new ArrayList<>();
        while (resultSet.next()) {
            Meeting meeting = new Meeting(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),
                    resultSet.getString(4), resultSet.getString(5), inquireMeetingRoomName(resultSet.getInt(6)),
                    resultSet.getString(7), inquireStaffName(resultSet.getInt(8)), resultSet.getString(9),
                    resultSet.getString(10));
            meetings.add(meeting);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return meetings;
    }
    
    /**
     * 查询已取消的会议
     *
     * @param staffId 员工ID
     * @return 会议列表
     */
    public List<Meeting> inquireMyCancelMeeting(int staffId) throws ClassNotFoundException, SQLException {
        String sql = "select * from meeting where id = (select meeting_id from participants where staff_id = ?) and " +
                "state = " +
                "'取消'";
        Class.forName(MySQL.DRIVER);
        Connection connection = DriverManager.getConnection(MySQL.URL, MySQL.USER, MySQL.PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, staffId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Meeting> meetings = new ArrayList<>();
        while (resultSet.next()) {
            Meeting meeting = new Meeting(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),
                    resultSet.getString(4), resultSet.getString(5), inquireMeetingRoomName(resultSet.getInt(6)),
                    resultSet.getString(7), inquireStaffName(resultSet.getInt(8)), resultSet.getString(9),
                    resultSet.getString(10));
            meetings.add(meeting);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return meetings;
    }
    
    /**
     * 查询会议室
     *
     * @return 会议室列表
     */
    public List<MeetingRoom> inquireMeetingRoom() throws ClassNotFoundException, SQLException {
        String sql = "select * from meeting_room";
        Class.forName(MySQL.DRIVER);
        Connection connection = DriverManager.getConnection(MySQL.URL, MySQL.USER, MySQL.PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<MeetingRoom> meetingRooms = new ArrayList<>();
        while (resultSet.next()) {
            MeetingRoom meetingRoom = new MeetingRoom(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                    resultSet.getInt(4), resultSet.getString(5), resultSet.getString(6));
            meetingRooms.add(meetingRoom);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return meetingRooms;
    }
    
    /**
     * 根据部门id查询员工
     *
     * @param departmentId 部门id
     * @return 员工列表
     */
    public String getStaffByDepartment(int departmentId) throws ClassNotFoundException, SQLException {
        String sql = "select * from staff where department = ?";
        Class.forName(MySQL.DRIVER);
        Connection connection = DriverManager.getConnection(MySQL.URL, MySQL.USER, MySQL.PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, departmentId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Staff> staffs = new ArrayList<>();
        while (resultSet.next()) {
            Staff staff = new Staff(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                    resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                    inquireDepartmentName(resultSet.getInt(7)),
                    resultSet.getString(8));
            staffs.add(staff);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        Gson gson = new Gson();
        String json = gson.toJson(staffs);
        return json;
    }
}
