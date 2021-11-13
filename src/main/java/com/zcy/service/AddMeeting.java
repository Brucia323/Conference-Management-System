package com.zcy.service;

import com.google.gson.Gson;
import com.zcy.dao.Inquire;
import com.zcy.dao.Update;

import java.sql.SQLException;

public class AddMeeting {
    /**
     * 预定会议
     *
     * @param meetingName   会议名称
     * @param meetingNumber 预计参加人数
     * @param startTime     会议开始时间
     * @param endTime       会议结束时间
     * @param meetingRoomId 会议室id
     * @param description   会议说明
     * @param staffList     参会人员列表
     * @param staffId       员工ID
     */
    public void addMeeting(String meetingName, int meetingNumber, String startTime, String endTime, int meetingRoomId
            , String description, String staffList, int staffId) throws SQLException, ClassNotFoundException {
        Update update = new Update();
        Inquire inquire = new Inquire();
        Gson gson = new Gson();
        String[] staffIds = gson.fromJson(staffList, String[].class);
        update.addMeeting(meetingName, meetingNumber, startTime, endTime, meetingRoomId, description, staffId, "预定");
        int meetingId = inquire.inquireLastMeeting();
        for (String id : staffIds) {
            update.addParticipants(meetingId, Integer.parseInt(id));
        }
    }
}
