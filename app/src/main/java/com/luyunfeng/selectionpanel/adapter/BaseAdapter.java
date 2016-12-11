package com.luyunfeng.selectionpanel.adapter;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by luyunfeng on 16/8/4.
 */
public abstract class BaseAdapter<t> extends RecyclerView.Adapter<BaseViewHolder> {

    protected List<t> list;

    protected BaseAdapter(List<t> list) {
        this.list = list;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(), parent, false);
        return new BaseViewHolder(view);
    }

    protected abstract void convert(BaseViewHolder holder, t entity);

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (position < list.size()) {
            convert(holder, list.get(position));
        } else {
            convert(holder, null);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected abstract @LayoutRes int getLayoutId();
}
