package com.zcy.entity;

import java.util.List;

/**
 * 会议列表
 *
 * @author ZZZCNY
 */
public class MeetingList {
    private int currentPage;
    private int totalPage;
    private int totalCount;
    private List<Meeting> meetings;
    
    public MeetingList(int currentPage, int totalPage, int totalCount, List<Meeting> meetings) {
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.meetings = meetings;
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
    
    public List<Meeting> getMeetings() {
        return meetings;
    }
    
    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }
}
