package com.starlingsoftwares.mymanagement.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.starlingsoftwares.mymanagement.R;
import com.starlingsoftwares.mymanagement.model.Home;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder> {
    private ArrayList<Home> homeArrayList;
    Activity activity;


    public HomeAdapter(ArrayList<Home> homes, Activity activity) {
        this.homeArrayList = homes;
        this.activity = activity;
    }

    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_home, parent, false);
        return new HomeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        final Home home = homeArrayList.get(position);
        holder.place.setText(home.getPlace());

//            Picasso.get().load(url).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        if (homeArrayList == null)
            return 0;
        return homeArrayList.size();
    }


    public class HomeHolder extends RecyclerView.ViewHolder {

        public TextView place,id;
//        private ImageView imageView;


        public HomeHolder(View itemView) {
            super(itemView);

            place = itemView.findViewById(R.id.txt_home_place);
            id = itemView.findViewById(R.id.txt_home_placeid);
//            imageView = itemView.findViewById(R.id.txt_chatdate);


        }

    }
}
