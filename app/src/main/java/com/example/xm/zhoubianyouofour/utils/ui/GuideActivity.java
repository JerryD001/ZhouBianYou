package com.example.xm.zhoubianyouofour.utils.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.xm.zhoubianyouofour.R;
import com.example.xm.zhoubianyouofour.utils.adapter.GuidePageAdapter;
import com.example.xm.zhoubianyouofour.utils.other.customindicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends BaseActivity {

    private CircleIndicator circleIndicator;
    private ViewPager viewPager;
    private Button button;
    private GuidePageAdapter adapter;
    private List<ImageView> list;
    private int[] imageRes = new int[]{R.drawable.guide_page_1,
            R.drawable.guide_page_2,
            R.drawable.guide_page_3,
            R.drawable.guide_page_4};// 轮播背景图


    @Override
    protected int getLayout() {
        return R.layout.activity_guide;
    }

    @Override
    protected void initView() {
        circleIndicator = (CircleIndicator) findViewById(R.id.indicator);//初始化自定义轻量级指示器
        viewPager = (ViewPager) findViewById(R.id.guide_viewpage);
        button = (Button) findViewById(R.id.from_guide_to_home);
    }

    @Override
    protected void initData() {
        getData();
        adapter = new GuidePageAdapter(list);
        viewPager.setAdapter(adapter);

        //给轮播设置指示器
        // Notice:the method should be called after ViewPager.setAdapter().
        circleIndicator.setViewPager(viewPager);
    }

    @Override
    protected void initEvents() {
        /**
         * viewPager翻页监听事件
         */
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == list.size() - 1) {
                    button.setVisibility(View.VISIBLE);
                } else {
                    button.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        /**
         * 跳转按钮点击事件
         */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("FLAG_ENTRY_TIMES", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean("FLAG_USED", false);
                editor.commit();
                startActivity(new Intent(GuideActivity.this, HomeActivity.class));
                finish();
            }
        });
    }

    /**
     * 初始化轮播图片数据
     */
    private void getData() {
        list = new ArrayList<>();
        ImageView imageView;
        for (int i = 0; i < imageRes.length; i++) {
            imageView = new ImageView(this);
            imageView.setImageResource(imageRes[i]);
            list.add(imageView);
        }
    }
}
