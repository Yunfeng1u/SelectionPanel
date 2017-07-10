package com.luyunfeng.selectionpanel.adapter;

import android.widget.CompoundButton;

import com.luyunfeng.selectionpanel.Selectable;

import java.util.List;

/**
 * Created by luyunfeng on 2016/12/8.
 *
 * Allow multiple selections, the first item act like "All" that will be selected
 * when no items are selected
 */
public class MultiSelectionAllAdapter<t extends Selectable> extends BaseSelectionAdapter<t> {

    public MultiSelectionAllAdapter(List<t> list) {
        super(list);
        if (selectedList.size() == 0) {
            selectedList.add(0);
            list.get(0).setChecked(true);
        }
    }

    @Override
    protected void convert(final BaseSelectionViewHolder holder, final t entity) {
        holder.cb_item.setText(entity.getText());
        holder.cb_item.setChecked(entity.isChecked());
        holder.cb_item.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (compoundButton.isPressed()) {
                    Integer position = holder.getAdapterPosition();
                    if (isChecked) {
                        if (position == 0) {
                            for (Integer index : selectedList) {
                                list.get(index).setChecked(false);
                                notifyItemChanged(index);
                            }
                            initSelectedList();
                        } else {
                            if (list.get(0).isChecked()) {
                                unCheck(0);
                                notifyItemChanged(0);
                            }
                        }
                        check(position);
                    } else {
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

    private void check(Integer position) {
        list.get(position).setChecked(true);
        selectedList.add(position);
    }

    private void unCheck(Integer position) {
        list.get(position).setChecked(false);
        selectedList.remove(position);
    }

    @Override
    protected void validateData() {

    }
}
