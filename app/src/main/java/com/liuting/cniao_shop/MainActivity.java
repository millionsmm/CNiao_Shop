package com.liuting.cniao_shop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.liuting.cniao_shop.bean.TabInfo;
import com.liuting.cniao_shop.fragment.CartFragment;
import com.liuting.cniao_shop.fragment.CategoryFragment;
import com.liuting.cniao_shop.fragment.HomeFragment;
import com.liuting.cniao_shop.fragment.HotFragment;
import com.liuting.cniao_shop.fragment.MineFragment;
import com.liuting.cniao_shop.widget.FragmentTabHost;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FragmentTabHost tabhost;//底部Tab
    private List<TabInfo> list;//tab列表
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTab();
    }

    /**
     * 初始化Tab
     */
    public void initTab(){
        tabhost=(FragmentTabHost)findViewById(android.R.id.tabhost);
        list = new ArrayList<>(5);
        inflater = LayoutInflater.from(this);

        TabInfo tab_home= new TabInfo(HomeFragment.class,R.string.home,R.drawable.selector_icon_home);
        TabInfo tab_hot= new TabInfo(HotFragment.class,R.string.hot,R.drawable.selector_icon_hot);
        TabInfo tab_category= new TabInfo(CategoryFragment.class,R.string.category,R.drawable.selector_icon_category);
        TabInfo tab_cart= new TabInfo(CartFragment.class,R.string.cart,R.drawable.selector_icon_cart);
        TabInfo tab_mine= new TabInfo(MineFragment.class,R.string.mine,R.drawable.selector_icon_mine);

        list.add(tab_home);
        list.add(tab_hot);
        list.add(tab_category);
        list.add(tab_cart);
        list.add(tab_mine);
        //必须在添加TabSpec之前调用
        tabhost.setup(this,getSupportFragmentManager(),R.id.main_frame_content);

        for (TabInfo tab : list){

            TabHost.TabSpec tabSpec = tabhost.newTabSpec(getString(tab.getTitle()));

            tabSpec.setIndicator(buildIndicator(tab));

            Bundle bundle = new Bundle();
            bundle.putString("title", getString(tab.getTitle()));
            tabhost.addTab(tabSpec,tab.getFragment(),bundle);

        }

        tabhost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        tabhost.setCurrentTab(0);
        tabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if(tabId.equals(getString(R.string.cart))){
                    Toast.makeText(MainActivity.this,getString(R.string.cart),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * 初始化Indicator
     *
     * @param tab tab实体类
     * @return
     */
    private View buildIndicator(TabInfo tab){

        View view =inflater.inflate(R.layout.tab_indicator,null);
        ImageView img = (ImageView) view.findViewById(R.id.tab_img_icon);
        TextView text = (TextView) view.findViewById(R.id.tab_tv_indicator);

        img.setBackgroundResource(tab.getIcon());
        text.setText(tab.getTitle());
        return  view;
    }
}
