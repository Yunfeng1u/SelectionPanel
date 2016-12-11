package com.luyunfeng.selectionpanellibrary.adapter;

import android.widget.CompoundButton;


import com.luyunfeng.selectionpanellibrary.OnSelectionChangedListener;
import com.luyunfeng.selectionpanellibrary.R;
import com.luyunfeng.selectionpanellibrary.Selectable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luyunfeng on 2016/12/8.
 */

public abstract class BaseSelectionAdapter<t extends Selectable> extends BaseAdapter<t> {

    private OnSelectionChangedListener listener;

    private List<Integer> selectedList = new ArrayList<>();

    public void setOnSelectionChangedListener(OnSelectionChangedListener listener){
        this.listener = listener;
    }

    public BaseSelectionAdapter(List<t> list) {
        super(list);
        constructSelectedList();
    }

    @Override
    protected void convert(BaseViewHolder holder, final t entity) {
        holder.setChecked(R.id.cb_item, entity.isSelected())
        .setOnCheckedChangeListener(R.id.cb_item, new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isPressed()){
                    entity.setSelect(b);
                    if (listener != null){
                        constructSelectedList();
                        listener.onSelectionChanged(selectedList);
                    }
                }
            }
        });
    }

    private void constructSelectedList(){
        selectedList.clear();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected()){
                selectedList.add(i);
            }
        }
    }
}
