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
import com.starlingsoftwares.mymanagement.model.Entry;

import java.util.ArrayList;

public class EntryAdapter extends RecyclerView.Adapter<EntryAdapter.EntryHolder> {
    private ArrayList<Entry> entryArrayList;
    Activity activity;


    public EntryAdapter(ArrayList<Entry> entries, Activity activity) {
        this.entryArrayList = entries;
        this.activity = activity;
    }

    @NonNull
    @Override
    public EntryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_entry, parent, false);
        return new EntryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EntryHolder entryHolder, int position) {
        final Entry entry = entryArrayList.get(position);
        entryHolder.serial.setText(""+entry.getSerial());
        entryHolder.jodi.setText(entry.getJodi());
        entryHolder.price.setText(entry.getPrice());

//            Picasso.get().load(url).into(holder.imageView);

    }

    @Override
    public int getItemCount() {

        return entryArrayList.size();
    }


    public class EntryHolder extends RecyclerView.ViewHolder {

        public TextView serial, jodi, price;
//        private ImageView imageView;


        public EntryHolder(View itemView) {
            super(itemView);
            serial = itemView.findViewById(R.id.txt_entry_serial);
            jodi = itemView.findViewById(R.id.txt_entry_jodi);
            price = itemView.findViewById(R.id.txt_entry_price);

        }

    }
}
