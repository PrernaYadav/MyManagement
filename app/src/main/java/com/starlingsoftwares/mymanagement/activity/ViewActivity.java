package com.starlingsoftwares.mymanagement.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import com.starlingsoftwares.mymanagement.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ViewActivity extends AppCompatActivity {

    ImageView view_back;
    EditText etFromViewDate, etToViewDate;
    Calendar myCalendar = Calendar.getInstance();
    Spinner spinner_view_batchname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        getSupportActionBar().hide();

        view_back = findViewById(R.id.view_back);
        etFromViewDate = findViewById(R.id.et_from_viewdate);
        etToViewDate = findViewById(R.id.et_to_viewdate);
        spinner_view_batchname = findViewById(R.id.spinner_view_batchname);


        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                fromviewdate();
            }

        };
        final DatePickerDialog.OnDateSetListener date1 = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                toviewdate();
            }

        };


        view_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewActivity.this, MenuActivity.class));
            }
        });

        etFromViewDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ViewActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        etToViewDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ViewActivity.this, date1, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        String[] city_list = new String[5];

        city_list[0] = "Select Batch";
        city_list[1] = "Gurgaon";
        city_list[2] = "Faridabad";
        city_list[3] = "Gaziabad";
        city_list[4] = "Gali";

        ArrayAdapter<String> aa = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, city_list);


        spinner_view_batchname = findViewById(R.id.spinner_view_batchname);
        spinner_view_batchname.setAdapter(aa);

    }

    private void fromviewdate() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etFromViewDate.setText(sdf.format(myCalendar.getTime()));
    }

    private void toviewdate() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etToViewDate.setText(sdf.format(myCalendar.getTime()));
    }
}
