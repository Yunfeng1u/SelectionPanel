package com.luyunfeng.selectionpanel_sample;

import java.util.List;

/**
 * Created by luyunfeng on 17/7/10.
 */

interface MySelectionChangedListener<T> {
    void onSelectionChanged(List<T> list);
}
