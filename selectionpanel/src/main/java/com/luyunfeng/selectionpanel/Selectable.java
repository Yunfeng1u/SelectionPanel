package com.luyunfeng.selectionpanel;

/**
 * Created by luyunfeng on 2016/12/8.
 */

public interface Selectable {
    boolean isChecked();
    void setChecked(boolean check);

    String getText();
    void setText(String text);

    String getParam();
    void setParam(String text);

    boolean isEnable();
    void setEnable(boolean isEnable);
}
