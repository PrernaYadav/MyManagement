package com.starlingsoftwares.mymanagement.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.starlingsoftwares.mymanagement.R;
import com.starlingsoftwares.mymanagement.Utils.RecyclerItemClickListener;
import com.starlingsoftwares.mymanagement.adapter.HomeAdapter;
import com.starlingsoftwares.mymanagement.model.Home;

import java.util.ArrayList;

public class SeriesBillingFragment extends Fragment{

    EditText et_series_batchname;
    RecyclerView rv_series_billing;
    ArrayList<Home> homeArrayList;
    HomeAdapter homeAdapter;
    int flag=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_series_billing, container, false);
        rv_series_billing = v.findViewById(R.id.rv_series_billing);
        et_series_batchname = v.findViewById(R.id.et_series_batchname);
        homeArrayList = new ArrayList<>();
        rv_series_billing.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        homeAdapter = new HomeAdapter(homeArrayList, getActivity());
        rv_series_billing.setAdapter(homeAdapter);


        homeArrayList.add(new Home("Gurugram"));
        homeArrayList.add(new Home("Faridabad"));
        homeArrayList.add(new Home("Gaziabad"));
        homeArrayList.add(new Home("Gali"));
        homeArrayList.add(new Home("Desavar"));
        homeArrayList.add(new Home("Taj"));

        et_series_batchname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flag==0){
                    rv_series_billing.setVisibility(View.VISIBLE);
                    flag=1;

                }else {
                    rv_series_billing.setVisibility(View.GONE);
                    flag=0;

                }
            }
        });

        rv_series_billing.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), rv_series_billing, new RecyclerItemClickListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                String s = homeArrayList.get(position).getPlace();
                et_series_batchname.setText(s);
                rv_series_billing.setVisibility(View.GONE);
                String v = homeArrayList.get(position).getId();
            }

            @Override
            public void onLongClick(View view, int position) {
                rv_series_billing.setVisibility(View.GONE);
            }
        }));

        return v;
    }
}
