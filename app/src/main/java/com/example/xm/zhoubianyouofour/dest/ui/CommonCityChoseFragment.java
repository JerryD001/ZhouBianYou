package com.example.xm.zhoubianyouofour.dest.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.xm.zhoubianyouofour.R;
import com.example.xm.zhoubianyouofour.dest.Contants_dest;
import com.example.xm.zhoubianyouofour.dest.adapter.CommonCityRecyclerViewAdapter;
import com.example.xm.zhoubianyouofour.dest.entity.CommonCityContentBean;
import com.example.xm.zhoubianyouofour.dest.entity.CityTitleBean;
import com.example.xm.zhoubianyouofour.utils.other.LogUtil;
import com.example.xm.zhoubianyouofour.utils.other.OkHttpUtils;
import com.example.xm.zhoubianyouofour.utils.ui.BaseFragment;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommonCityChoseFragment extends BaseFragment {

    //private static CommonCityChoseFragment instance;
    private Bundle bundle;
    private CityTitleBean.ContentBean conBean;
    private List<CommonCityContentBean.ContentBean.HotScenicBean> hsbList;
    private List<CommonCityContentBean.ContentBean.HotCityBean> hcbList;

    private RecyclerView recyclerView;
    private CommonCityRecyclerViewAdapter adapter;
    private GridLayoutManager manager;

    @Override
    protected int getLayout() {
        return R.layout.dest_fragment_city_choosed;
    }

    @Override
    protected void initView() {
        recyclerView = (RecyclerView) root.findViewById(R.id.dest_recyclerview_common);
    }

    @Override
    protected void initData() {
        manager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new CommonCityRecyclerViewAdapter(getContext());
        bundle = getArguments();
        if (bundle != null) {
            if (bundle.containsKey(Contants_dest.CITY_LIST_KEY)) {
                conBean = (CityTitleBean.ContentBean) bundle.getSerializable(Contants_dest.CITY_LIST_KEY);
                adapter.setContentBean(conBean);
                String tempUrl;
                if (conBean.getListType().equals("around")) {// 周边这一条无数据
                    return;
                }
                tempUrl = Contants_dest.CONRENT_URL + "areaCode=" + conBean.getAreaCode() + "&listType=" + conBean.getListType();
                LogUtil.e("===========", "commonCityUrl: " + tempUrl);
                getHttpDate(tempUrl);
            }
        }
    }

    private void getHttpDate(String tempUrl) {
        OkHttpUtils.getAsync(tempUrl, new OkHttpUtils.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {
                Toast.makeText(getActivity(), "网络连接失败", Toast.LENGTH_SHORT).show();
                LogUtil.e("===========", "网络连接失败");
            }

            @Override
            public void requestSuccess(String result) {
                CommonCityContentBean cityContentBean = CommonCityContentBean.objectFromData(result);
                hsbList = cityContentBean.getContent().getHotScenic();
                adapter.setHsbList(hsbList);
                hcbList = cityContentBean.getContent().getHotCity();
                adapter.setHcbList(hcbList);
                LogUtil.e("=========common==", "hsbList:  " + hsbList.size() + "   hcbList:  " + hcbList.size());

                recyclerView.setAdapter(adapter);
            }
        });
    }

    @Override
    protected void initEvents() {
        adapter.setOnRecyclerViewItemClickListener(new CommonCityRecyclerViewAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(CommonCityContentBean.ContentBean.HotScenicBean hotScenicBean, int position) {
                // TODO: 2016/7/3 点击跳转到详情页面 
                Toast.makeText(getActivity(), "ScenicId: " + hotScenicBean.getScenicId() + "  position" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * 用于新建CategoryBean对应的Fragment实例，实现Fragment的复用
     *
     * @return
     */
    public static final CommonCityChoseFragment newInstance(CityTitleBean.ContentBean contentBean) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(Contants_dest.CITY_LIST_KEY, contentBean);
        CommonCityChoseFragment fragment = new CommonCityChoseFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    /**
     * 单例模式获取Fragment
     *
     * @return
     *//*
    public static CommonCityChoseFragment getInstance() {
        if (instance == null) {
            synchronized (HotCityChoseFragment.class) {
                if (instance == null) {
                    return new CommonCityChoseFragment();
                } else {
                    return instance;
                }
            }
        } else {
            return instance;
        }
    }*/

}

