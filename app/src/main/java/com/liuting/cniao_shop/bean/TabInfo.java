package com.liuting.cniao_shop.bean;

import java.io.Serializable;

/**
 * Package:com.liuting.cniao_shop.bean
 * author:liuting
 * Date:2017/3/14
 * Desc:底部Tab实体类
 */

public class TabInfo  implements Serializable{
    private  int title;//标题
    private  int icon;//图标
    private Class fragment;//Fragment

    public TabInfo(Class fragment,int title, int icon) {
        this.title = title;
        this.icon = icon;
        this.fragment = fragment;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public Class getFragment() {
        return fragment;
    }

    public void setFragment(Class fragment) {
        this.fragment = fragment;
    }
}
