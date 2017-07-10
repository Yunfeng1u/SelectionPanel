package com.luyunfeng.selectionpanel_sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.luyunfeng.selectionpanel.OnSelectionChangedListener;
import com.luyunfeng.selectionpanel.SelectionPanel;
import com.luyunfeng.selectionpanel.adapter.BaseSelectionAdapter;
import com.luyunfeng.selectionpanel.adapter.MultiSelectionAdapter;
import com.luyunfeng.selectionpanel.adapter.MultiSelectionAllAdapter;
import com.luyunfeng.selectionpanel.adapter.SingleSelectionAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * attr
 * align
 * collapse/expand
 */
public class MainActivity extends AppCompatActivity implements OnSelectionChangedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt_single).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseSelectionAdapter adapter = new SingleSelectionAdapter<>(getList());
                adapter.setOnSelectionChangedListener(MainActivity.this);
                build(adapter);
            }
        });

        findViewById(R.id.bt_multiple).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseSelectionAdapter adapter = new MultiSelectionAdapter<>(getList());
                adapter.setOnSelectionChangedListener(MainActivity.this);
                build(adapter);
            }
        });

        findViewById(R.id.bt_multiple_all).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseSelectionAdapter adapter = new MultiSelectionAllAdapter<>(getList());
                adapter.setItemLayoutID(R.layout.item_selection);
                adapter.setOnSelectionChangedListener(MainActivity.this);
                build(adapter);
            }
        });

        findViewById(R.id.bt_custom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<MyBean> list = new ArrayList<MyBean>(){
                    {
                        add(new MyBean("全选", false));
                        add(new MyBean("L", false));
                        add(new MyBean("U", false));
                        add(new MyBean("Y", false));
                        add(new MyBean("U", false));
                        add(new MyBean("N", false));
                        add(new MyBean("F", false));
                        add(new MyBean("E", false));
                        add(new MyBean("N", false));
                        add(new MyBean("G", false));
                    }
                };
                MySelectionAdapter adapter = new MySelectionAdapter(list);
                adapter.setListener(new MySelectionChangedListener<String>() {
                    @Override
                    public void onSelectionChanged(List<String> list) {
                        TextView tv_result = (TextView) findViewById(R.id.tv_result);
                        tv_result.setText("Text: " + list.toString());
                    }
                });
                build(adapter);
            }
        });

        findViewById(R.id.bt_single).performClick();
    }

    private List<Airport> getList() {
        return new ArrayList<Airport>() {
            {
                add(new Airport("不限"));
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
    }

    private void build(RecyclerView.Adapter adapter) {
        SelectionPanel sp = (SelectionPanel) findViewById(R.id.sp);
        sp.setItemMargin(32, 32, 32, 32);
        sp.setAdapter(adapter);
    }

    @Override
    public void onSelectionChanged(List<Integer> list) {
        TextView tv_result = (TextView) findViewById(R.id.tv_result);
        tv_result.setText("Index: " + list.toString());
    }
}
