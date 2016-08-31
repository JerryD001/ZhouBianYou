package com.example.xm.zhoubianyouofour.mine.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.xm.zhoubianyouofour.utils.ui.BaseFragment;

import java.util.List;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class MyTabPagerAdapter extends FragmentStatePagerAdapter {
    private List<BaseFragment> fragmentList;
    private List<String> mTitles;

    public MyTabPagerAdapter(FragmentManager fm, List<BaseFragment> fragmentList,List<String> mTitles) {
        super(fm);
        this.fragmentList=fragmentList;
        this.mTitles=mTitles;
    }

    @Override
    public Fragment getItem(int position) {

        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    /**
     * ViewPager 和 Tab页中标题绑定
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
