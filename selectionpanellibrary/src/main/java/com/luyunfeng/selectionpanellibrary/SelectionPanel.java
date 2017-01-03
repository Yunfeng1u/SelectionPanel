package com.luyunfeng.selectionpanellibrary;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.beloo.widget.chipslayoutmanager.ChipsLayoutManager;
import com.beloo.widget.chipslayoutmanager.SpacingItemDecoration;
import com.beloo.widget.chipslayoutmanager.gravity.IChildGravityResolver;
import com.beloo.widget.chipslayoutmanager.layouter.breaker.IRowBreaker;
import com.luyunfeng.selectionpanellibrary.adapter.BaseSelectionAdapter;

/**
 * Created by luyunfeng on 2016/12/18.
 */

public class SelectionPanel extends RelativeLayout {

    private @SelectionMode int selectionMode = SelectionMode.SINGLE;
    private BaseSelectionAdapter adapter;
    private OnSelectionChangedListener listener;
    private int[] itemMargin;

    public SelectionPanel(Context context) {
        this(context, null);
    }

    public SelectionPanel(Context context, AttributeSet attrs) {
        super(context, attrs);

        // TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SelectionPanel);
        //Drawable outerBackground = ta.getDrawable(R.styleable.HotelArrangementView_outer_background);
        //Drawable dateBackground = ta.getDrawable(R.styleable.HotelArrangementView_date_background);

        LayoutInflater.from(context).inflate(R.layout.layout_selection_panel, this, true);

        // ta.recycle();
    }

    public int getSelectionMode() {
        return selectionMode;
    }

    public void setSelectionMode(int selectionMode) {
        this.selectionMode = selectionMode;
    }

    public BaseSelectionAdapter getAdapter() {
        return adapter;
    }

    public SelectionPanel setAdapter(BaseSelectionAdapter adapter) {
        this.adapter = adapter;
        return this;
    }

    public void build(){
        if (adapter != null) {
            adapter.setOnSelectionChangedListener(listener);
            setList();
            setEvent();
        }
    }

    private void setEvent() {
        final View toggle = findViewById(R.id.tb_more);
        toggle.setTag(true);
        toggle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isBrief= (boolean) toggle.getTag();
                if (isBrief){
                    ObjectAnimator.ofFloat(view, "rotation", 0, 180).setDuration(200).start();
                }else{
                    ObjectAnimator.ofFloat(view, "rotation", 180, 0).setDuration(200).start();
                }
                toggle.setTag(!isBrief);
            }
        });
    }

    private void setList() {
        ChipsLayoutManager chipsLayoutManager
                = ChipsLayoutManager.newBuilder(getContext())
                .setScrollingEnabled(true)
                .build();
        RecyclerView rv_selection = (RecyclerView) findViewById(R.id.rv_selection);
        rv_selection.setLayoutManager(chipsLayoutManager);
        rv_selection.setAdapter(adapter);
        if (itemMargin != null)
            rv_selection.addItemDecoration(new ItemMarginDecoration(itemMargin));
    }

    public SelectionPanel setOnSelectionChangedListener(OnSelectionChangedListener listener) {
        this.listener = listener;
        return this;
    }

    public SelectionPanel setItemMargin(int itemMarginLeft, int itemMarginTop, int itemMarginRight, int itemMarginBottom) {
        this.itemMargin = new int[]{itemMarginLeft, itemMarginTop, itemMarginRight, itemMarginBottom};
        return this;
    }
}
