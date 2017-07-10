package com.luyunfeng.selectionpanel.adapter;

import android.widget.CompoundButton;

import com.luyunfeng.selectionpanel.Selectable;

import java.util.List;

/**
 * Created by luyunfeng on 2016/12/8.
 * Allow multiple selections
 */
public class MultiSelectionAdapter<t extends Selectable> extends BaseSelectionAdapter<t> {

    public MultiSelectionAdapter(List<t> list) {
        super(list);
    }

    @Override
    protected void convert(final BaseSelectionViewHolder holder, final t entity) {
        holder.cb_item.setText(entity.getText());
        holder.cb_item.setChecked(entity.isChecked());
        holder.cb_item.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isPressed()) {
                    Integer position = holder.getAdapterPosition();
                    if (b) {
                        entity.setChecked(true);
                        selectedList.add(position);
                    } else {
                        entity.setChecked(false);
                        selectedList.remove(position);
                    }
                    sendChanges();
                }
            }
        });
    }

    @Override
    protected void validateData() {

    }
}
