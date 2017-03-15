package com.liuting.cniao_shop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liuting.cniao_shop.R;

/**
 * Package:com.liuting.cniao_shop.fragment
 * author:liuting
 * Date:2017/3/14
 * Desc:我的
 */

public class MineFragment extends Fragment {
    private View view;//view
    private TextView tvTitle;//标题
    private String mTitle;//标题

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_home_layout,container,false);
        initView();
        return view;
    }

    private void initView() {
        mTitle=this.getArguments().getString("title");
        tvTitle =(TextView) view.findViewById(R.id.home_tv_title);
        tvTitle.setText(mTitle);
    }
}
