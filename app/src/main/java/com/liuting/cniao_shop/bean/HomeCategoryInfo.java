package com.liuting.cniao_shop.bean;

/**
 * Package:com.liuting.cniao_shop.bean
 * author:liuting
 * Date:2017/4/1
 * Desc:商品分类信息类
 */

public class HomeCategoryInfo extends CategoryInfo {
    private int imgBig;//大图
    private int imgSmallTop;//上面的小图
    private int imgSmallBottom;//下面的小图

    public HomeCategoryInfo(String name, int imgBig, int imgSmallTop, int imgSmallBottom) {
        super(name);
        this.imgBig = imgBig;
        this.imgSmallTop = imgSmallTop;
        this.imgSmallBottom = imgSmallBottom;
    }

    public int getImgBig() {
        return imgBig;
    }

    public void setImgBig(int imgBig) {
        this.imgBig = imgBig;
    }

    public int getImgSmallTop() {
        return imgSmallTop;
    }

    public void setImgSmallTop(int imgSmallTop) {
        this.imgSmallTop = imgSmallTop;
    }

    public int getImgSmallBottom() {
        return imgSmallBottom;
    }

    public void setImgSmallBottom(int imgSmallBottom) {
        this.imgSmallBottom = imgSmallBottom;
    }
}
