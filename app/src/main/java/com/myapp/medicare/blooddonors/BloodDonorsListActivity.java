package com.myapp.medicare.blooddonors;

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
public class BloodDonorsListActivity extends AppCompatActivity{
    private DbHelper dbHelper = new DbHelper(this);
    public Cursor cursor;
    private ListView bloodDonorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_donors_list);
        //db test
        Logs.db(dbHelper.test1(),"id","donorName","age","bloodGroup","phoneNo","address","location");
        bloodDonorList=(ListView)findViewById(R.id.bloodDonorList);
        cursor=dbHelper.getBloodDonors();
        BloodDonorsListAdapter bloodDonorsListAdapter=new BloodDonorsListAdapter(cursor,this);
        bloodDonorList.setAdapter(bloodDonorsListAdapter);

        final SearchView searchView = (SearchView) findViewById(R.id.search);
        searchView.setSubmitButtonEnabled(true);
        searchView.setQueryHint("location, blood group");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String searchItem= searchView.getQuery().toString();
                Log.d("vikz",searchItem+"");
                Cursor cursorFilter=dbHelper.getBloodDonorsFilter(searchItem);
                BloodDonorsListAdapter bloodDonorsListAdapter=new BloodDonorsListAdapter(cursorFilter,getBaseContext());
                bloodDonorList.setAdapter(bloodDonorsListAdapter);
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
                BloodDonorsListAdapter bloodDonorsListAdapter=new BloodDonorsListAdapter(cursor,getBaseContext());
                bloodDonorList.setAdapter(bloodDonorsListAdapter);
                return true;
            }
        });

    }
}
