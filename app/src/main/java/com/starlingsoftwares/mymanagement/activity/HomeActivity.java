package com.starlingsoftwares.mymanagement.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.starlingsoftwares.mymanagement.R;
import com.starlingsoftwares.mymanagement.Utils.RecyclerItemClickListener;
import com.starlingsoftwares.mymanagement.adapter.HomeAdapter;
import com.starlingsoftwares.mymanagement.model.Home;

import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Home> homeArrayList;
    HomeAdapter homeAdapter;
    EditText editText;
    ImageView  imgMenu;
    int flag=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        editText=findViewById(R.id.et_batchname);
        imgMenu=findViewById(R.id.img_menu);
        recyclerView = findViewById(R.id.rv_home_billing);
        homeArrayList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        homeAdapter = new HomeAdapter(homeArrayList, HomeActivity.this);
        recyclerView.setAdapter(homeAdapter);


        homeArrayList.add(new Home("Gurugram", R.drawable.ic_point));
        homeArrayList.add(new Home("Faridabad", R.drawable.ic_point));
        homeArrayList.add(new Home("Gaziabad", R.drawable.ic_point));
        homeArrayList.add(new Home("Gali", R.drawable.ic_point));
        homeArrayList.add(new Home("Desavar", R.drawable.ic_point));
        homeArrayList.add(new Home("Taj", R.drawable.ic_point));

        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MenuActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left, R.anim.right);
            }
        });


        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flag==0){
                    recyclerView.setVisibility(View.VISIBLE);
                    flag=1;

                }else {
                    recyclerView.setVisibility(View.GONE);
                    flag=0;

                }
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                String s = homeArrayList.get(position).getPlace();
                editText.setText(s);
                recyclerView.setVisibility(View.GONE);
                String v = homeArrayList.get(position).getId();
            }

            @Override
            public void onLongClick(View view, int position) {
                recyclerView.setVisibility(View.GONE);
            }
        }));



    }
}
