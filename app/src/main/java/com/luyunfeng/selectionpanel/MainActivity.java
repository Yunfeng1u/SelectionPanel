package com.luyunfeng.selectionpanel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.luyunfeng.selectionpanellibrary.OnSelectionChangedListener;
import com.luyunfeng.selectionpanellibrary.SelectionBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnSelectionChangedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Airport> airportList = new ArrayList<Airport>() {
            {
                add(new Airport("拉瓜迪亚机场"));
                add(new Airport("肯尼迪国际机场"));
                add(new Airport("纽瓦克机场"));
                add(new Airport("洛杉矶国际机场"));
                add(new Airport("旧金山国际机场"));
                add(new Airport("戴高乐国际机场"));
                add(new Airport("奥利机场"));
                add(new Airport("希思罗国际机场"));
                add(new Airport("巴尔的摩华盛顿机场"));
                add(new Airport("奥黑尔国际机场"));
            }
        };

        //airportList.get(5).setSelect(true);

        RecyclerView mRv = (RecyclerView) findViewById(R.id.rv);

        new SelectionBuilder()
                .setAdapter(new SelectionAdapter(airportList))
                .setOnSelectionChangedListener(this)
                .setRecyclerView(mRv)
                .build();
    }

    @Override
    public void onSelectionChanged(List<Integer> list) {
        Log.d("test", list.toString());
    }
}
