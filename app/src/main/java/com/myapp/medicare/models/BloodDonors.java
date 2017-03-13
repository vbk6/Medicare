package com.myapp.medicare.models;

/**
 * Created by vishnubk on 21/2/17.
 */

public class BloodDonors {

    private String donorName;
    private String age;
    private String bloodGroup;
    private String phoneNo;
    private String address;
    private String location;

    public BloodDonors(String donorName, String age, String bloodGroup, String phoneNo, String address, String location) {
        this.donorName = donorName;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.phoneNo = phoneNo;
        this.address = address;
        this.location = location;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
