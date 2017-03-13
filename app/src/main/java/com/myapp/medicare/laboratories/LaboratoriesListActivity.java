package com.myapp.medicare.laboratories;

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
public class LaboratoriesListActivity extends AppCompatActivity {

    private DbHelper dbHelper = new DbHelper(this);
    public Cursor cursor;
    private ListView laboratoryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laboratories_list);

        laboratoryList=(ListView)findViewById(R.id.laboratoryList);
        cursor=dbHelper.getLaboratories();
        LaboratoriesListAdapter laboratoriesListAdapter=new LaboratoriesListAdapter(cursor,this);
        laboratoryList.setAdapter(laboratoriesListAdapter);


        final SearchView searchView = (SearchView) findViewById(R.id.search);
        searchView.setSubmitButtonEnabled(true);
        searchView.setQueryHint("location");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String searchItem= searchView.getQuery().toString();
                Log.d("vikz",searchItem+"");
                Cursor cursorFilter=dbHelper.getLaboratoriesFilter(searchItem);
                LaboratoriesListAdapter laboratoriesListAdapter=new LaboratoriesListAdapter(cursorFilter,getBaseContext());
                laboratoryList.setAdapter(laboratoriesListAdapter);
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
                LaboratoriesListAdapter laboratoriesListAdapter=new LaboratoriesListAdapter(cursor,getBaseContext());
                laboratoryList.setAdapter(laboratoriesListAdapter);
                return true;
            }
        });

    }
}
