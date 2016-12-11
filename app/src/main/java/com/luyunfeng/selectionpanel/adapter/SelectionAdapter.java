package com.luyunfeng.selectionpanel.adapter;

import android.widget.CompoundButton;

import com.luyunfeng.selectionpanel.R;
import com.luyunfeng.selectionpanel.Selectable;
import com.luyunfeng.selectionpanel.TestBean;

import java.util.List;

/**
 * Created by luyunfeng on 2016/12/8.
 */

public class SelectionAdapter extends BaseSelectionAdapter<TestBean> {

    public SelectionAdapter(List<TestBean> list) {
        super(list);
    }

    @Override
    protected void convert(BaseViewHolder holder, TestBean entity) {
        super.convert(holder, entity);
        holder.setText(R.id.cb_item, entity.text);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_simple_slection;
    }
}
