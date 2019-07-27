package com.logixcess.republiccargo.agent.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.logixcess.republiccargo.R;
import com.logixcess.republiccargo.models.Box;

import java.util.ArrayList;
import java.util.List;

public class BoxesAdapter extends RecyclerView.Adapter<BoxesAdapter.ViewHolder>
{

    ArrayList<Box> boxList;
    Context my_context;
    public BoxesAdapter(Context context, ArrayList<Box> objects)
    {
        boxList = objects;
        my_context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pickup_item, parent, false);
        return new BoxesAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.tv_name.setText("Ahmad Irfan");
        holder.tv_address.setText("H# 415 Mehboob Market Rehmanpura Lahore");
        holder.tv_distance_from_origin.setText("45 KM Away");
        holder.tv_status.setText("Open");
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView tv_name,tv_address,tv_status,tv_distance_from_origin;
        ImageView iv_customer_pic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_address = itemView.findViewById(R.id.tv_address);
            tv_status = itemView.findViewById(R.id.tv_status);
            tv_distance_from_origin = itemView.findViewById(R.id.tv_distance_from_origin);
            iv_customer_pic = itemView.findViewById(R.id.iv_customer_pic);
        }
    }
}
