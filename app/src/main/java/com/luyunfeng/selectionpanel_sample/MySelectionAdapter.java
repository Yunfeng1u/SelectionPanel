package com.luyunfeng.selectionpanel_sample;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luyunfeng on 2016/12/8.
 */

public class MySelectionAdapter extends RecyclerView.Adapter<MySelectionAdapter.MyViewHolder> {

    private List<MyBean> list;
    private List<Integer> selectedList = new ArrayList<>();
    private MySelectionChangedListener<String> listener;
    private List<String> callBackList = new ArrayList<>();

    public MySelectionAdapter(List<MyBean> list) {
        this.list = list;
        selectedList.clear();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isSelected){
                selectedList.add(i);
            }
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_selection, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        MyBean entity = list.get(position);
        holder.cb_item.setText(entity.text);
        holder.cb_item.setChecked(entity.isSelected);
        holder.cb_item.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (compoundButton.isPressed()) {
                    Integer position = holder.getAdapterPosition();
                    if (isChecked) {
                        if (position == 0) {
                            selectedList.clear();
                            for (int i = 0; i < list.size(); i++) {
                                list.get(i).isSelected = true;
                                selectedList.add(i);
                            }
                            notifyDataSetChanged();
                        } else {
                            list.get(position).isSelected = true;
                            selectedList.add(position);
                            notifyItemChanged(position);
                        }
                    } else {
                        if (position == 0) {
                            selectedList.clear();
                            for (int i = 0; i < list.size(); i++) {
                                list.get(i).isSelected = false;
                            }
                            notifyDataSetChanged();
                        } else {
                            selectedList.remove((Integer) 0);
                            list.get(0).isSelected = false;
                            notifyItemChanged(0);
                            selectedList.remove(position);
                            list.get(position).isSelected = false;
                            notifyItemChanged(position);
                        }
                    }

                    if (listener != null){
                        callBackList.clear();
                        for (Integer integer : selectedList) {
                            callBackList.add(list.get(integer).text);
                        }
                        listener.onSelectionChanged(callBackList);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setListener(MySelectionChangedListener<String> listener) {
        this.listener = listener;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public CheckBox cb_item;

        public MyViewHolder(View view) {
            super(view);
            cb_item = (CheckBox) view.findViewById(R.id.cb_item);
        }

    }
}
