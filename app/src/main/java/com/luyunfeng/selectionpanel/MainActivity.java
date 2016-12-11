package com.luyunfeng.selectionpanel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.luyunfeng.selectionpanel.adapter.SelectionAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnSelectionChangedListener{
    private List<TestBean> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        RecyclerView mRv = (RecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new FlowLayoutManager());//自己写的流式布局
        SelectionAdapter adapter = new SelectionAdapter(mDatas);
        adapter.setOnSelectionChangedListener(this);
        mRv.setAdapter(adapter);
    }

    private int i = 0;

    public List<TestBean> initDatas() {
        mDatas = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            mDatas.add(new TestBean((i++) + " 张"));
            mDatas.add(new TestBean((i++) + " 旭童"));
            mDatas.add(new TestBean((i++) + " 多种type"));
            mDatas.add(new TestBean((i++) + "    遍"));
            mDatas.add(new TestBean((i++) + "   多种type"));
            mDatas.add(new TestBean((i++) + "  多种type"));
            mDatas.add(new TestBean((i++) + "  多种type"));
            mDatas.add(new TestBean((i++) + "  多种type"));
        }
        return mDatas;
    }

    @Override
    public void onSelectionChanged(List<Integer> list) {
        Log.d("test", list.toString());
    }
}
