package com.zcy.service;

import com.zcy.dao.Inquire;
import com.zcy.entity.Meeting;
import com.zcy.entity.MeetingList;

import java.sql.SQLException;
import java.util.List;

/**
 * 分页查询我参加的会议
 *
 * @author ZZZCNY
 */
public class MyMeeting {
    /**
     * 分页查询我参加的会议
     *
     * @param staffId     员工id
     * @param currentPage 当前页
     * @return 会议列表
     */
    public MeetingList getMyMeeting(int staffId, int currentPage) throws SQLException, ClassNotFoundException {
        Inquire inquire = new Inquire();
        int totalCount = inquire.inquireMeetingCount(staffId);
        int totalPage = totalCount % 10 == 0 ? totalCount / 10 : totalCount / 10 + 1;
        List<Meeting> meetings = inquire.inquireMeeting(staffId, currentPage);
        MeetingList meetingList = new MeetingList(currentPage, totalPage, totalCount, meetings);
        return meetingList;
    }
}
