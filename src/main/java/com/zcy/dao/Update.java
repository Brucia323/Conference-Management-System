package com.zcy.dao;

import com.zcy.DBHelper.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 更新数据库
 *
 * @author ZZZCNY
 */
public class Update {
    /**
     * 添加会议室
     *
     * @param roomNum  门牌号
     * @param roomName 会议室名称
     * @param roomMax  最大容纳人数
     * @param state    会议室状态
     * @param remark   备注
     */
    public void addRoom(String roomNum, String roomName, int roomMax, int state, String remark) throws ClassNotFoundException, SQLException {
        String sql = "insert into meeting_room(room_number,name,max,state,remark) values(?,?,?,?,?)";
        Class.forName(MySQL.DRIVER);
        Connection connection = DriverManager.getConnection(MySQL.URL, MySQL.USER, MySQL.PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, roomNum);
        preparedStatement.setString(2, roomName);
        preparedStatement.setInt(3, roomMax);
        preparedStatement.setInt(4, state);
        preparedStatement.setString(5, remark);
        preparedStatement.executeUpdate();
    }
    
    /**
     * 预定会议
     *
     * @param meetingName 会议名称
     * @param peopleNum   参加人数
     * @param startTime   开始时间
     * @param endTime     结束时间
     * @param roomId      会议室ID
     * @param description 会议说明
     * @param staffId     预定员工ID
     * @param state       会议状态
     */
    public void addMeeting(String meetingName, int peopleNum, String startTime, String endTime, int roomId, String description, int staffId, int state) throws ClassNotFoundException, SQLException {
        String sql = "insert into meeting(name,participants,start,end,room,description,Booker,state) values(?,?," +
                "?,?,?,?,?,?)";
        Class.forName(MySQL.DRIVER);
        Connection connection = DriverManager.getConnection(MySQL.URL, MySQL.USER, MySQL.PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, meetingName);
        preparedStatement.setInt(2, peopleNum);
        preparedStatement.setString(3, startTime);
        preparedStatement.setString(4, endTime);
        preparedStatement.setInt(5, roomId);
        preparedStatement.setString(6, description);
        preparedStatement.setInt(7, staffId);
        preparedStatement.setInt(8, state);
        preparedStatement.executeUpdate();
    }
    
    /**
     * 添加参会人员
     *
     * @param meetingId 会议ID
     * @param staffId   参会员工ID
     */
    public void addParticipants(int meetingId, int staffId) throws ClassNotFoundException, SQLException {
        String sql = "insert into participants(meeting_id,staff_id) values(?,?)";
        Class.forName(MySQL.DRIVER);
        Connection connection = DriverManager.getConnection(MySQL.URL, MySQL.USER, MySQL.PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, meetingId);
        preparedStatement.setInt(2, staffId);
        preparedStatement.executeUpdate();
    }
    
    /**
     * 修改会议室状态
     *
     * @param meetingRoomId    会议室ID
     * @param meetingRoomState 会议室状态
     */
    public void updateMeetingRoomState(int meetingRoomId, int meetingRoomState) throws ClassNotFoundException, SQLException {
        String sql = "update meeting_room set state = ? where id = ?";
        Class.forName(MySQL.DRIVER);
        Connection connection = DriverManager.getConnection(MySQL.URL, MySQL.USER, MySQL.PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, meetingRoomState);
        preparedStatement.setInt(2, meetingRoomId);
        preparedStatement.executeUpdate();
    }
    
    /**
     * 修改会议预定
     *
     * @param meetingId   会议ID
     * @param description 会议说明
     */
    public void updateMeeting(int meetingId, String description) throws ClassNotFoundException, SQLException {
        String sql = "update meeting set description = ? where id = ?";
        Class.forName(MySQL.DRIVER);
        Connection connection = DriverManager.getConnection(MySQL.URL, MySQL.USER, MySQL.PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, description);
        preparedStatement.setInt(2, meetingId);
        preparedStatement.executeUpdate();
    }
    
    /**
     * 撤销会议预定
     *
     * @param meetingId 会议ID
     */
    public void cancelMeeting(int meetingId) throws ClassNotFoundException, SQLException {
        String sql = "update meeting set state = '取消' where id = ?";
        Class.forName(MySQL.DRIVER);
        Connection connection = DriverManager.getConnection(MySQL.URL, MySQL.USER, MySQL.PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, meetingId);
        preparedStatement.executeUpdate();
    }
}
