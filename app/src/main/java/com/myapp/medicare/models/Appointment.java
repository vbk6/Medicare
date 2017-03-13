package com.myapp.medicare.models;

/**
 * Created by vishnubk on 21/2/17.
 */

public class Appointment {
    private String name;
    private String sex;
    private String age;
    private String specialiZation;
    private String hospital;
    private String phoneNo;
    private String address;
    private String location;
    private String doctorName;
    private String appointmentDate;
    private String appointmentTime;
    public Appointment(String name, String appointmentTime, String appointmentDate, String doctorName, String location, String address, String phoneNo, String hospital, String specialiZation, String age, String sex) {
        this.name = name;
        this.appointmentTime = appointmentTime;
        this.appointmentDate = appointmentDate;
        this.doctorName = doctorName;
        this.location = location;
        this.address = address;
        this.phoneNo = phoneNo;
        this.hospital = hospital;
        this.specialiZation = specialiZation;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSpecialiZation() {
        return specialiZation;
    }

    public void setSpecialiZation(String specialiZation) {
        this.specialiZation = specialiZation;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
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

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}
