package org.hse.weather;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class page extends RecyclerView.ViewHolder {
    private TextView City;
    private ImageView Wallpaper;
    private TextView Now_Weather;
    private TextView Now_Temp;
    private TextView Today;
    private TextView Today_Day_Temp;
    private TextView Today_Night_Temp;
    private Context context;

    public page(View itemView, Context context) {
        super(itemView);
        City = itemView.findViewById(R.id.City);
        Wallpaper = itemView.findViewById(R.id.Wallpaper);
        Now_Weather = itemView.findViewById(R.id.Now_Weather);
        Now_Temp = itemView.findViewById(R.id.Now_Temp);
        Today = itemView.findViewById(R.id.Today);
        Today_Day_Temp = itemView.findViewById(R.id.Today_Day_Temp);
        Today_Night_Temp = itemView.findViewById(R.id.Today_Night_Temp);
        this.context=context;
    }

    public void bind(final DayItem data) {
        Log.e("wall","wall"+data.imageUrl.substring(0,data.imageUrl.length()-4));
        int imageResource = context.getResources().getIdentifier(data.imageUrl.substring(0,data.imageUrl.length()-4), "drawable", context.getPackageName());
        Log.e("-", (String.valueOf(imageResource)));
        City.setText(data.city);
        Now_Weather.setText(data.weather);
        Now_Temp.setText(data.temp);
        Today.setText(data.today);
        Today_Day_Temp.setText(data.maxt);
        Today_Night_Temp.setText(data.mint);
        Wallpaper.setImageResource(imageResource);
    }
}
