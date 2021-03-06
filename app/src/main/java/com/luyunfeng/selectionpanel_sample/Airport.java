package com.luyunfeng.selectionpanel_sample;

import com.luyunfeng.selectionpanel.Selectable;

/**
 * Created by luyunfeng on 16/3/17.
 * Test entity
 */
public class Airport implements Selectable {

    private String text;

    private boolean enable;

    private boolean isChecked;

    public Airport(String text){
        setText(text);
    }

    @Override
    public boolean isChecked() {
        return isChecked;
    }

    @Override
    public void setChecked(boolean flag) {
        isChecked = flag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean isEnable() {
        return enable;
    }

    @Override
    public void setEnable(boolean isEnable) {
        this.enable = enable;
    }
}
