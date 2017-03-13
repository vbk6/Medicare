package com.myapp.medicare.laboratories;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.myapp.medicare.R;
import com.myapp.medicare.models.Laboratories;

/**
 * Created by admin on 19-Feb-17.
 */
public class LaboratoriesListAdapter extends BaseAdapter{

    private Cursor cursor;
    private Context context;

    public LaboratoriesListAdapter(Cursor cursor, Context context) {
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
        String labName=cursor.getString(cursor.getColumnIndex("labName"));
        String phoneNo=cursor.getString(cursor.getColumnIndex("phoneNo"));
        String location=cursor.getString(cursor.getColumnIndex("location"));
        String address=cursor.getString(cursor.getColumnIndex("address"));
        return new Laboratories(labName,phoneNo,address,location);
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
            convertView=inflater.inflate(R.layout.laboratories_list_item,null);
        }
        TextView textLabName= (TextView) convertView.findViewById(R.id.textName);
        TextView textAddress= (TextView) convertView.findViewById(R.id.textAddress);
        TextView textLocation= (TextView) convertView.findViewById(R.id.textLocation);
        TextView textPhoneNo= (TextView) convertView.findViewById(R.id.textPhoneNo);
        cursor.moveToPosition(position);
        String labName=cursor.getString(cursor.getColumnIndex("labName"));
        String phoneNo=cursor.getString(cursor.getColumnIndex("phoneNo"));
        String location=cursor.getString(cursor.getColumnIndex("location"));
        String address=cursor.getString(cursor.getColumnIndex("address"));
        textLabName.setText(labName);
        textAddress.setText(address);
        textPhoneNo.setText(phoneNo);
        textLocation.setText(location);
        return convertView;
    }
}
