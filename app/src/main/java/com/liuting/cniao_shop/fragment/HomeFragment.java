package com.liuting.cniao_shop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.liuting.cniao_shop.R;
import com.liuting.cniao_shop.bean.BannerInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Package:com.liuting.cniao_shop.fragment
 * author:liuting
 * Date:2017/3/14
 * Desc:主页
 * 总结：AndroidImageSlider具体用法请参照：https://github.com/daimajia/AndroidImageSlider
 */

public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    private View view;//view
    private TextView tvTitle;//标题
    private String mTitle;//标题
    private SliderLayout mSlider;//滚动布局
    private List<BannerInfo> listBanner;//滚动广告列表
    private PagerIndicator indicator;//自定义的indicator

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home_layout, container, false);
        initView();
        return view;
    }

    private void initView() {
        listBanner = new ArrayList<>();
        mTitle = (String) this.getArguments().getSerializable("title");
        tvTitle = (TextView) view.findViewById(R.id.home_tv_title);
        tvTitle.setText(mTitle);

        getBannerData();

        mSlider = (SliderLayout) view.findViewById(R.id.home_slider_ad);
        indicator =(PagerIndicator)view.findViewById(R.id.home_indicator_ad);
        initSlider();
    }

    /**
     * 初始化SliderLayout
     */
    private void initSlider() {
        if (listBanner != null) {
            for (BannerInfo bannerInfo : listBanner) {
                TextSliderView textSliderView = new TextSliderView(this.getActivity());
                textSliderView.image(bannerInfo.getImgUrl())
                        .description(bannerInfo.getName())
                        .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                        .setOnSliderClickListener(this);
                mSlider.addSlider(textSliderView);
            }
        }

        mSlider.setCustomIndicator(indicator);
        mSlider.setCustomAnimation(new DescriptionAnimation());
        mSlider.setPresetTransformer(SliderLayout.Transformer.RotateUp);
        mSlider.setDuration(3000);
        mSlider.addOnPageChangeListener(this);
    }

    /**
     * 获取滚动广告的数据信息
     */
    private void getBannerData() {
        BannerInfo bannerInfo_01 = new BannerInfo();
        bannerInfo_01.setName("音箱狂欢");
        bannerInfo_01.setImgUrl("http://7mno4h.com2.z0.glb.qiniucdn.com/5608f3b5Nc8d90151.jpg");
        BannerInfo bannerInfo_02 = new BannerInfo();
        bannerInfo_02.setName("手机国庆礼");
        bannerInfo_02.setImgUrl("http://7mno4h.com2.z0.glb.qiniucdn.com/5608eb8cN9b9a0a39.jpg");
        BannerInfo bannerInfo_03 = new BannerInfo();
        bannerInfo_03.setName("IT生活");
        bannerInfo_03.setImgUrl("http://7mno4h.com2.z0.glb.qiniucdn.com/5608cae6Nbb1a39f9.jpg");
        listBanner.add(bannerInfo_01);
        listBanner.add(bannerInfo_02);
        listBanner.add(bannerInfo_03);
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(getActivity(),slider.getDescription(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.e("TAG","pageScrolled");
    }

    @Override
    public void onPageSelected(int position) {
        Log.e("TAG","pageSelected");
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        Log.e("TAG","pageScrollStateChanged");
    }
}
