package org.hse.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.hse.weather.Acticities.MainActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    String[] items;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;
    ArrayList<String> list=new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        getSupportActionBar().hide();
        list = getIntent().getStringArrayListExtra("name");
        listView=(ListView)findViewById(R.id.listview);
        editText=(EditText)findViewById(R.id.txtsearch);
        initList();

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().equals("")){
                    // reset listview
                    initList();
                } else {
                    // perform search
                    searchItem(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }


        });

    }

    public void searchItem(String textToSearch){
        for(String item:items){
            if(!item.contains(textToSearch)){
                listItems.remove(item);
            }
        }
        adapter.notifyDataSetChanged();
    }

    public void initList(){
        items=new String[]{"Perm","London","Moscow","Paris", "Berlin", "Rome", "Minsk", "Riga", "Lissabon", "Cairo"};
        listItems=new ArrayList<>(Arrays.asList(items));
        adapter=new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtitem, listItems);
        listView.setAdapter(adapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Log.e("+",items[position]);
                list.add(items[position]);
            showadd(list);

            }

        });

    }
    private void showadd(ArrayList<String> name) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("name",name);
        startActivity(intent);
    }
}

