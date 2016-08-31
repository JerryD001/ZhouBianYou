package com.example.xm.zhoubianyouofour.dest.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.xm.zhoubianyouofour.R;
import com.example.xm.zhoubianyouofour.dest.Contants_dest;
import com.example.xm.zhoubianyouofour.dest.adapter.HotCityRecyclerViewAdapter;
import com.example.xm.zhoubianyouofour.dest.entity.CityTitleBean;
import com.example.xm.zhoubianyouofour.dest.entity.HotCityContentBean;
import com.example.xm.zhoubianyouofour.utils.other.LogUtil;
import com.example.xm.zhoubianyouofour.utils.other.OkHttpUtils;
import com.example.xm.zhoubianyouofour.utils.ui.BaseFragment;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotCityChoseFragment extends BaseFragment {

    //private static HotCityChoseFragment instance;
    private Bundle bundle;
    private CityTitleBean.ContentBean conBean;

    private RecyclerView recyclerView;
    private HotCityRecyclerViewAdapter adapter;
    private GridLayoutManager manager;

    @Override
    protected int getLayout() {
        return R.layout.dest_fragment_hot_city_chose;
    }

    @Override
    protected void initView() {
        recyclerView = (RecyclerView) root.findViewById(R.id.dest_recyclerview_hot);

    }

    @Override
    protected void initData() {
        manager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new HotCityRecyclerViewAdapter(getContext());

        bundle = getArguments();
        if (bundle != null) {
            if (bundle.containsKey(Contants_dest.CITY_LIST_KEY)) {
                conBean = (CityTitleBean.ContentBean) bundle.getSerializable(Contants_dest.CITY_LIST_KEY);

                String tempUrl = Contants_dest.CONRENT_URL + "areaCode=" + conBean.getAreaCode() + "&listType=" + conBean.getListType();
                LogUtil.e("===========", "hotCityUrl: " + tempUrl);
                OkHttpUtils.getAsync(tempUrl, new OkHttpUtils.DataCallBack() {
                    @Override
                    public void requestFailure(Request request, IOException e) {
                        Toast.makeText(getActivity(), "网络连接失败", Toast.LENGTH_SHORT).show();
                        LogUtil.e("===========", "网络连接失败");
                    }

                    @Override
                    public void requestSuccess(String result) {
                        HotCityContentBean hotContentBean = HotCityContentBean.objectFromData(result);
                        List<HotCityContentBean.ContentBean.HotScenicBean> hsbList = hotContentBean.getContent().getHotScenic();
                        adapter.setHsbList(hsbList);
                        List<HotCityContentBean.ContentBean.HotCityBean> hcbList = hotContentBean.getContent().getHotCity();
                        adapter.setHcbList(hcbList);
                        LogUtil.e("===========hot==", "hsbList:  " + hsbList.size() + "   hcbList:  " + hcbList.size());

                        recyclerView.setAdapter(adapter);
                    }
                });

            }
        }
    }

    @Override
    protected void initEvents() {
        adapter.setOnRecyclerViewItemClickListener(new HotCityRecyclerViewAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onHotScenicItemClick(HotCityContentBean.ContentBean.HotScenicBean hotScenicBean, int position) {
                Toast.makeText(getActivity(), hotScenicBean.getScenicName() + " position:" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onHotCityItemClick(HotCityContentBean.ContentBean.HotCityBean hotCityBean, int position) {
                Toast.makeText(getActivity(), hotCityBean.getCityName() + " position:" + position, Toast.LENGTH_SHORT).show();

            }
        });
    }


    /**
     * 用于给外界新建CityTitleBean对应的Fragment实例，实现Fragment的复用
     *
     * @return
     */
    public static final HotCityChoseFragment newInstance(CityTitleBean.ContentBean contentBean) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(Contants_dest.CITY_LIST_KEY, contentBean);
        HotCityChoseFragment fragment = new HotCityChoseFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    /**
     * 单例模式获取Fragment
     *
     * @return
     *//*
    public static HotCityChoseFragment getInstance() {
        if (instance == null) {
            synchronized (HotCityChoseFragment.class) {
                if (instance == null) {
                    instance = new HotCityChoseFragment();
                    return instance;
                } else {
                    return instance;
                }
            }
        } else {
            return instance;
        }
    }*/

}
