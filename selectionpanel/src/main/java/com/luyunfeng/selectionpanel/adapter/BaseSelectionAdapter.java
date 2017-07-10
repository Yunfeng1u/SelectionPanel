package com.luyunfeng.selectionpanel.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.luyunfeng.selectionpanel.OnSelectionChangedListener;
import com.luyunfeng.selectionpanel.R;
import com.luyunfeng.selectionpanel.Selectable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luyunfeng on 2016/12/8.
 * Handle base selection logic
 */
public abstract class BaseSelectionAdapter<t extends Selectable> extends RecyclerView.Adapter<BaseSelectionAdapter.BaseSelectionViewHolder> {

    protected List<t> list;

    /**
     * Store all items selected
     */
    protected List<Integer> selectedList = new ArrayList<>();

    protected OnSelectionChangedListener listener;


    public BaseSelectionAdapter(List<t> list) {
        this.list = list;
        validateData();
        initSelectedList();
    }

    @Override
    public BaseSelectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(), parent, false);
        return new BaseSelectionViewHolder(view);
    }


    @Override
    public void onBindViewHolder(BaseSelectionViewHolder holder, int position) {
        if (position < list.size()) {
            convert(holder, list.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected void initSelectedList(){
        selectedList.clear();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isChecked()){
                selectedList.add(i);
            }
        }
    }

    protected void sendChanges(){
        if (listener != null){
            listener.onSelectionChanged(selectedList);
        }
    }

    protected abstract void validateData();

    public void setOnSelectionChangedListener(OnSelectionChangedListener listener){
        this.listener = listener;
    }

    protected abstract void convert(BaseSelectionViewHolder holder, t entity);

    protected int getLayoutId() {
        return R.layout.item_simple_selection;
    }


    public static class BaseSelectionViewHolder extends RecyclerView.ViewHolder {

        public CheckBox cb_item;

        public BaseSelectionViewHolder(View view) {
            super(view);
            cb_item = (CheckBox) view.findViewById(R.id.cb_item);
        }
    }
}
