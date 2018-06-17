package com.nhs.androidtutorial.recyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nhs.androidtutorial.R;

import java.util.List;

/**
 * Created by Hoang Son Nguyen nhs@gmx.at on 10.06.2018.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<String> list;
    public RecyclerViewAdapter(List<String> list){
        this.list = list;
    }

    @Override
    public int getItemViewType(int viewType){
        return viewType;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.text_view_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(textView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.countryItem.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        //for every Item
        TextView countryItem;
        public MyViewHolder(TextView itemView) {
            super(itemView);
            countryItem = itemView;
        }
    }

    }

