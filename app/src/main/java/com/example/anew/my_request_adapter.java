package com.example.anew;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class my_request_adapter extends RecyclerView.Adapter<my_request_adapter.ViewHolder> {

    List<my_request_class.request_data> mValues;
    Context mContext;


    @NonNull
    @Override
    public my_request_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }


    @Override
    public void onBindViewHolder(@NonNull my_request_adapter.ViewHolder viewHolder, int i) {
        viewHolder.date.setText(mValues.get(i).date);
        viewHolder.area.setText(mValues.get(i).area);
        viewHolder.city.setText(mValues.get(i).city);
        viewHolder.message.setText(mValues.get(i).message);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView date, area, city, message;
        ImageView image;

        public ViewHolder(View v) {

            super(v);
            date = (TextView) v.findViewById(R.id.myReqDate);
            area = (TextView) v.findViewById(R.id.myReqArea);
            city = (TextView) v.findViewById(R.id.myReqCity);
            image = (ImageView) v.findViewById(R.id.myReqImg);
            message = (TextView) v.findViewById(R.id.myReqMessage);
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

}
