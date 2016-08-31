package com.example.xm.zhoubianyouofour.dest.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.xm.zhoubianyouofour.utils.ui.BaseFragment;

import java.util.List;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public class DestFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

    private List<BaseFragment> fragmentList;
    private List<String> titleList;

    public DestFragmentStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setFragmentList(List<BaseFragment> fragmentList) {
        this.fragmentList = fragmentList;
    }

    public void setTitleList(List<String> titleList) {
        this.titleList = titleList;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
        /*if (position == 0) {
            return HotCityChoseFragment.getInstance();
        } else {
            return CommonCityChoseFragment.getInstance();
        }*/
    }

    @Override
    public int getCount() {
        return titleList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
