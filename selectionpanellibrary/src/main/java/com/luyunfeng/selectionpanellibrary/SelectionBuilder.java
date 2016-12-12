package com.luyunfeng.selectionpanellibrary;

import android.support.v7.widget.RecyclerView;

import com.luyunfeng.selectionpanellibrary.adapter.BaseSelectionAdapter;

/**
 * Created by luyunfeng on 16/12/12.
 */

public class SelectionBuilder {

    private @SelectionMode int selectionMode = SelectionMode.SINGLE;
    private BaseSelectionAdapter adapter;
    private OnSelectionChangedListener listener;

    public int getSelectionMode() {
        return selectionMode;
    }

    public void setSelectionMode(int selectionMode) {
        this.selectionMode = selectionMode;
    }

    public BaseSelectionAdapter getAdapter() {
        return adapter;
    }

    public SelectionBuilder setAdapter(BaseSelectionAdapter adapter) {
        this.adapter = adapter;
        return this;
    }

    public void build(){
        if (adapter != null) {
            adapter.setOnSelectionChangedListener(listener);
        }
    }

    public OnSelectionChangedListener getOnSelectionChangedListener() {
        return listener;
    }

    public SelectionBuilder setOnSelectionChangedListener(OnSelectionChangedListener listener) {
        this.listener = listener;
        return this;
    }

    public SelectionBuilder setRecyclerView(RecyclerView mRv) {
        mRv.setLayoutManager(new FlowLayoutManager());
        mRv.setAdapter(adapter);
        return this;
    }
}
