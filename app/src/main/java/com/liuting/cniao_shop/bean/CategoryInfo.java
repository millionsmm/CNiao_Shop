package com.liuting.cniao_shop.bean;

/**
 * Package:com.liuting.cniao_shop.bean
 * author:liuting
 * Date:2017/4/1
 * Desc:分类信息类
 */

public class CategoryInfo extends BaseInfo {
    private String name;//分类名称

    public CategoryInfo() {
    }

    public CategoryInfo(String name) {
        this.name = name;
    }

    public CategoryInfo(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
