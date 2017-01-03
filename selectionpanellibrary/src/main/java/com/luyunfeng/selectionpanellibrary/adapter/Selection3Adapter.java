package com.luyunfeng.selectionpanellibrary.adapter;

import android.util.Log;
import android.widget.CompoundButton;

import com.luyunfeng.selectionpanellibrary.R;
import com.luyunfeng.selectionpanellibrary.Selectable;

import java.util.List;

/**
 * Created by luyunfeng on 2016/12/8.
 */

public abstract class Selection3Adapter<t extends Selectable> extends BaseSelectionAdapter<t> {

    public Selection3Adapter(List<t> list) {
        super(list);
        if (selectedList.size() == 0){
            selectedList.add(0);
            list.get(0).setSelect(true);
        }
    }

    @Override
    protected void convert(final BaseViewHolder holder, final t entity) {
        holder.setChecked(R.id.cb_item, entity.isSelected())
                .setOnCheckedChangeListener(R.id.cb_item, new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if (compoundButton.isPressed()) {
                            Integer position = holder.getAdapterPosition();
                            if (isChecked) {
                                if (position == 0) {
                                    for (Integer index : selectedList) {
                                        list.get(index).setSelect(false);
                                        notifyItemChanged(index);
                                    }
                                    initSelectedList();
                                } else {
                                    if (list.get(0).isSelected()) {
                                        unCheck(0);
                                        notifyItemChanged(0);
                                    }
                                }
                                check(position);
                            }else {
                                if (position == 0) {
                                    compoundButton.setChecked(true);
                                } else {
                                    unCheck(position);
                                    if (selectedList.size() == 0) {
                                        check(0);
                                        notifyItemChanged(0);
                                    }
                                }
                            }
                            sendChanges();
                        }
                    }
                });
    }

    private void check(Integer position){
        list.get(position).setSelect(true);
        selectedList.add(position);
    }

    private void unCheck(Integer position){
        list.get(position).setSelect(false);
        selectedList.remove(position);
    }

    @Override
    protected void checkDataLegal() {

    }
}
