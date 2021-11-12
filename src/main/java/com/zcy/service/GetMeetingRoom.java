package com.zcy.service;

import com.zcy.dao.Inquire;
import com.zcy.entity.MeetingRoom;
import com.zcy.entity.MeetingRoomList;

import java.sql.SQLException;
import java.util.List;

/**
 * 分页查询会议室
 */
public class GetMeetingRoom {
    /**
     * 分页查询会议室
     *
     * @param currentPage 当前页
     * @return 会议室列表
     */
    public MeetingRoomList getMeetingRoom(int currentPage) throws SQLException, ClassNotFoundException {
        Inquire inquire = new Inquire();
        int totalCount = inquire.inquireMeetingRoomCount();
        int totalPage = totalCount % 10 == 0 ? totalCount / 10 : totalCount / 10 + 1;
        List<MeetingRoom> meetingRooms = inquire.inquireMeetingRoom(currentPage);
        MeetingRoomList meetingRoomList = new MeetingRoomList(currentPage, totalPage, totalCount, meetingRooms);
        return meetingRoomList;
    }
}
