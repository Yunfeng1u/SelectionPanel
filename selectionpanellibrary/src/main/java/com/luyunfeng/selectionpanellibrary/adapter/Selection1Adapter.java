package com.luyunfeng.selectionpanellibrary.adapter;

import android.widget.CompoundButton;

import com.luyunfeng.selectionpanellibrary.R;
import com.luyunfeng.selectionpanellibrary.Selectable;

import java.util.List;

/**
 * Created by luyunfeng on 2016/12/8.
 */

public abstract class Selection1Adapter<t extends Selectable> extends BaseSelectionAdapter<t> {

    public Selection1Adapter(List<t> list) {
        super(list);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final t entity) {
        holder.setChecked(R.id.cb_item, entity.isSelected())
                .setOnCheckedChangeListener(R.id.cb_item, new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (compoundButton.isPressed()) {
                            if (b){
                                if (selectedList.size() > 0){
                                    int index = selectedList.get(0);

                                    list.get(index).setSelect(false);
                                    notifyItemChanged(index);

                                    selectedList.remove(0);
                                }

                                entity.setSelect(true);
                                selectedList.add(holder.getAdapterPosition());

                                if (listener != null) {
                                    listener.onSelectionChanged(selectedList);
                                }

                            }else{
                                compoundButton.setChecked(true);
                            }
                        }
                    }
                });
    }

    @Override
    protected void checkDataLegal() {
        int selectedCount = 0;
        for (t t : list) {
            if (t.isSelected()){
                selectedCount++;
                if (selectedCount > 1){
                    throw new RuntimeException("SINGLE mode does not support multiple selection!");
                }
            }
        }
    }
}
