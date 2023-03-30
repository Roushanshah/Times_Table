package com.example.timestables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView TimesTableListView;
    public void generateTimesTable(int TimesTable){
        ArrayList<String> TimesTableContent=new ArrayList<String>();
        for(int i=1;i<=10;i++){
            TimesTableContent.add(Integer.toString(i*TimesTable));
        }

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,TimesTableContent);
        TimesTableListView.setAdapter(arrayAdapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar TimesTableSeekBar=(SeekBar) findViewById(R.id.TimesTableSeekBar);
        TimesTableListView=(ListView) findViewById(R.id.TimesTableListView);

        TimesTableSeekBar.setMax(20);
        TimesTableSeekBar.setProgress(10);
        TimesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int TimesTable;
                if(progress < min){
                    TimesTable=min;
                    TimesTableSeekBar.setProgress(min);
                }else{
                    TimesTable=progress;
                }
                generateTimesTable(TimesTable);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generateTimesTable(10);

    }
}