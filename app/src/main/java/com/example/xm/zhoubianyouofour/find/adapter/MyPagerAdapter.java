package com.example.xm.zhoubianyouofour.find.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class MyPagerAdapter extends PagerAdapter {
   private List<View> list;

    public MyPagerAdapter(List<View> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(View view, int position) {
       ((ViewPager)view).addView(list.get(position),0);
        return list.get(position);
    }

    @Override
    public void destroyItem(View view, int position, Object object) {
        ((ViewPager)view).removeView(list.get(position));
    }
}
