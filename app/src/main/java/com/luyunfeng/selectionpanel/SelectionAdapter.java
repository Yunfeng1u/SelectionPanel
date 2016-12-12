package com.luyunfeng.selectionpanel;


import com.luyunfeng.selectionpanellibrary.adapter.BaseViewHolder;
import com.luyunfeng.selectionpanellibrary.adapter.Selection1Adapter;

import java.util.List;

/**
 * Created by luyunfeng on 2016/12/8.
 */

public class SelectionAdapter extends Selection1Adapter<Airport> {

    public SelectionAdapter(List<Airport> list) {
        super(list);
    }

    @Override
    protected void convert(BaseViewHolder holder, Airport entity) {
        super.convert(holder, entity);
        holder.setText(R.id.cb_item, entity.getName());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_selection;
    }
}
