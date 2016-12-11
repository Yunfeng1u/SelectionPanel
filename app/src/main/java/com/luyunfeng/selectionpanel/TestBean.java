package com.luyunfeng.selectionpanel;

import com.luyunfeng.selectionpanellibrary.Selectable;

public class TestBean implements Selectable {

    private boolean isSelected;

    public String text;

    TestBean(String text){
        this.text = text;
    }

    @Override
    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public void setSelect(boolean flag) {
        isSelected = flag;
    }
}
