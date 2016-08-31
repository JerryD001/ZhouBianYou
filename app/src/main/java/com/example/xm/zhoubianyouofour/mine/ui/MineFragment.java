package com.example.xm.zhoubianyouofour.mine.ui;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.example.xm.zhoubianyouofour.R;
import com.example.xm.zhoubianyouofour.mine.adapter.MyRecyclerViewAdapter;
import com.example.xm.zhoubianyouofour.utils.other.RVDivider;
import com.example.xm.zhoubianyouofour.utils.other.customindicator.CircleIndicator;
import com.example.xm.zhoubianyouofour.utils.ui.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private CircleIndicator circleIndicator;
    private MyRecyclerViewAdapter adapter;
    private LinearLayoutManager manager;
    private List<String> mText;
    private Context context;


    private String[] text={" "," ","我的订单","抢购订单"," ","会员俱乐部","我的等级","我的评价","我的收藏","常用信息",
            "分享要出发给朋友","常用设置"," ","猜你喜欢"};

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        context = this.getContext();
        recyclerView = (RecyclerView) root.findViewById(R.id.mine_recyclerView);
        //circleIndicator = (CircleIndicator) root.findViewById(R.id.mine_indicator);

    }



    /**
     * 初始化数据
     */
    @Override
   protected void initData() {

        mText= new ArrayList<>();
        for(int i =0;i<text.length;i++){
            mText.add(text[i]);
        }
        adapter = new MyRecyclerViewAdapter(context,mText);
        recyclerView.setAdapter(adapter);
        /**
         * 设置recyclerview的布局管理器
         */
        manager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);

        /**
         * 设置分割线
         */
        recyclerView.addItemDecoration(new RVDivider(context,OrientationHelper.HORIZONTAL));

    }

    /**
     * 初始化事件
     */
    @Override
    protected void initEvents() {

    }



}
