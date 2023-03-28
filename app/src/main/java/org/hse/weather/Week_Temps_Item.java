package org.hse.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Week_Temps_Item extends AppCompatActivity {
    String Week_day="Monday";
    String Week_icon;
    String  Week_Temp_Day="12";
    String  Week_Temp_Night="0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_temps_item);
    }
}