package com.myapp.medicare.models;

/**
 * Created by vishnubk on 21/2/17.
 */

public class Doctors {


    private String hospitalName;
    private String specialization;
    private String phoneNo;
    private String address;
    private String location;
    private String doctorName;
    private String schedule;

    public Doctors(String hospitalName, String specialization, String phoneNo, String address, String location, String doctorName,String schedule) {
        this.hospitalName = hospitalName;
        this.specialization = specialization;
        this.phoneNo = phoneNo;
        this.address = address;
        this.location = location;
        this.doctorName = doctorName;
        this.schedule = schedule;
    }


    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
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
