package com.starlingsoftwares.mymanagement.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.starlingsoftwares.mymanagement.R;
import com.starlingsoftwares.mymanagement.adapter.DeleteAdapter;
import com.starlingsoftwares.mymanagement.adapter.HomeAdapter;
import com.starlingsoftwares.mymanagement.model.Delete;
import com.starlingsoftwares.mymanagement.model.Home;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class DeleteActivity extends AppCompatActivity {
    ImageView delete_back;
    EditText etFromDate, etToDate;
    Calendar myCalendar = Calendar.getInstance();
    Spinner spinner_delete_batchname;
    RecyclerView recycler_delete_items;
    ArrayList<Delete> deleteArrayList;
    DeleteAdapter deleteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        getSupportActionBar().hide();

        delete_back = findViewById(R.id.delete_back);
        etFromDate = findViewById(R.id.et_from_date);
        etToDate = findViewById(R.id.et_to_date);
        deleteArrayList = new ArrayList<>();

        recycler_delete_items = findViewById(R.id.recycler_delete_items);
        recycler_delete_items.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        deleteAdapter = new DeleteAdapter(deleteArrayList, DeleteActivity.this);
        recycler_delete_items.setAdapter(deleteAdapter);


        deleteArrayList.add(new Delete("ID1"));
        deleteArrayList.add(new Delete("ID2"));
        deleteArrayList.add(new Delete("ID3"));
        deleteArrayList.add(new Delete("ID4"));
        deleteArrayList.add(new Delete("ID5"));
        deleteArrayList.add(new Delete("ID6"));
        deleteArrayList.add(new Delete("ID7"));
        deleteArrayList.add(new Delete("ID8"));
        deleteArrayList.add(new Delete("ID9"));
        deleteArrayList.add(new Delete("ID10"));
        deleteArrayList.add(new Delete("ID11"));


        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                fromdate();
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
                todate();
            }

        };

        String[] city_list = new String[5];
        city_list[0] = "Select Batch";
        city_list[1] = "Gurgaon";
        city_list[2] = "Faridabad";
        city_list[3] = "Gaziabad";
        city_list[4] = "Gali";

        ArrayAdapter<String> aa = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, city_list);
        spinner_delete_batchname = findViewById(R.id.spinner_delete_batchname);
        spinner_delete_batchname.setAdapter(aa);


        delete_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DeleteActivity.this, MenuActivity.class));
            }
        });

        etFromDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(DeleteActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        etToDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(DeleteActivity.this, date1, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void fromdate() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etFromDate.setText(sdf.format(myCalendar.getTime()));
    }

    private void todate() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etToDate.setText(sdf.format(myCalendar.getTime()));
    }

}
