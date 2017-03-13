package com.myapp.medicare.models;

/**
 * Created by vishnubk on 21/2/17.
 */

public class Laboratories {

    private String labName;
    private String phoneNo;
    private String address;
    private String location;

    public Laboratories(String labName, String phoneNo, String address, String location) {
        this.labName = labName;
        this.phoneNo = phoneNo;
        this.address = address;
        this.location = location;
    }

    public String getLocation() {
        return location;

    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
