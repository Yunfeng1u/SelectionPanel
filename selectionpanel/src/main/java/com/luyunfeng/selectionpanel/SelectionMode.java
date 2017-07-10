package com.luyunfeng.selectionpanel;

import android.support.annotation.IntDef;

/**
 * Created by luyunfeng on 16/12/12.
 */

@IntDef({SelectionMode.MULTIPLE, SelectionMode.SINGLE, SelectionMode.MULTIPLE_WITH_ALL})
public @interface SelectionMode {
    int SINGLE = 1;
    int MULTIPLE = 2;
    int MULTIPLE_WITH_ALL = 3;
}
