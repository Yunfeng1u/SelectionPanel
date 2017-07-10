package com.luyunfeng.selectionpanel_sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.luyunfeng.selectionpanel.OnSelectionChangedListener;
import com.luyunfeng.selectionpanel.SelectionPanel;
import com.luyunfeng.selectionpanel.adapter.BaseSelectionAdapter;
import com.luyunfeng.selectionpanel.adapter.MultiSelectionAdapter;
import com.luyunfeng.selectionpanel.adapter.MultiSelectionAllAdapter;
import com.luyunfeng.selectionpanel.adapter.SingleSelectionAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnSelectionChangedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt_single).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseSelectionAdapter adapter = new SingleSelectionAdapter<>(getList());
                build(adapter);
            }
        });

        findViewById(R.id.bt_multiple).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseSelectionAdapter adapter = new MultiSelectionAdapter<>(getList());
                build(adapter);
            }
        });

        findViewById(R.id.bt_multiple_all).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseSelectionAdapter adapter = new MultiSelectionAllAdapter<>(getList());
                build(adapter);
            }
        });

        findViewById(R.id.bt_custom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseSelectionAdapter adapter = new MultiSelectionAllAdapter<Airport>(getList()) {
                    @Override
                    protected int getLayoutId() {
                        return R.layout.item_selection;
                    }
                };
                build(adapter);
            }
        });

        findViewById(R.id.bt_single).performClick();
    }

    private List<Airport> getList() {
        return new ArrayList<Airport>() {
            {
                add(new Airport("全部"));
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

    private void build(BaseSelectionAdapter adapter) {
        SelectionPanel sp = (SelectionPanel) findViewById(R.id.sp);
        sp.setAdapter(adapter)
                .setOnSelectionChangedListener(this)
                .setItemMargin(32, 32, 32, 32)
                .build();
    }

    @Override
    public void onSelectionChanged(List<Integer> list) {
        Toast.makeText(this, list.toString(), Toast.LENGTH_SHORT).show();
    }
}
