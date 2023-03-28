package org.hse.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class Today_Temps_Item extends AppCompatActivity {
    public String Today_Hour="0";
    public String Today_Icon;
    public String Today_Temp="12";
    public String weather="sun";
    Map<String, String[]> map = new HashMap<String, String[]>() {{
        put("Clear", new String[]{"morning_clear.png","day_clear.png","evening_clear.png","night_clear.png","icon_day_sunny.png"});
        put("Sunny", new String[]{"morning_clear.png","day_clear.png","evening_clear.png","night_clear.png","icon_day_sunny.png"});
        put("Calm", new String[]{"morning_clear.png","day_clear.png","evening_clear.png","night_clear.png","icon_day_sunny.png"});
        put("Hot", new String[]{"morning_clear.png","day_clear.png","evening_clear.png","night_clear.png","icon_day_sunny.png"});
        put("Dry", new String[]{"morning_clear.png","day_clear.png","evening_clear.png","night_clear.png","icon_day_sunny.png"});

        put("Cloudy", new String[]{"morning_cloud.png","day_cloud.png","evening_cloud.png","night_cloud.png","icon_day_sunny_overcast.png"});
        put("Partly cloudy", new String[]{"morning_cloud.png","day_cloud.png","evening_cloud.png","night_cloud.png","icon_day_sunny_overcast.png"});
        put("Mostly cloudy", new String[]{"morning_cloud.png","day_cloud.png","evening_cloud.png","night_cloud.png","icon_cloudy.png"});
        put("Overcast", new String[]{"morning_cloud.png","day_cloud.png","evening_cloud.png","night_cloud.png","icon_cloudy.png"});
        put("Fog", new String[]{"morning_cloud.png","day_cloud.png","evening_cloud.png","night_cloud.png","icon_cloud.png"});
        put("Mist", new String[]{"morning_cloud.png","day_cloud.png","evening_cloud.png","night_cloud.png","icon_cloud.png"});
        put("Smog", new String[]{"morning_cloud.png","day_cloud.png","evening_cloud.png","night_cloud.png","icon_cloud.png"});
        put("Hazy", new String[]{"morning_cloud.png","day_cloud.png","evening_cloud.png","night_cloud.png","icon_cloud.png"});
        put("Wind", new String[]{"morning_cloud.png","day_cloud.png","evening_cloud.png","night_cloud.png","icon_cloudy_gusts.png"});

        put("Patchy rain possible", new String[]{"morning_rain.png","day_rain.png","evening_rain.png","night_rain.png","icon_sleet.png"});
        put("Patchy rain possible", new String[]{"morning_rain.png","day_rain.png","evening_rain.png","night_rain.png","icon_sleet.png"});
        put("Wet", new String[]{"morning_rain.png","day_rain.png","evening_rain.png","night_rain.png","icon_sleet.png"});
        put("Rain", new String[]{"morning_rain.png","day_rain.png","evening_rain.png","night_rain.png","icon_rain.png"});
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

        put("Light rain shower", new String[]{"morning_groza.png","day_groza.png","evening_groza.png","night_groza.png","icon_lightning.png"});
        put("Scattered thunderstorms",  new String[]{"morning_groza.png","day_groza.png","evening_groza.png","night_groza.png","icon_lightning.png"});
        put("Thunderstorms likely",  new String[]{"morning_groza.png","day_groza.png","evening_groza.png","night_groza.png","icon_lightning.png"});
        put("Severe thunderstorms",  new String[]{"morning_groza.png","day_groza.png","evening_groza.png","night_groza.png","icon_lightning.png"});
        put("Tornadoes",  new String[]{"morning_groza.png","day_groza.png","evening_groza.png","night_groza.png","icon_storm_showers.png"});
        put("Tropical storm",  new String[]{"morning_groza.png","day_groza.png","evening_groza.png","night_groza.png","icon_storm_showers.png"});
        put("Hurricane",  new String[]{"morning_groza.png","day_groza.png","evening_groza.png","night_groza.png","icon_storm_showers.png"});
        put("Blustery",  new String[]{"morning_groza.png","day_groza.png","evening_groza.png","night_groza.png","icon_storm_showers.png"});
        put("Storm",  new String[]{"morning_groza.png","day_groza.png","evening_groza.png","night_groza.png","icon_storm_showers.png"});
        put("Squall",  new String[]{"morning_groza.png","day_groza.png","evening_groza.png","night_groza.png","icon_storm_showers.png"});
        put("Shower",  new String[]{"morning_rain.png","day_rain.png","evening_rain.png","night_rain.png","icon_sleet.png"});
        put("Variable",  new String[]{"morning_groza.png","day_groza.png","evening_groza.png","night_groza.png","icon_storm_showers.png"});
        put("",new String[]{});
    }};
    public Today_Temps_Item(String date, String text, String temp) {


        this.Today_Hour=(date.substring(11,13));
        this.weather=text;
        this.Today_Temp=temp;
        if (text!=null && map.get(text)[4]!=null){

            this.Today_Icon=map.get(text)[4];
        }
        else{
            this.Today_Icon=map.get("Wet")[4];
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_temps_item);
    }
}