package org.hse.weather;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class weather_week extends RecyclerView.ViewHolder {
    private TextView Week_day;
    private ImageView Week_icon;
    private TextView Week_Temp_Day;
    private TextView Week_Temp_Night;
    private Context context;


    public weather_week(View itemView, Context context) {
        super(itemView);
        Week_day = itemView.findViewById(R.id.Week_day);
        Week_icon = itemView.findViewById(R.id.Week_icon);
        Week_Temp_Day = itemView.findViewById(R.id.Week_Temp_Day);
        Week_Temp_Night = itemView.findViewById(R.id.Week_Temp_Night);
        this.context=context;
    }

    public void bind(final weather_week_class data) {
        Log.e("wall","wall"+data.imageUrl.substring(0,data.imageUrl.length()-4));
        int imageResource = context.getResources().getIdentifier(data.imageUrl.substring(0,data.imageUrl.length()-4), "drawable", context.getPackageName());
        Log.e("-", (String.valueOf(imageResource)));
        Week_day.setText(data.date);
        Week_Temp_Day.setText(data.maxt);
        Week_Temp_Night.setText(data.mint);
        Week_icon.setImageResource(imageResource);
        Week_icon.setColorFilter(Color.WHITE);


    }
}
