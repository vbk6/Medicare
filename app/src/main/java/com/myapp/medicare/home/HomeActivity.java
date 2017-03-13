package com.myapp.medicare.home;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.myapp.medicare.R;
import com.myapp.medicare.appointment.AppointmentListActivity;
import com.myapp.medicare.blooddonors.BloodDonorsListActivity;
import com.myapp.medicare.db.DbHelper;
import com.myapp.medicare.doctors.DoctorsListActivity;
import com.myapp.medicare.kidneydonors.KidneyDonorsListActivity;
import com.myapp.medicare.laboratories.LaboratoriesListActivity;
import com.myapp.medicare.models.BloodDonors;
import com.myapp.medicare.models.Doctors;
import com.myapp.medicare.models.KidneyDonors;
import com.myapp.medicare.models.Laboratories;

public class HomeActivity extends Activity implements View.OnClickListener {

    DbHelper dbHelper;
    ImageView bloodDonorImageView;
    ImageView kidneyDonorImageView;
    ImageView appointmentImageView;
    ImageView laboratoryImageView;
    ImageView doctorImageView;
    public Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dbHelper=new DbHelper(this);

        bloodDonorImageView= (ImageView) findViewById(R.id.bloodDonorsImageView);
        kidneyDonorImageView= (ImageView) findViewById(R.id.kidneyDonorsImageView);
        appointmentImageView= (ImageView) findViewById(R.id.appointmentImageView);
        doctorImageView= (ImageView) findViewById(R.id.doctorsImageView);
        laboratoryImageView= (ImageView) findViewById(R.id.laboratoryImageView);

        bloodDonorImageView.setOnClickListener(this);
        kidneyDonorImageView.setOnClickListener(this);
        appointmentImageView.setOnClickListener(this);
        doctorImageView.setOnClickListener(this);
        laboratoryImageView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.bloodDonorsImageView:
                Log.d("Insert: ", "Inserting ..");
                  cursor=dbHelper.getBloodDonors();
                  if(cursor.getCount()==0) {
                dbHelper.addBloodDonor(new BloodDonors("Vishnu","23","B+ve","1111111111","Trivandrum","Trivandrum"));
                dbHelper.addBloodDonor(new BloodDonors("Rijo","23","A+ve","1111111111","Trivandrum","Trivandrum"));
                dbHelper.addBloodDonor(new BloodDonors("Vignesh","23","B+ve","444443444","Kochi","Kochi"));
                dbHelper.addBloodDonor(new BloodDonors("Surej","23","AB+ve","555555555","Kozhikode","Kozhikode"));
                  }
                Intent bloodDonorsintent = new Intent(this, BloodDonorsListActivity.class);
                this.startActivity(bloodDonorsintent);
                break;

            case R.id.kidneyDonorsImageView:
                cursor=dbHelper.getKidneyDonors();
                if(cursor.getCount()==0) {
                dbHelper.addKidneyDonor(new KidneyDonors("Vishnu","23","B+ve","1111111111","Trivandrum","Trivandrum"));
                dbHelper.addKidneyDonor(new KidneyDonors("Rijo","23","A+ve","3333333333","Kochi","Kochi"));
                dbHelper.addKidneyDonor(new KidneyDonors("Akhil","23","B+ve","2222222222","Kollam","Kollam"));
                dbHelper.addKidneyDonor(new KidneyDonors("Sravan","23","AB+ve","555555555","Kozhikode","Kozhikode"));
                }
                Intent kidneyDonorsintent = new Intent(this, KidneyDonorsListActivity.class);
                this.startActivity(kidneyDonorsintent);
                break;
            case R.id.appointmentImageView:
                Intent appointmentintent = new Intent(this, AppointmentListActivity.class);
                this.startActivity(appointmentintent);
                break;
            case R.id.doctorsImageView:
                cursor=dbHelper.getDoctors();
                if(cursor.getCount()==0) {
                    dbHelper.addDoctor(new Doctors("KIMS", "Paediatrics", "2222222222", "Trivandrum", "Trivandrum", "Surej","Monday:10am-1pm,Tuesday:4pm-7pm,Wednesday:12am-7pm,Thursday:6pm-8pm,friday:11am-3pm,saturday:3pm-6pm,sunday:10am-6pm"));
                    dbHelper.addDoctor(new Doctors("NIMS", "Gynacology", "3333333333", "Kochi", "Kochi", "Rijo","Monday:11am-1pm,Tuesday:2pm-6pm,Wednesday:12am-7pm,Thursday:6pm-8pm,friday:11am-3pm,saturday:4pm-6pm,sunday:10am-6pm"));
                    dbHelper.addDoctor(new Doctors("UST", "Orthology", "2222222222", "Kollam", "Kollam", "Vishnu","Monday:11am-1pm,Tuesday:2pm-6pm,Wednesday:12am-7pm,Thursday:6pm-9pm,friday:11am-3pm,saturday:4pm-8pm,sunday:10am-8pm"));
                    dbHelper.addDoctor(new Doctors("SUT", "Paediatrics", "4444444444", "Kozhikode", "Kozhikode", "Akhil","Monday:11am-1pm,Tuesday:2pm-6pm,Wednesday:12am-7pm,Thursday:6pm-8pm,friday:11am-3pm,saturday:4pm-6pm,sunday:10am-6pm"));
                }
                Intent doctorsintent = new Intent(this, DoctorsListActivity.class);
                this.startActivity(doctorsintent);
                break;
            case R.id.laboratoryImageView:
                cursor=dbHelper.getLaboratories();
                if(cursor.getCount()==0) {
                    dbHelper.addLaboratory(new Laboratories("x lab", "6666666666", "Trivandrum", "Trivandrum"));
                    dbHelper.addLaboratory(new Laboratories("y lab", "7777777777", "Kochi", "Kochi"));
                    dbHelper.addLaboratory(new Laboratories("zig lab", "8888888888", "Kozhikode", "Kozhikode"));
                    dbHelper.addLaboratory(new Laboratories("plus lab", "9999999999", "Kollam", "Kollam"));
                }
                Intent laboratoryintent = new Intent(this, LaboratoriesListActivity.class);
                this.startActivity(laboratoryintent);
                break;
        }
    }
}
