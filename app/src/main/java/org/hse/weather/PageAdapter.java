package org.hse.weather;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.hse.weather.ViewModel_Reposit_ServerData.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class PageAdapter extends RecyclerView.Adapter{
    private List<weather_week_class> list = new ArrayList<>();
    private List<Today_Temps_Item> glist = new ArrayList<>();
    private List<DayItem> dataList = new ArrayList<>();
    private RecyclerView week;
    private RecyclerView hours;
    private MainViewModel mainViewModel;
    private weather_weekAdapter adapter;
    private weather_hourAdapter hadapter;
    private TextView city;
    private MainViewModel mMainViewModel;
    String name;

    public PageAdapter(MainViewModel mainViewModel) {

        mMainViewModel = mainViewModel;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        Log.e("","onCreateViewHolder");
        Context context =parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.activity_main_page, parent,  false);
        city=contactView.findViewById(R.id.City);
        week= contactView.findViewById(R.id.Week_Temps);
        hours=contactView.findViewById(R.id.Today_Temps);
        LinearLayoutManager layoutManager = new LinearLayoutManager(parent.getContext());
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(parent.getContext(),layoutManager.HORIZONTAL,false);
        week.setLayoutManager(layoutManager);
        hours.setLayoutManager(layoutManager2);
        week.addItemDecoration(new DividerItemDecoration(context, layoutManager.getOrientation()));

        hours.addItemDecoration(new HorizontalSpaceItemDecoration(32));
        Log.e("","ICreateViewHolder");
        return new page(contactView, context);
    }


    @Override
    public void onBindViewHolder (RecyclerView.ViewHolder viewHolder, int position) {

        Log.e("","onBindViewHolder"+position);
        DayItem data = dataList.get(position);
        Log.e("",data.city);
        mMainViewModel.getWeather(data.city).observe((LifecycleOwner) viewHolder.itemView.getContext(), weatherItems ->  {
            list=(weatherItems);
            adapter = new weather_weekAdapter();
            week.setAdapter(adapter);

            adapter.setDataList(list);
            Log.e("-",list.get(0).mint);
            Log.e("-",list.get(1).mint);
            Log.e("-",list.get(2).mint);
            data.mint=list.get(0).mint;
            data.maxt=list.get(0).maxt;
            ((page) viewHolder).bind(data);
        });
        mMainViewModel.getHours(data.city).observe((LifecycleOwner) viewHolder.itemView.getContext(), HoursItems ->  {
            glist=(HoursItems);
            hadapter = new weather_hourAdapter();
            hours.setAdapter(hadapter);

            hadapter.setDataList(glist);
            Log.e("-",glist.get(0).Today_Hour);
            Log.e("-",glist.get(1).Today_Hour);
            Log.e("-",glist.get(2).Today_Hour);
        });
        ((page) viewHolder).bind(data);
    }
    @Override
    public int getItemCount() { return dataList.size();
    }

    public void setDataList(List<DayItem> list) {
        dataList=list;
    }
}
