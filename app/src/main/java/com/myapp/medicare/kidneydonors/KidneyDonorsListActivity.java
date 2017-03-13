package com.myapp.medicare.kidneydonors;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.SearchView;

import com.myapp.medicare.R;
import com.myapp.medicare.db.DbHelper;

/**
 * Created by admin on 19-Feb-17.
 */
public class KidneyDonorsListActivity extends AppCompatActivity{

    private DbHelper dbHelper = new DbHelper(this);
    public Cursor cursor;
    private ListView kidneyDonorList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kidney_donors_list);

        kidneyDonorList=(ListView)findViewById(R.id.kidneyDonorList);
        cursor=dbHelper.getKidneyDonors();
        KidneyDonorsListAdapter kidneyDonorsListAdapter=new KidneyDonorsListAdapter(cursor,this);
        kidneyDonorList.setAdapter(kidneyDonorsListAdapter);

        final SearchView searchView = (SearchView) findViewById(R.id.search);
        searchView.setSubmitButtonEnabled(true);
        searchView.setQueryHint("location, blood group");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String searchItem= searchView.getQuery().toString();
                Log.d("vikz",searchItem+"");
                Cursor cursorFilter=dbHelper.getKidneyDonorsFilter(searchItem);
                KidneyDonorsListAdapter kidneyDonorsListAdapter=new KidneyDonorsListAdapter(cursorFilter,getBaseContext());
                kidneyDonorList.setAdapter(kidneyDonorsListAdapter);
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
                KidneyDonorsListAdapter kidneyDonorsListAdapter=new KidneyDonorsListAdapter(cursor,getBaseContext());
                kidneyDonorList.setAdapter(kidneyDonorsListAdapter);
                return true;
            }
        });
    }
}
