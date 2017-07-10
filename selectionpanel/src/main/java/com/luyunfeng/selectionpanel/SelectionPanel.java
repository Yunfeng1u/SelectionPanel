package com.luyunfeng.selectionpanel;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;

/**
 * Created by luyunfeng on 2016/12/18.
 */

public class SelectionPanel extends RelativeLayout {

    private RecyclerView.Adapter adapter;
    private int[] itemMargin;

    public SelectionPanel(Context context) {
        this(context, null);
    }

    public SelectionPanel(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_selection_panel, this, true);
    }

    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.adapter = adapter;
        setList();
        setEvent();
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

        FlexboxLayoutManager manager = new FlexboxLayoutManager(getContext());
        manager.setFlexDirection(FlexDirection.ROW);
        manager.setFlexWrap(FlexWrap.WRAP);
        manager.setAlignItems(AlignItems.FLEX_START);

        RecyclerView rv_selection = (RecyclerView) findViewById(R.id.rv_selection);
        rv_selection.setLayoutManager(manager);
        rv_selection.setAdapter(adapter);
        if (itemMargin != null) {
            if (rv_selection.getTag() == null){
                rv_selection.addItemDecoration(new ItemMarginDecoration(itemMargin));
                rv_selection.setTag("Decoration");
            }
        }
    }

    public void setItemMargin(int itemMarginLeft, int itemMarginTop, int itemMarginRight, int itemMarginBottom) {
        this.itemMargin = new int[]{itemMarginLeft, itemMarginTop, itemMarginRight, itemMarginBottom};
    }
}
