package com.liuting.cniao_shop.bean;

import java.io.Serializable;

/**
 * Package:com.liuting.cniao_shop.bean
 * author:liuting
 * Date:2017/4/1
 * Desc:基本信息类
 */

public class BaseInfo implements Serializable {
    protected long id;//id

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
