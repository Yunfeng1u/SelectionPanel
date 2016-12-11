package com.luyunfeng.selectionpanel;

import com.luyunfeng.selectionpanellibrary.Selectable;

/**
 * Created by luyunfeng on 16/3/17.
 */
public class Airport implements Selectable{

    private String name;

    private boolean isSelected;

    public Airport(String name){
        this.name = name;
    }

    @Override
    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public void setSelect(boolean flag) {
        isSelected = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
