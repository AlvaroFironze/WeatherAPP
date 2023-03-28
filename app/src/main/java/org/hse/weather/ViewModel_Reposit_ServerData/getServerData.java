package org.hse.weather.ViewModel_Reposit_ServerData;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.hse.weather.DayItem;
import org.hse.weather.Today_Temps_Item;
import org.hse.weather.weather_week_class;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

//класс для работы с сервером
public class getServerData {
    static final String API_KEY ="22d052671034420e8f7131502230503";
    private final MutableLiveData<List<weather_week_class>> weather = new MutableLiveData<>();
    private final MutableLiveData<List<Today_Temps_Item>> hours_w = new MutableLiveData<>();
    private final MutableLiveData<DayItem> day = new MutableLiveData<>();
    private Context context;
    private JSONArray forecastishe;
    private JSONObject result;


    public LiveData<DayItem> getToday(String name, Context context){
        MutableLiveData<DayItem> day = new MutableLiveData<>();
        getResult(name, context).observeForever(jsonObject -> {
            if (jsonObject != null) {
                parseCurrentData(jsonObject);
                day.setValue(this.day.getValue());
                Log.e("-","!!!"+this.day.getValue().maxt);
            }
        });
        return day;
    }


    public LiveData<List<Today_Temps_Item>> getHours(String name, Context context){
        MutableLiveData<List<Today_Temps_Item>> hours_w = new MutableLiveData<>();
        getResult(name, context).observeForever(jsonObject -> {
            if (jsonObject != null) {
                parseHours(jsonObject.optJSONObject("forecast").optJSONArray("forecastday"));
                hours_w.setValue(this.hours_w.getValue());
            }
        });
        return hours_w;
    }
    public LiveData<List<weather_week_class>> getWeather(String name, Context context){
        MutableLiveData<List<weather_week_class>> weather = new MutableLiveData<>();
        getResult(name, context).observeForever(jsonObject -> {
            if (jsonObject != null) {
                parseDays(jsonObject.optJSONObject("forecast").optJSONArray("forecastday"));
                weather.setValue(this.weather.getValue());
            }
        });
        return weather;
    }

    public LiveData<JSONObject> getResult(String name, Context context) {
        MutableLiveData<JSONObject> result = new MutableLiveData<>();

        String url = "https://api.weatherapi.com/v1/forecast.json" +
                "?key="+API_KEY+"&q="+name+"&days=7&aqi=no&alerts=no";

        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("-", "я получил апи :)");
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            result.setValue(jsonObject);
                        } catch (JSONException e) {
                            Log.e("-", "я не  получил апи :(");
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("MyLog","That didn't work!"+error);
            }
        });
        queue.add(stringRequest);
        return result;
    }


    public void parseCurrentData(JSONObject obj){
        DayItem dayI=null;
        String Now_Weather;
        String Now_Temp;
        String Today;
        String City;
        try {
            City=obj.getJSONObject("location").getString("name");
            Log.e("-",City);
            Now_Weather=obj.getJSONObject("current").getJSONObject("condition").getString("text");
            Log.e("-",Now_Weather);
            Now_Temp=obj.getJSONObject("current").getString("temp_c");
            Log.e("-",Now_Temp);
            Today=obj.getJSONObject("location").getString("localtime");
            Log.e("-",Today);
            forecastishe = obj.getJSONObject("forecast").getJSONArray("forecastday");
            dayI = new DayItem(City, Now_Weather, Today, Now_Temp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e("-",dayI.city+dayI.today);
        day.setValue(dayI);

    }

    public void parseDays(JSONArray obj){
        ArrayList<weather_week_class> list = new ArrayList<>();
        for (int i=0; i<obj.length(); i++ ){
            JSONObject day = null;
            try {
                day = obj.getJSONObject(i);
                String date = day.getString("date");
                String text = day.getJSONObject("day").getJSONObject("condition").getString("text");
                String maxtemp = day.getJSONObject("day").getString("maxtemp_c");
                String mintemp = day.getJSONObject("day").getString("mintemp_c");
                weather_week_class weather = new weather_week_class(date, text, maxtemp, mintemp);
                list.add(weather);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        weather.setValue(list);
    }
    public void parseHours(JSONArray obj){
        ArrayList<Today_Temps_Item> list = new ArrayList<>();
        JSONArray hours = null;
            try {
                JSONObject day = obj.getJSONObject(1);
                hours = day.getJSONArray("hour");
            } catch(JSONException e){
                e.printStackTrace();
            }
                for (int i = 0; i < hours.length(); i++) {
                    try {
                        JSONObject hour = hours.getJSONObject(i);
                        Log.e("-", "?????????????");
                    String date = hour.getString("time");
                        Log.e("-", date);
                    String text = hour.getJSONObject("condition").getString("text");
                        Log.e("-", text);
                    String temp = hour.getString("temp_c");
                        Log.e("-", temp);
                    Today_Temps_Item weather = new Today_Temps_Item(date, text, temp);
                    list.add(weather);

                } catch(JSONException e){
                    e.printStackTrace();
                }
            }
        hours_w.setValue(list);
    }
}
