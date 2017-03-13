package com.myapp.medicare.doctors;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.SearchView;

import com.anwios.alog.Logs;
import com.myapp.medicare.R;
import com.myapp.medicare.db.DbHelper;

/**
 * Created by admin on 19-Feb-17.
 */
public class DoctorsListActivity extends AppCompatActivity {

    private DbHelper dbHelper = new DbHelper(this);
    public Cursor cursor;
    private ListView doctorList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_list);

        doctorList=(ListView)findViewById(R.id.doctorsList);
        cursor=dbHelper.getDoctors();
        DoctorsListAdapter doctorsListAdapter=new DoctorsListAdapter(cursor,this);
        doctorList.setAdapter(doctorsListAdapter);

        //db test
        Logs.db(dbHelper.test3(),"id","doctorName","hospital","specialization","phoneNo","address","location","schedule");

        final SearchView searchView = (SearchView) findViewById(R.id.search);
        searchView.setSubmitButtonEnabled(true);
        searchView.setQueryHint("location, hospital, specialization");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String searchItem= searchView.getQuery().toString();
                Log.d("vikz",searchItem+"");
                Cursor cursorFilter=dbHelper.getDoctorFilter(searchItem);
                DoctorsListAdapter doctorsListAdapter=new DoctorsListAdapter(cursorFilter,getBaseContext());
                doctorList.setAdapter(doctorsListAdapter);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                DoctorsListAdapter doctorsListAdapter=new DoctorsListAdapter(cursor,getBaseContext());
                doctorList.setAdapter(doctorsListAdapter);
                return true;
            }
        });
    }
}
