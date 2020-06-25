package com.example.anew;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Usercomment_adapter extends RecyclerView.Adapter<Usercomment_adapter.ViewHolder> {
    Context context;
    JSONArray data;
    String str_name, str_img;


    public Usercomment_adapter(Activity activity, JSONArray data) {
        context = activity;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.userdesignfile, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        try {

            final JSONObject member = data.getJSONObject(position);
            str_name = member.getString("category_name");
            str_img = "http://192.168.0.177/awarenes/" + member.getString("category_photo");
            holder.rtxt.setText(str_name);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(context, select.class);
                    Bundle bd1 = new Bundle();
                    bd1.putString("a", str_name);
                    intent.putExtras(bd1);
                    Toast.makeText(context, holder.txt.getText().toString(), Toast.LENGTH_SHORT).show();
                    context.startActivity(intent);
                }
            });
            Glide.with(holder.rimg.getContext()).load(str_img).into(holder.rimg);


//            str_img = member.getString("category_photo");
//            holder.rimg.setImageResource(Integer.parseInt(str_img));

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return data.length();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView rtxt,txt;
        ImageView rimg;

        public ViewHolder(View itemView) {
            super(itemView);

            rtxt = itemView.findViewById(R.id.rtxt);
            txt = itemView.findViewById(R.id.uid);
            rimg = itemView.findViewById(R.id.rimg);
//            Glide.with(context)
//                    .load("http://localhost/phpmyadmin/sql.php?db=awareness&table=tbl_category&pos=0")
//                    .into(rimg);


        }
    }
}
