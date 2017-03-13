package com.myapp.medicare.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.myapp.medicare.models.BloodDonors;
import com.myapp.medicare.models.Doctors;
import com.myapp.medicare.models.KidneyDonors;
import com.myapp.medicare.models.Laboratories;

/**
 * Created by vishnubk on 21/2/17.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME= "medicare";
    private Context context;
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase medicare) {
        medicare.execSQL("create table bloodDonors(id integer primary key,donorName text,age integer,bloodGroup text,phoneNo integer,address text,location text)");
        medicare.execSQL("create table doctors(id integer primary key,doctorName text,hospital text,specialization text,phoneNo integer,address text,location text,schedule text)");
        medicare.execSQL("create table kidneyDonors(id integer primary key,donorName text,age integer,bloodGroup text,phoneNo integer,address text,location text)");
        medicare.execSQL("create table laboratories(id integer primary key,labName texts,phoneNo integer,address text,location text)");
        medicare.execSQL("create table appointment(id integer primary key,Name text,sex text,age integer,phoneNo integer,address text,location text,hospital text,specialization text,doctorName text,appointmentDate text,appointmentTime text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase medicare, int oldVersion, int newVersion) {

        medicare.execSQL("DROP TABLE IF EXISTS bloodDonors");
        medicare.execSQL("DROP TABLE IF EXISTS doctors");
        medicare.execSQL("DROP TABLE IF EXISTS kidneyDonors");
        medicare.execSQL("DROP TABLE IF EXISTS laboratories)");
        medicare.execSQL("DROP TABLE IF EXISTS appointment)");
        onCreate(medicare);
    }

    //for writing db
     public void addBloodDonor(BloodDonors bloodDonors) {
        SQLiteDatabase medicare = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put( "donorName", bloodDonors.getDonorName());
        values.put( "age", bloodDonors.getAge());
        values.put( "bloodGroup", bloodDonors.getBloodGroup());
        values.put( "phoneNo", bloodDonors.getPhoneNo());
        values.put( "address", bloodDonors.getAddress());
        values.put( "location", bloodDonors.getLocation());
        medicare.insert("bloodDonors", null, values);
        medicare.close();
         Log.d("vbk","sucess");
    }

    public void addKidneyDonor(KidneyDonors kidneyDonors) {
        SQLiteDatabase medicare = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put( "donorName", kidneyDonors.getDonorName());
        values.put( "age", kidneyDonors.getAge());
        values.put( "bloodGroup", kidneyDonors.getBloodGroup());
        values.put( "phoneNo", kidneyDonors.getPhoneNo());
        values.put( "address", kidneyDonors.getAddress());
        values.put( "location", kidneyDonors.getLocation());
        medicare.insert("kidneyDonors", null, values);
        medicare.close();
        Log.d("vbk","sucess");
    }

    public void addDoctor(Doctors doctors) {
        SQLiteDatabase medicare = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put( "doctorName", doctors.getDoctorName());
        values.put( "hospital", doctors.getHospitalName());
        values.put( "specialization", doctors.getSpecialization());
        values.put( "phoneNo", doctors.getPhoneNo());
        values.put( "address", doctors.getAddress());
        values.put( "location", doctors.getLocation());
        values.put( "schedule", doctors.getSchedule());
        medicare.insert("doctors", null, values);
        medicare.close();
        Log.d("vbk","sucess");
    }

    public void addAppointment(String name,String age,String sex,String phoneNo,String appointmentDate,String address,String location,String hospital,String specialization,String doctorName,String appointmentTime) {
        SQLiteDatabase medicare = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put( "Name", name);
        values.put( "age", age);
        values.put( "sex", sex);
        values.put( "phoneNo",phoneNo);
        values.put( "address", address);
        values.put( "location", location);
        values.put( "hospital",hospital);
        values.put( "specialization", specialization);
        values.put( "doctorName",doctorName);
        values.put( "appointmentDate", appointmentDate);
        values.put( "appointmentTime", appointmentTime);
        medicare.insert("appointment", null, values);
        medicare.close();
        Log.d("vbk","sucess");
    }
    public void addLaboratory(Laboratories laboratories) {
        SQLiteDatabase medicare = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put( "labName", laboratories.getLabName());
        values.put( "phoneNo", laboratories.getPhoneNo());
        values.put( "address", laboratories.getAddress());
        values.put( "location", laboratories.getLocation());
        medicare.insert("laboratories", null, values);
        medicare.close();
        Log.d("vbk","sucess");
    }

    //for reading db
    public Cursor getBloodDonors(){

        SQLiteDatabase medicare=getReadableDatabase();
        Cursor cursor=medicare.rawQuery("SELECT * FROM bloodDonors ", null);
        return cursor;
    }

    public Cursor getKidneyDonors(){

        SQLiteDatabase medicare=getReadableDatabase();
        Cursor cursor=medicare.rawQuery("SELECT * FROM kidneyDonors ", null);
        return cursor;
    }
    public Cursor getDoctors(){

        SQLiteDatabase medicare=getReadableDatabase();
        Cursor cursor=medicare.rawQuery("SELECT * FROM doctors ", null);
        return cursor;
    }
    public Cursor getLaboratories(){

        SQLiteDatabase medicare=getReadableDatabase();
        Cursor cursor=medicare.rawQuery("SELECT * FROM laboratories ", null);
        return cursor;
    }
    public Cursor getAppointments(){

        SQLiteDatabase medicare=getReadableDatabase();
        Cursor cursor=medicare.rawQuery("SELECT * FROM appointment ", null);
        return cursor;
    }

    //for db search
    public Cursor getLaboratoriesFilter(String searchItem){

        SQLiteDatabase medicare=getReadableDatabase();
        Cursor cursor=medicare.rawQuery("SELECT * FROM laboratories WHERE location = '"+searchItem+"' COLLATE NOCASE;", null);
        return cursor;
    }
    public Cursor getDoctorFilter(String searchItem){

        SQLiteDatabase medicare=getReadableDatabase();
        Cursor cursor=medicare.rawQuery("SELECT * FROM doctors WHERE location = '"+searchItem+"'COLLATE NOCASE OR hospital='" + searchItem + "'COLLATE NOCASE OR specialization='" + searchItem + "'COLLATE NOCASE" , null);
        return cursor;
    }
    public Cursor getKidneyDonorsFilter(String searchItem){

        SQLiteDatabase medicare=getReadableDatabase();
        Cursor cursor=medicare.rawQuery("SELECT * FROM kidneyDonors WHERE location = '"+searchItem+"'COLLATE NOCASE OR bloodGroup='" + searchItem + "'COLLATE NOCASE;", null);
        return cursor;
    }
    public Cursor getBloodDonorsFilter(String searchItem){

        SQLiteDatabase medicare=getReadableDatabase();
        Cursor cursor=medicare.rawQuery("SELECT * FROM bloodDonors WHERE location = '"+searchItem+"'COLLATE NOCASE OR bloodGroup='" + searchItem + "'COLLATE NOCASE;", null);
        return cursor;
    }


    //for db test
    public Cursor test1(){

        SQLiteDatabase medicare=getReadableDatabase();
        Cursor cursor=medicare.rawQuery("SELECT * FROM bloodDonors ", null);
        return cursor;
    }
    public Cursor test2(){

        SQLiteDatabase medicare=getReadableDatabase();
        Cursor cursor=medicare.rawQuery("SELECT * FROM kidneyDonors ", null);
        return cursor;
    }
    public Cursor test3(){

        SQLiteDatabase medicare=getReadableDatabase();
        Cursor cursor=medicare.rawQuery("SELECT * FROM doctors ", null);
        return cursor;
    }
    public Cursor test4(){

        SQLiteDatabase medicare=getReadableDatabase();
        Cursor cursor=medicare.rawQuery("SELECT * FROM appointment ", null);
        return cursor;
    }
    public Cursor test5(){

        SQLiteDatabase medicare=getReadableDatabase();
        Cursor cursor=medicare.rawQuery("SELECT * FROM laboratories ", null);
        return cursor;
    }


}
