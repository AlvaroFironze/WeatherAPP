package org.hse.weather.Acticities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import org.hse.weather.DayItem;
import org.hse.weather.ListActivity;
import org.hse.weather.PageAdapter;
import org.hse.weather.R;
import org.hse.weather.ViewModel_Reposit_ServerData.MainViewModel;
import org.hse.weather.weather_week_class;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 pages;
    private PageAdapter adapter;
    private MainViewModel mainViewModel;
    private View addb;
    List<DayItem> list = new ArrayList<>();
    ArrayList<String> receivedString=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        addb=findViewById(R.id.addB);
        addb.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                showadd();

            }

    });

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        checkPermission();
        pages= findViewById(R.id.pages);
        pages.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        initData("Perm");
        initData("London");
        if (getIntent().getStringArrayListExtra("name")!=null){
        receivedString = getIntent().getStringArrayListExtra("name");
            for (String a:receivedString) {
                initData(a);


        }}
    }

    private void showadd() {
        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("name",receivedString);
        startActivity(intent);
    }

    private void initData(String name) {

        mainViewModel.getToday(name).observe(this, dayItems -> {

            list.add(dayItems);
            adapter = new PageAdapter(mainViewModel);
            pages.setAdapter(adapter);

            adapter.setDataList(list);
            Log.e("-",list.get(0).today);
        });

       // mainViewModel.getWeather(name).observe(this, weatherItems -> {
        //    List<Boolean> use = new ArrayList<>();
        //    for (weather_week_class weatherItem : weatherItems){
                //какие данные передаем в адаптер
        //    }
            //запихиваем в адаптер тут

       // });


    }

    //работа с инетом
    public void checkPermission() {
        if (!CheckInternet(Manifest.permission.INTERNET)){
            requestPermission(Manifest.permission.INTERNET,1);

               }
    }

    private void requestPermission(String permissionName, int permissionRequestCode) {
        ActivityCompat.requestPermissions(this, new String[]{permissionName},
                permissionRequestCode);
    }

    public boolean CheckInternet(String permissionName) {
            return (ContextCompat.checkSelfPermission(this, permissionName) == PackageManager.PERMISSION_GRANTED) ;

    }
}