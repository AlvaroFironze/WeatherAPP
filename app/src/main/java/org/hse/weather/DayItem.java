package org.hse.weather;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayItem {
    public String city = "Moscow";
    public String weather="sun";
    public String today="Monday";
    public String imageUrl="";
    public String temp="0";
    public String mint="0";
    public String maxt="10";
    Map<String, String[]> map = new HashMap<String, String[]>() {{
        put("Clear", new String[]{"morning_clear.png","day_clear.png","evening_clear.png","night_clear.png","icon_day_sunny.png"});
        put("Sunny", new String[]{"morning_clear.png","day_clear.png","evening_clear.png","night_clear.png","icon_day_sunny.png"});
        put("Calm", new String[]{"morning_clear.png","day_clear.png","evening_clear.png","night_clear.png","icon_day_sunny.png"});
        put("Hot", new String[]{"morning_clear.png","day_clear.png","evening_clear.png","night_clear.png","icon_day_sunny.png"});
        put("Dry", new String[]{"morning_clear.png","day_clear.png","evening_clear.png","night_clear.png","icon_day_sunny.png"});


        put("Partly cloudy", new String[]{"morning_cloud.png","day_cloud.png","evening_cloud.png","night_cloud.png","icon_day_sunny_overcast.png"});
        put("Mostly cloudy", new String[]{"morning_cloud.png","day_cloud.png","evening_cloud.png","night_cloud.png","icon_cloudy.png"});
        put("Overcast", new String[]{"morning_cloud.png","day_cloud.png","evening_cloud.png","night_cloud.png","icon_cloudy.png"});
        put("Foggy", new String[]{"morning_cloud.png","day_cloud.png","evening_cloud.png","night_cloud.png","icon_cloud.png"});
        put("Misty", new String[]{"morning_cloud.png","day_cloud.png","evening_cloud.png","night_cloud.png","icon_cloud.png"});
        put("Smoggy", new String[]{"morning_cloud.png","day_cloud.png","evening_cloud.png","night_cloud.png","icon_cloud.png"});
        put("Hazy", new String[]{"morning_cloud.png","day_cloud.png","evening_cloud.png","night_cloud.png","icon_cloud.png"});
        put("Windy", new String[]{"morning_cloud.png","day_cloud.png","evening_cloud.png","night_cloud.png","icon_cloudy_gusts.png"});

        put("Wet", new String[]{"morning_rain.png","day_rain.png","evening_rain.png","night_rain.png","icon_sleet.png"});
        put("Rainy", new String[]{"morning_rain.png","day_rain.png","evening_rain.png","night_rain.png","icon_rain.png"});
        put("Light rain", new String[]{"morning_rain.png","day_rain.png","evening_rain.png","night_rain.png","icon_rain.png"});
        put("Moderate rain", new String[]{"morning_rain.png","day_rain.png","evening_rain.png","night_rain.png","icon_rain.png"});
        put("Moderate drizzle", new String[]{"morning_rain.png","day_rain.png","evening_rain.png","night_rain.png","icon_sleet.png"});
        put("Heavy drizzle", new String[]{"morning_rain.png","day_rain.png","evening_rain.png","night_rain.png","icon_sleet.png"});
        put("Light drizzle", new String[]{"morning_rain.png","day_rain.png","evening_rain.png","night_rain.png","icon_sleet.png"});
        put("Drizzle", new String[]{"morning_rain.png","day_rain.png","evening_rain.png","night_rain.png","icon_sleet.png"});
        put("Heavy rain", new String[]{"morning_rain.png","day_rain.png","evening_rain.png","night_rain.png","icon_rain.png"});
        put("Freezing rain", new String[]{"morning_rain.png","day_rain.png","evening_rain.png","night_rain.png","icon_rain.png"});
        put("Humid", new String[]{"morning_rain.png","day_rain.png","evening_rain.png","night_rain.png","icon_rain.png"});
        put("Sleet", new String[]{"morning_rain.png","day_rain.png","evening_rain.png","night_rain.png","icon_sleet.png"});
        put("Ice", new String[]{"morning_snow.png","day_snow.png","evening_snow.png","night_snow.png","icon_snow.png"});
        put("Frost", new String[]{"morning_snow.png","day_snow.png","evening_snow.png","night_snow.png","icon_snow.png"});
        put("Icy", new String[]{"morning_snow.png","day_snow.png","evening_snow.png","night_snow.png","icon_snow.png"});
        put("Slippery", new String[]{"morning_snow.png","day_snow.png","evening_snow.png","night_snow.png","icon_snow.png"});
        put("Light snow", new String[]{"morning_snow.png","day_snow.png","evening_snow.png","night_snow.png","icon_snow.png"});
        put("Moderate snow", new String[]{"morning_snow.png","day_snow.png","evening_snow.png","night_snow.png","icon_snow.png"});
        put("Heavy snow", new String[]{"morning_snow.png","day_snow.png","evening_snow.png","night_snow.png","icon_snow.png"});
        put("Snowy", new String[]{"morning_snow.png","day_snow.png","evening_snow.png","night_snow.png","icon_snow.png"});
        put("Cold", new String[]{"morning_snow.png","day_snow.png","evening_snow.png","night_snow.png","icon_snowflake_cold.png"});

        put("Thunderstorm", new String[]{"morning_groza.png","day_groza.png","evening_groza.png","night_groza.png","icon_lightning.png"});
        put("Scattered thunderstorms",  new String[]{"morning_groza.png","day_groza.png","evening_groza.png","night_groza.png","icon_lightning.png"});
        put("Thunderstorms likely",  new String[]{"morning_groza.png","day_groza.png","evening_groza.png","night_groza.png","icon_lightning.png"});
        put("Severe thunderstorms",  new String[]{"morning_groza.png","day_groza.png","evening_groza.png","night_groza.png","icon_lightning.png"});
        put("Tornadoes",  new String[]{"morning_groza.png","day_groza.png","evening_groza.png","night_groza.png","icon_storm_showers.png"});
        put("Tropical storm",  new String[]{"morning_groza.png","day_groza.png","evening_groza.png","night_groza.png","icon_storm_showers.png"});
        put("Hurricane",  new String[]{"morning_groza.png","day_groza.png","evening_groza.png","night_groza.png","icon_storm_showers.png"});
        put("Blustery",  new String[]{"morning_groza.png","day_groza.png","evening_groza.png","night_groza.png","icon_storm_showers.png"});
        put("Stormy",  new String[]{"morning_groza.png","day_groza.png","evening_groza.png","night_groza.png","icon_storm_showers.png"});
        put("Squally",  new String[]{"morning_groza.png","day_groza.png","evening_groza.png","night_groza.png","icon_storm_showers.png"});
        put("Showery",  new String[]{"morning_rain.png","day_rain.png","evening_rain.png","night_rain.png","icon_sleet.png"});
        put("Variable",  new String[]{"morning_groza.png","day_groza.png","evening_groza.png","night_groza.png","icon_storm_showers.png"});
        put("",new String[]{});
    }};

    public DayItem(String city, String weather, String today, String temp) {
        Calendar c = Calendar.getInstance();
        try {
            temp = temp.split(".")[0];
        } catch (Exception e) {

        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");


        Date date = null;
        try {
            date = dateFormat.parse(today);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        String[] days={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        this.city = city;
        this.weather = weather;
        this.today =days[dayOfWeek] ;
        this.temp = temp+"°C";
        Log.e("88",today.substring(11,13).replace(" ","0").replace(":",""));
        if (today!=null&& Integer.parseInt(today.substring(11,13).replace(" ","0").replace(":",""))>=5 &&Integer.parseInt(today.substring(11,13).replace(" ","0").replace(":",""))<= 11){
        this.imageUrl=map.get(weather)[0];
        Log.e("88","я тут");
        }else{
        if (today!=null&& Integer.parseInt(today.substring(11,13).replace(" ","0").replace(":",""))>=12 &&Integer.parseInt(today.substring(11,13).replace(" ","0").replace(":",""))<= 18){
            this.imageUrl=map.get(weather)[1];
        }else{
        if (today!=null&& Integer.parseInt(today.substring(11,13).replace(" ","0").replace(":",""))>=19 &&Integer.parseInt(today.substring(11,13).replace(" ","0").replace(":",""))<= 23){
            this.imageUrl=map.get(weather)[2];
        }else{
            this.imageUrl=map.get(weather)[3];
            Log.e("88","Не тут");
        }}}
    }
}
