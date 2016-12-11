package com.luyunfeng.selectionpanellibrary.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.View;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

/**
 * Created by luyunfeng on 16/8/3.
 */

public class BaseViewHolder extends ViewHolder {
    private final SparseArray<View> viewPool = new SparseArray<>();
    private View convertView;

    public BaseViewHolder(View view) {
        super(view);
        this.convertView = view;
    }

    public BaseViewHolder setText(int viewId, CharSequence value) {
        TextView view = this.getView(viewId);
        if (view != null){
            view.setText(value);
        }
        return this;
    }

    public BaseViewHolder setVisibility(int viewId, int visibility) {
        View view = this.getView(viewId);
        if(view != null && view.getVisibility() != visibility){
            view.setVisibility(visibility);
        }
        return this;
    }

    public BaseViewHolder setOnCheckedChangeListener(int viewId, OnCheckedChangeListener listener) {
        CompoundButton view = this.getView(viewId);
        view.setOnCheckedChangeListener(listener);
        return this;
    }

    public BaseViewHolder setChecked(int viewId, boolean checked) {
        View view = this.getView(viewId);
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(checked);
        }
        return this;
    }

    public <T extends View> T getView(int viewId) {
        View view = this.viewPool.get(viewId);
        if (view == null) {
            view = this.convertView.findViewById(viewId);
            this.viewPool.put(viewId, view);
        }
        return (T) view;
    }
}
