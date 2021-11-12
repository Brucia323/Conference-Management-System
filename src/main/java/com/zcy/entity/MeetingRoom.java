package com.zcy.entity;

/**
 * 会议室
 *
 * @author ZZZCNY
 */
public class MeetingRoom {
    private int meetingRoomId;
    private String roomNumber;
    private String meetingRoomName;
    private int meetingRoomMax;
    private String meetingRoomState;
    private String remark;
    
    public MeetingRoom(int meetingRoomId, String roomNumber, String meetingRoomName, int meetingRoomMax, String meetingRoomState, String remark) {
        this.meetingRoomId = meetingRoomId;
        this.roomNumber = roomNumber;
        this.meetingRoomName = meetingRoomName;
        this.meetingRoomMax = meetingRoomMax;
        this.meetingRoomState = meetingRoomState;
        this.remark = remark;
    }
    
    public int getMeetingRoomId() {
        return meetingRoomId;
    }
    
    public void setMeetingRoomId(int meetingRoomId) {
        this.meetingRoomId = meetingRoomId;
    }
    
    public String getRoomNumber() {
        return roomNumber;
    }
    
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
    
    public String getMeetingRoomName() {
        return meetingRoomName;
    }
    
    public void setMeetingRoomName(String meetingRoomName) {
        this.meetingRoomName = meetingRoomName;
    }
    
    public int getMeetingRoomMax() {
        return meetingRoomMax;
    }
    
    public void setMeetingRoomMax(int meetingRoomMax) {
        this.meetingRoomMax = meetingRoomMax;
    }
    
    public String getMeetingRoomState() {
        return meetingRoomState;
    }
    
    public void setMeetingRoomState(String meetingRoomState) {
        this.meetingRoomState = meetingRoomState;
    }
    
    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
}
