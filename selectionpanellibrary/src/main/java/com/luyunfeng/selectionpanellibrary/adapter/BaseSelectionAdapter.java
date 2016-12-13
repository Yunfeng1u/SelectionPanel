package com.luyunfeng.selectionpanellibrary.adapter;

import com.luyunfeng.selectionpanellibrary.OnSelectionChangedListener;
import com.luyunfeng.selectionpanellibrary.R;
import com.luyunfeng.selectionpanellibrary.Selectable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luyunfeng on 2016/12/8.
 */

public abstract class BaseSelectionAdapter<t extends Selectable> extends BaseAdapter<t> {

    protected OnSelectionChangedListener listener;

    public void setOnSelectionChangedListener(OnSelectionChangedListener listener){
        this.listener = listener;
    }

    protected List<Integer> selectedList = new ArrayList<>();

    public BaseSelectionAdapter(List<t> list) {
        super(list);
        checkDataLegal();
        initSelectedList();
    }

    protected void initSelectedList(){
        selectedList.clear();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected()){
                selectedList.add(i);
            }
        }
    }

    protected void sendChanges(){
        if (listener != null){
            listener.onSelectionChanged(selectedList);
        }
    }

    protected abstract void checkDataLegal();

    @Override
    protected int getLayoutId() {
        return R.layout.item_simple_selection;
    }
}
