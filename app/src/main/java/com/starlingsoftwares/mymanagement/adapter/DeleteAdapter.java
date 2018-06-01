package com.starlingsoftwares.mymanagement.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.starlingsoftwares.mymanagement.R;
import com.starlingsoftwares.mymanagement.model.Delete;
import com.starlingsoftwares.mymanagement.model.Home;

import java.util.ArrayList;

public class DeleteAdapter extends RecyclerView.Adapter<DeleteAdapter.DeleteHolder> {
    private ArrayList<Delete> deleteArrayList;
    Activity activity;


    public DeleteAdapter(ArrayList<Delete> deletes, Activity activity) {
        this.deleteArrayList = deletes;
        this.activity = activity;
    }

    @NonNull
    @Override
    public DeleteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_delete, parent, false);
        return new DeleteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeleteHolder holder, int position) {
        final Delete delete = deleteArrayList.get(position);
        holder.uniqueid.setText(delete.getUniqueId());

//            Picasso.get().load(url).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        if (deleteArrayList == null)
            return 0;
        return deleteArrayList.size();
    }


    public class DeleteHolder extends RecyclerView.ViewHolder {

        public TextView uniqueid;
//        private ImageView imageView;


        public DeleteHolder(View itemView) {
            super(itemView);

            uniqueid = itemView.findViewById(R.id.txt_delete_uniqueid);
//            id = itemView.findViewById(R.id.txt_home_placeid);
//            imageView = itemView.findViewById(R.id.txt_chatdate);


        }

    }
}
