package com.luyunfeng.selectionpanellibrary;

import android.support.annotation.IntDef;

/**
 * Created by luyunfeng on 16/12/12.
 */

@IntDef({SelectionMode.MULTIPLE, SelectionMode.SINGLE, SelectionMode.MULTIPLE_WITH_ALL, SelectionMode.SINGLE_WITH_ALL})
public @interface SelectionMode {
    int SINGLE = 1;
    int MULTIPLE = 2;
    int SINGLE_WITH_ALL = 3;
    int MULTIPLE_WITH_ALL = 4;
}
