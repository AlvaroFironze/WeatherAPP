package org.hse.weather;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class weather_weekAdapter extends RecyclerView.Adapter{

    private List<weather_week_class> dataList = new ArrayList<>();
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        Log.e("","onCreateViewHolder");
        Context context =parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.activity_week_temps_item, parent,  false);
        Log.e("","ICreateViewHolder");
        return new weather_week(contactView, context);
    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
    @Override
    public void onBindViewHolder (RecyclerView.ViewHolder viewHolder, int position) {
        Log.e("","onBindViewHolder"+position);
        weather_week_class data =dataList.get(position);
        Log.e("",data.weath);
        ((weather_week) viewHolder).bind(data);
    }
    public void setDataList(List<weather_week_class> list) {
        dataList=list;
    }

}
