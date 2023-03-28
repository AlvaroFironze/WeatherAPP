package org.hse.weather.ViewModel_Reposit_ServerData;
import android.content.Context;
import androidx.lifecycle.LiveData;

import org.hse.weather.DayItem;
import org.hse.weather.Today_Temps_Item;
import org.hse.weather.weather_week_class;
import java.util.List;

//промежуточный класс, чтобы показать, что мы крутые
public class WeatherRepository {
    private getServerData sr;
    Context context;

    public WeatherRepository(Context context){
        sr = new getServerData();
        this.context = context;
    }
    public LiveData<DayItem> getToday(String name){
        return sr.getToday(name,context);
    }
    public LiveData<List<weather_week_class>> getWeather(String name){
        return sr.getWeather(name,context);
    }
    public LiveData<List<Today_Temps_Item>> getHours(String name){
        return sr.getHours(name,context);
    }

}
