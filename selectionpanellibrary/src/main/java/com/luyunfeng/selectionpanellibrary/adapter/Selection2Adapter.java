package com.luyunfeng.selectionpanellibrary.adapter;

import android.widget.CompoundButton;

import com.luyunfeng.selectionpanellibrary.R;
import com.luyunfeng.selectionpanellibrary.Selectable;

import java.util.List;

/**
 * Created by luyunfeng on 2016/12/8.
 */

public abstract class Selection2Adapter<t extends Selectable> extends BaseSelectionAdapter<t> {

    public Selection2Adapter(List<t> list) {
        super(list);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final t entity) {
        holder.setChecked(R.id.cb_item, entity.isSelected())
                .setOnCheckedChangeListener(R.id.cb_item, new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (compoundButton.isPressed()){
                            Integer position = holder.getAdapterPosition();
                            if (b){
                                entity.setSelect(true);
                                selectedList.add(position);
                            }else{
                                entity.setSelect(false);
                                selectedList.remove(position);
                            }
                            sendChanges();
                        }
                    }
                });
    }

    @Override
    protected void checkDataLegal() {

    }
}
