package com.example.xm.zhoubianyouofour.mine.ui;

import android.os.Bundle;

import com.example.xm.zhoubianyouofour.R;
import com.example.xm.zhoubianyouofour.utils.ui.BaseFragment;

/**
 * Created by Administrator on 2016/6/28 0028.
 */
public class MineBottomFragment extends BaseFragment {

    private static final String KEY = "EXTRA";
    private int pager;

    //private int[] mPics={R.drawable.pic2,R.drawable.pic3,R.drawable.pic5,R.drawable.pic6,R.drawable.seven,
        //    R.drawable.ninejpg,R.drawable.six,R.drawable.three};
   // private String [] mPrice={"￥380起","￥780起","￥1080起","￥650起","￥1500起","￥980起","￥670起","￥550起"};

    @Override
    protected int getLayout() {
        return R.layout.mine_viewpager_items_layout;
    }

    @Override
    protected void initView() {
        Bundle bundle = getArguments();
        if(bundle!=null){
            pager= (int) bundle.getSerializable(KEY);
        }
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initEvents() {
    }

    /**
     * 用于新建category对应的fragment实例，实现fragment复用
     * @param position
     * @return
     */
    public static final MineBottomFragment newInstance(int position){

        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY, position);
        MineBottomFragment fragment = new MineBottomFragment();
        fragment.setArguments(bundle);
        return fragment;

    }
}
