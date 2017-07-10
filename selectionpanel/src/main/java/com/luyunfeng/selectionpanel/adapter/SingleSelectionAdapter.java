package com.luyunfeng.selectionpanel.adapter;

import android.widget.CompoundButton;

import com.luyunfeng.selectionpanel.Selectable;

import java.util.List;

/**
 * Created by luyunfeng on 2016/12/8.
 * Radio group
 */
public class SingleSelectionAdapter<t extends Selectable> extends BaseSelectionAdapter<t> {

    public SingleSelectionAdapter(List<t> list) {
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
                    if (b) {
                        if (selectedList.size() > 0) {
                            int index = selectedList.get(0);

                            list.get(index).setChecked(false);
                            notifyItemChanged(index);

                            selectedList.remove(0);
                        }

                        entity.setChecked(true);
                        selectedList.add(holder.getAdapterPosition());

                        sendChanges();

                    } else {
                        compoundButton.setChecked(true);
                    }
                }
            }
        });
    }

    @Override
    protected void validateData() {
        int selectedCount = 0;
        for (t t : list) {
            if (t.isChecked()) {
                selectedCount++;
                if (selectedCount > 1) {
                    throw new RuntimeException("Single mode does not support multiple selection!");
                }
            }
        }
    }
}
