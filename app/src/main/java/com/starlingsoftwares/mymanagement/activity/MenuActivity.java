package com.starlingsoftwares.mymanagement.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.starlingsoftwares.mymanagement.R;

public class MenuActivity extends AppCompatActivity {
    LinearLayout ll_menu_billing, ll_cross_billing, ll_series_billing, ll_duplicate_billing, ll_delete_history, ll_view_history;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().hide();

        ll_menu_billing = findViewById(R.id.ll_menu_billing);
        ll_cross_billing = findViewById(R.id.ll_cross_billing);
        ll_series_billing = findViewById(R.id.ll_series_billing);
        ll_duplicate_billing = findViewById(R.id.ll_duplicate_billing);
        ll_delete_history = findViewById(R.id.ll_delete_history);
        ll_view_history = findViewById(R.id.ll_view_history);

       editor = getSharedPreferences("prerna", MODE_PRIVATE).edit();




        ll_menu_billing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("name", "billing");
                editor.commit();
                startActivity(new Intent(MenuActivity.this, BillingsActivity.class));
            }
        });
        ll_cross_billing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("name", "cross");
                editor.commit();
                startActivity(new Intent(MenuActivity.this, BillingsActivity.class));
            }
        });
        ll_series_billing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("name", "series");
                editor.commit();
                startActivity(new Intent(MenuActivity.this, BillingsActivity.class));
            }
        });
        ll_duplicate_billing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, DuplicateActivity.class));
            }
        });
        ll_delete_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, DeleteActivity.class));
            }
        });
        ll_view_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, ViewActivity.class));
            }
        });


    }

}
