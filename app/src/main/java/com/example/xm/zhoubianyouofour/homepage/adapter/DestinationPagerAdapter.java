package com.example.xm.zhoubianyouofour.homepage.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.xm.zhoubianyouofour.homepage.entity.DestinationBean;
import com.example.xm.zhoubianyouofour.homepage.ui.DestinationFragment;

import java.util.List;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class DestinationPagerAdapter extends FragmentStatePagerAdapter {
    List<DestinationFragment> list;

    public void setList(List<DestinationFragment> list) {
        this.list = list;
    }

    public DestinationPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
