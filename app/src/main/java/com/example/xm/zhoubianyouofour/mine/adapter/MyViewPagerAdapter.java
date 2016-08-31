package com.example.xm.zhoubianyouofour.mine.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.xm.zhoubianyouofour.R;

import java.util.List;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public class MyViewPagerAdapter extends PagerAdapter {

    private int[] mPics = {R.drawable.pic2, R.drawable.pic3, R.drawable.pic5, R.drawable.pic6, R.drawable.seven,
            R.drawable.ninejpg, R.drawable.six, R.drawable.three};
    private String[] mPrice = {"￥380起", "￥780起", "￥1080起", "￥650起", "￥1500起", "￥980起", "￥670起", "￥550起"};

    private List<View> views;

    public void setViews(List<View> views) {
        this.views = views;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(View view, int position, Object object) {
        ((ViewPager) view).removeView(views.get(position));
    }

    @Override
    public Object instantiateItem(View view, int position) {
        ((ViewPager) view).addView(views.get(position), 0);
        return views.get(position);
    }
}
