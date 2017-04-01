package com.liuting.cniao_shop.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuting.cniao_shop.R;
import com.liuting.cniao_shop.bean.HomeCategoryInfo;

import java.util.List;

/**
 * Package:com.liuting.cniao_shop.adapter
 * author:liuting
 * Date:2017/4/1
 * Desc:商品分类Adapter
 */

public class HomeCategoryAdapter extends RecyclerView.Adapter<HomeCategoryAdapter.ViewHolder> {

    private  static int VIEW_TYPE_L=0;
    private  static int VIEW_TYPE_R=1;

    private LayoutInflater mInflater;

    private List<HomeCategoryInfo> mDatas;

    public HomeCategoryAdapter(List<HomeCategoryInfo> datas){
        mDatas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int type) {
        mInflater = LayoutInflater.from(viewGroup.getContext());
        if(type == VIEW_TYPE_R){

            return  new ViewHolder(mInflater.inflate(R.layout.recycler_item_even_layout,viewGroup,false));
        }

        return  new ViewHolder(mInflater.inflate(R.layout.recycler_item_odd_layout,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        HomeCategoryInfo category = mDatas.get(i);
        viewHolder.textTitle.setText(category.getName());
        viewHolder.imageViewBig.setImageResource(category.getImgBig());
        viewHolder.imageViewSmallTop.setImageResource(category.getImgSmallTop());
        viewHolder.imageViewSmallBottom.setImageResource(category.getImgSmallBottom());

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    @Override
    public int getItemViewType(int position) {

        if(position % 2==0){
            return  VIEW_TYPE_R;
        }
        else return VIEW_TYPE_L;


    }

    static  class ViewHolder extends RecyclerView.ViewHolder{


        TextView textTitle;
        ImageView imageViewBig;
        ImageView imageViewSmallTop;
        ImageView imageViewSmallBottom;

        public ViewHolder(View itemView) {
            super(itemView);


            textTitle = (TextView) itemView.findViewById(R.id.category_tv_title);
            imageViewBig = (ImageView) itemView.findViewById(R.id.category_img_big);
            imageViewSmallTop = (ImageView) itemView.findViewById(R.id.category_img_top);
            imageViewSmallBottom = (ImageView) itemView.findViewById(R.id.category_img_bottom);
        }

    }
}
