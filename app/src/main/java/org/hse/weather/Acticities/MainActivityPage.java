package org.hse.weather.Acticities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.hse.weather.DayItem;
import org.hse.weather.PageAdapter;
import org.hse.weather.R;
import org.hse.weather.ViewModel_Reposit_ServerData.MainViewModel;
import org.hse.weather.Week_Temps_Item;
import org.hse.weather.weather_weekAdapter;
import org.hse.weather.weather_week_class;

import java.util.ArrayList;
import java.util.List;

public class MainActivityPage extends AppCompatActivity {

    List<weather_week_class> list = new ArrayList<>();
    public TextView city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_page);
        Log.e("-","Мы в странице!");

    }

}