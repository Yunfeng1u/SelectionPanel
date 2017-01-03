package com.luyunfeng.selectionpanellibrary;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by luyunfeng on 2016/12/18.
 */

public class ItemMarginDecoration extends RecyclerView.ItemDecoration {

    private int[] itemMargin = new int[4];

    public ItemMarginDecoration(int[] itemMargin) {
        this.itemMargin = itemMargin;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = itemMargin[0] / 2;
        outRect.top = itemMargin[1] / 2;
        outRect.right = itemMargin[2] / 2;
        outRect.bottom = itemMargin[3] /2;
    }
}
