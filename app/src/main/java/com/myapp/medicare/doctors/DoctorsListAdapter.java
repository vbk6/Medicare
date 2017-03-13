package com.myapp.medicare.doctors;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.myapp.medicare.R;
import com.myapp.medicare.models.Doctors;

/**
 * Created by admin on 19-Feb-17.
 */
public class DoctorsListAdapter extends BaseAdapter {
    private Cursor cursor;
    private Context context;

    public DoctorsListAdapter(Cursor cursor, Context context) {
        this.cursor = cursor;
        this.context = context;
    }
    @Override
    public int getCount() {
        return cursor.getCount();
    }

    @Override

    public Object getItem(int position) {
        cursor.moveToPosition(position);
        String doctorName=cursor.getString(cursor.getColumnIndex("doctorName"));
        String hospital=cursor.getString(cursor.getColumnIndex("hospital"));
        String specialization=cursor.getString(cursor.getColumnIndex("specialization"));
        String phoneNo=cursor.getString(cursor.getColumnIndex("phoneNo"));
        String location=cursor.getString(cursor.getColumnIndex("location"));
        String address=cursor.getString(cursor.getColumnIndex("address"));
        String schedule=cursor.getString(cursor.getColumnIndex("schedule"));
        return new Doctors(hospital,specialization,phoneNo,address,location,doctorName,schedule);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null)
        {
            LayoutInflater inflater=LayoutInflater.from(context);
            convertView=inflater.inflate(R.layout.doctors_list_item,null);
        }
        TextView textDoctorName= (TextView) convertView.findViewById(R.id.textName);
        TextView textHospital= (TextView) convertView.findViewById(R.id.textHospital);
        TextView textAddress= (TextView) convertView.findViewById(R.id.textAddress);
        TextView textSpecialization= (TextView) convertView.findViewById(R.id.textSpecialization);
        TextView textLocation= (TextView) convertView.findViewById(R.id.textLocation);
        TextView textPhoneNo= (TextView) convertView.findViewById(R.id.textPhoneNo);
        cursor.moveToPosition(position);
        String doctorName=cursor.getString(cursor.getColumnIndex("doctorName"));
        String hospital=cursor.getString(cursor.getColumnIndex("hospital"));
        String specialization=cursor.getString(cursor.getColumnIndex("specialization"));
        String phoneNo=cursor.getString(cursor.getColumnIndex("phoneNo"));
        String location=cursor.getString(cursor.getColumnIndex("location"));
        String address=cursor.getString(cursor.getColumnIndex("address"));
        String schedule=cursor.getString(cursor.getColumnIndex("schedule"));
        textDoctorName.setText(doctorName);
        textHospital.setText(hospital);
        textAddress.setText(address);
        textSpecialization.setText(specialization);
        textPhoneNo.setText(phoneNo);
        textLocation.setText(location);
        return convertView;
    }
}
