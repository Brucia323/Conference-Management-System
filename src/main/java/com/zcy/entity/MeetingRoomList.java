package com.zcy.entity;

import java.util.List;

/**
 * 会议室列表
 *
 * @author ZZZCNY
 */
public class MeetingRoomList {
    private int currentPage;
    private int totalPage;
    private int totalCount;
    private List<MeetingRoom> meetingRooms;
    
    public MeetingRoomList(int currentPage, int totalPage, int totalCount, List<MeetingRoom> meetingRooms) {
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.meetingRooms = meetingRooms;
    }
    
    public int getCurrentPage() {
        return currentPage;
    }
    
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    
    public int getTotalPage() {
        return totalPage;
    }
    
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    
    public int getTotalCount() {
        return totalCount;
    }
    
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    
    public List<MeetingRoom> getMeetingRooms() {
        return meetingRooms;
    }
    
    public void setMeetingRooms(List<MeetingRoom> meetingRooms) {
        this.meetingRooms = meetingRooms;
    }
}
