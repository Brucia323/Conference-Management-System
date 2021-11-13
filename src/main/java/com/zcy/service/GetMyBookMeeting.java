package com.zcy.service;

import com.zcy.dao.Inquire;
import com.zcy.entity.Meeting;
import com.zcy.entity.MeetingList;

import java.sql.SQLException;
import java.util.List;

/**
 * 获取我预定的会议
 *
 * @author ZZZCNY
 */
public class GetMyBookMeeting {
    /**
     * 获取我预定的会议，带分页
     *
     * @param staffId     员工id
     * @param currentPage 当前页
     * @return 会议列表
     */
    public MeetingList getMyBookMeeting(int staffId, int currentPage) throws SQLException, ClassNotFoundException {
        Inquire inquire = new Inquire();
        int totalCount = inquire.inquireMyBookMeetingCount(staffId);
        int totalPage = totalCount % 10 == 0 ? totalCount / 10 : totalCount / 10 + 1;
        List<Meeting> meetings = inquire.inquireMyMeeting(staffId, currentPage);
        MeetingList meetingList = new MeetingList(currentPage, totalPage, totalCount, meetings);
        return meetingList;
    }
}
