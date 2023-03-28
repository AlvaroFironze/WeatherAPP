package org.hse.weather;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class weather_hour extends RecyclerView.ViewHolder {
    private TextView Today_Hour;
    private ImageView Today_Icon;
    private TextView Today_Temp;
    private Context context;

    public weather_hour(View itemView, Context context) {
        super(itemView);
        Today_Hour = itemView.findViewById(R.id.Today_Hour);
        Today_Icon = itemView.findViewById(R.id.Today_Icon);
        Today_Temp = itemView.findViewById(R.id.Today_Temp);
        this.context=context;
    }

    public void bind(final Today_Temps_Item data) {
        Log.e("PIC","PIC"+data.Today_Icon.substring(0,data.Today_Icon.length()-4));
        int imageResource = context.getResources().getIdentifier(data.Today_Icon.substring(0,data.Today_Icon.length()-4), "drawable", context.getPackageName());
        Log.e("-", (String.valueOf(imageResource)));
        Today_Hour.setText(data.Today_Hour);
        Today_Icon.setImageResource(imageResource);
        Today_Icon.setColorFilter(Color.WHITE);
        Today_Temp.setText(data.Today_Temp);

    }
}
