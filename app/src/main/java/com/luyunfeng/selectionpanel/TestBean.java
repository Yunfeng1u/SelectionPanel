package com.luyunfeng.selectionpanel;

/**
 * 介绍：
 * 作者：zhangxutong
 * 邮箱：zhangxutong@imcoming.com
 * 时间： 2016/9/9.
 */
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
