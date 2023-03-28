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

class weather_hourAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<Today_Temps_Item> dataList = new ArrayList<>();
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        Log.e("","onCreateViewHolder");
        Context context =parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.activity_today_temps_item, parent,  false);
        Log.e("","ICreateViewHolder");
        return new weather_hour(contactView, context);
    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
    @Override
    public void onBindViewHolder (RecyclerView.ViewHolder viewHolder, int position) {
        Log.e("","onBindViewHolder"+position);
        Today_Temps_Item data =dataList.get(position);
            ((weather_hour) viewHolder).bind(data);
    }
    public void setDataList(List<Today_Temps_Item> list) {
        dataList=list;
    }
}
