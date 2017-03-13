package com.myapp.medicare.blooddonors;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.myapp.medicare.R;
import com.myapp.medicare.models.BloodDonors;

/**
 * Created by admin on 19-Feb-17.
 */
public class BloodDonorsListAdapter extends BaseAdapter{

    private Cursor cursor;
    private Context context;

    public BloodDonorsListAdapter(Cursor cursor, Context context) {
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
        String donorName=cursor.getString(cursor.getColumnIndex("donorName"));
        String age=cursor.getString(cursor.getColumnIndex("age"));
        String phoneNo=cursor.getString(cursor.getColumnIndex("phoneNo"));
        String address=cursor.getString(cursor.getColumnIndex("address"));
        String location=cursor.getString(cursor.getColumnIndex("location"));
        String bloodGroup=cursor.getString(cursor.getColumnIndex("bloodGroup"));
        return new BloodDonors(donorName,age,bloodGroup,phoneNo,address,location);
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
            convertView=inflater.inflate(R.layout.blood_donors_list_item,null);
        }
        TextView textDonorName= (TextView) convertView.findViewById(R.id.textName);
        TextView textBloodGroup= (TextView) convertView.findViewById(R.id.textBloodGroup);
        TextView textAddress= (TextView) convertView.findViewById(R.id.textAddress);
        TextView textAge= (TextView) convertView.findViewById(R.id.textAge);
        TextView textLocation= (TextView) convertView.findViewById(R.id.textLocation);
        TextView textPhoneNo= (TextView) convertView.findViewById(R.id.textPhoneNo);
        cursor.moveToPosition(position);
        String donorName=cursor.getString(cursor.getColumnIndex("donorName"));
        String age=cursor.getString(cursor.getColumnIndex("age"));
        String phoneNo=cursor.getString(cursor.getColumnIndex("phoneNo"));
        String address=cursor.getString(cursor.getColumnIndex("address"));
        String location=cursor.getString(cursor.getColumnIndex("location"));
        String bloodGroup=cursor.getString(cursor.getColumnIndex("bloodGroup"));
        textDonorName.setText(donorName);
        textBloodGroup.setText(bloodGroup);
        textAddress.setText(address);
        textAge.setText(age);
        textPhoneNo.setText(phoneNo);
        textLocation.setText(location);
        return convertView;
    }
}
