package com.zcy.entity;

/**
 * 会议
 *
 * @author ZZZCNY
 */
public class Meeting {
    private int meetingId;
    private String meetingName;
    private int peopleNum;
    private String startTime;
    private String endTime;
    private String roomName;
    private String description;
    private String staffName;
    private String meetingState;
    private String bookTime;
    
    public Meeting(int meetingId, String meetingName, int peopleNum, String startTime, String endTime, String roomName,
                   String description, String staffName, String meetingState, String bookTime) {
        this.meetingId = meetingId;
        this.meetingName = meetingName;
        this.peopleNum = peopleNum;
        this.startTime = startTime;
        this.endTime = endTime;
        this.roomName = roomName;
        this.description = description;
        this.staffName = staffName;
        this.meetingState = meetingState;
        this.bookTime = bookTime;
    }
    
    public int getMeetingId() {
        return meetingId;
    }
    
    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }
    
    public String getMeetingName() {
        return meetingName;
    }
    
    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }
    
    public int getPeopleNum() {
        return peopleNum;
    }
    
    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }
    
    public String getStartTime() {
        return startTime;
    }
    
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    
    public String getEndTime() {
        return endTime;
    }
    
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    public String getRoomName() {
        return roomName;
    }
    
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getStaffName() {
        return staffName;
    }
    
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    
    public String getMeetingState() {
        return meetingState;
    }
    
    public void setMeetingState(String meetingState) {
        this.meetingState = meetingState;
    }
    
    public String getBookTime() {
        return bookTime;
    }
    
    public void setBookTime(String bookTime) {
        this.bookTime = bookTime;
    }
}
