package com.starlingsoftwares.mymanagement.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


import com.starlingsoftwares.mymanagement.R;
import com.starlingsoftwares.mymanagement.Utils.RecyclerItemClickListener;
import com.starlingsoftwares.mymanagement.activity.HomeActivity;
import com.starlingsoftwares.mymanagement.adapter.HomeAdapter;
import com.starlingsoftwares.mymanagement.model.Home;

import java.util.ArrayList;
import java.util.List;

public class CrossBillingFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Home> homeArrayList;
    HomeAdapter homeAdapter;
    EditText et_cross_batchname;
    int flag=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cross_billing, container, false);

        recyclerView = v.findViewById(R.id.rv_cross_billing);
        et_cross_batchname = v.findViewById(R.id.et_cross_batchname);
        homeArrayList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        homeAdapter = new HomeAdapter(homeArrayList, getActivity());
        recyclerView.setAdapter(homeAdapter);


        homeArrayList.add(new Home("Gurugram"));
        homeArrayList.add(new Home("Faridabad"));
        homeArrayList.add(new Home("Gaziabad"));
        homeArrayList.add(new Home("Gali"));
        homeArrayList.add(new Home("Desavar"));
        homeArrayList.add(new Home("Taj"));

        et_cross_batchname.setOnClickListener(new View.OnClickListener() {
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

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                String s = homeArrayList.get(position).getPlace();
                et_cross_batchname.setText(s);
                recyclerView.setVisibility(View.GONE);
                String v = homeArrayList.get(position).getId();
            }

            @Override
            public void onLongClick(View view, int position) {
                recyclerView.setVisibility(View.GONE);
            }
        }));




        return v;
    }
}
