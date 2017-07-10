package com.luyunfeng.selectionpanel_sample;


import com.luyunfeng.selectionpanel.adapter.MultiSelectionAllAdapter;

import java.util.List;

/**
 * Created by luyunfeng on 2016/12/8.
 */

public class SelectionAdapter extends MultiSelectionAllAdapter<Airport> {

    public SelectionAdapter(List<Airport> list) {
        super(list);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_selection;
    }
}
