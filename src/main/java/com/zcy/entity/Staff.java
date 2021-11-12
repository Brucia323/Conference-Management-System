package com.zcy.entity;

/**
 * 员工
 *
 * @author ZZZCNY
 */
public class Staff {
    private int staffId;
    private String staffName;
    private String accountName;
    private String password;
    private String telephone;
    private String email;
    private String departmentName;
    private String state;
    
    public Staff(int staffId, String staffName, String accountName, String password, String telephone, String email, String departmentName, String state) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.accountName = accountName;
        this.password = password;
        this.telephone = telephone;
        this.email = email;
        this.departmentName = departmentName;
        this.state = state;
    }
    
    public int getStaffId() {
        return staffId;
    }
    
    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }
    
    public String getStaffName() {
        return staffName;
    }
    
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    
    public String getAccountName() {
        return accountName;
    }
    
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getTelephone() {
        return telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getDepartmentName() {
        return departmentName;
    }
    
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
}
