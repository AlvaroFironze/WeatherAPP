package org.hse.weather.ViewModel_Reposit_ServerData;
import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.hse.weather.DayItem;
import org.hse.weather.Today_Temps_Item;
import org.hse.weather.weather_week_class;
import java.util.List;

//запросы к серверу делаем через этот класс
public class MainViewModel extends AndroidViewModel {
    private final WeatherRepository repository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = new WeatherRepository(application);
    }
    public LiveData<DayItem> getToday(String name){
        return repository.getToday(name);
    }
    public LiveData<List<weather_week_class>> getWeather(String name){
        return repository.getWeather(name);
    }
        public LiveData<List<Today_Temps_Item>> getHours(String name){
        return repository.getHours(name);
    }



}
