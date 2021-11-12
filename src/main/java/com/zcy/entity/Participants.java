package com.zcy.entity;

/**
 * 参会人员
 *
 * @author ZZZCNY
 */
public class Participants {
    private int staffId;
    private int meetingId;
    
    public Participants(int staffId, int meetingId) {
        this.staffId = staffId;
        this.meetingId = meetingId;
    }
    
    public int getStaffId() {
        return staffId;
    }
    
    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }
    
    public int getMeetingId() {
        return meetingId;
    }
    
    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }
}
