package com.starlingsoftwares.mymanagement.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.starlingsoftwares.mymanagement.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DuplicateActivity extends AppCompatActivity {
    EditText etDate;
    Calendar myCalendar = Calendar.getInstance();
    ImageView duplicate_back;
    Spinner spinner_duplicate_batchname;
    String[] strings=new String[]{"","","","",""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duplicate);

        etDate=findViewById(R.id.et_date);
        duplicate_back=findViewById(R.id.duplicate_back);

        String[] city_list = new String[5];

        city_list[0] = "Select Batch";
        city_list[1] = "Gurgaon";
        city_list[2] = "Faridabad";
        city_list[3] = "Gaziabad";
        city_list[4] = "Gali";

        ArrayAdapter<String > aa=new ArrayAdapter<String> (getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, city_list);


        spinner_duplicate_batchname=findViewById(R.id.spinner_duplicate_batchname);
        spinner_duplicate_batchname.setAdapter(aa);


        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        duplicate_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DuplicateActivity.this,HomeActivity.class));
            }
        });

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(DuplicateActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        spinner_duplicate_batchname.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner_duplicate_batchname.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etDate.setText(sdf.format(myCalendar.getTime()));
    }

}
