package com.luyunfeng.selectionpanel.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;

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

    private int itemLayoutID = R.layout.item_simple_selection;
    private int itemID = R.id.cb_item;

    public BaseSelectionAdapter(List<t> list) {
        this.list = list;
        validateData();
        initSelectedList();
    }

    public void setItemLayoutID(int itemLayoutID, int itemID) {
        this.itemLayoutID = itemLayoutID;
        this.itemID = itemID;
    }

    public void setItemLayoutID(int itemLayoutID) {
        this.itemLayoutID = itemLayoutID;
    }

    @Override
    public BaseSelectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayoutID, parent, false);
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

    protected void initSelectedList() {
        selectedList.clear();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isChecked()) {
                selectedList.add(i);
            }
        }
    }

    protected void sendChanges() {
        if (listener != null) {
            listener.onSelectionChanged(selectedList);
        }
    }


    public void setOnSelectionChangedListener(OnSelectionChangedListener listener) {
        this.listener = listener;
    }

    protected abstract void validateData();

    protected abstract void convert(BaseSelectionViewHolder holder, t entity);

    public class BaseSelectionViewHolder extends RecyclerView.ViewHolder {

        public Checkable cb_item;

        public BaseSelectionViewHolder(View view) {
            super(view);
            cb_item = (Checkable) view.findViewById(itemID);
        }
    }
}
