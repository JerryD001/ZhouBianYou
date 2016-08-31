package com.example.xm.zhoubianyouofour.homepage.ui;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.example.xm.zhoubianyouofour.R;
import com.example.xm.zhoubianyouofour.homepage.HomeContants;
import com.example.xm.zhoubianyouofour.homepage.adapter.DestinationPagerAdapter;
import com.example.xm.zhoubianyouofour.homepage.adapter.GridViewBaseAdapter;
import com.example.xm.zhoubianyouofour.homepage.adapter.RecyclerviewAdapter;
import com.example.xm.zhoubianyouofour.homepage.entity.GridViewBean;
import com.example.xm.zhoubianyouofour.homepage.entity.HotBean;
import com.example.xm.zhoubianyouofour.homepage.entity.NetworkImageHolderView;
import com.example.xm.zhoubianyouofour.homepage.entity.RecyclerBean;
import com.example.xm.zhoubianyouofour.utils.other.OkHttpUtils;
import com.example.xm.zhoubianyouofour.utils.ui.BaseFragment;
import com.squareup.okhttp.Request;
import com.squareup.picasso.Picasso;
import com.xys.libzxing.zxing.activity.CaptureActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends BaseFragment implements AppBarLayout.OnOffsetChangedListener {
    private GridView gridView;
    private List<String> headerList;
    private GridViewBaseAdapter gridviewAdapter;
    private ConvenientBanner convenientBanner;
    private ImageView[] neckimgs;
    private List<DestinationFragment> detinationlist;
    private ViewPager destinationViewpager;
    private DestinationPagerAdapter destinationPagerAdapter;
    private RadioGroup radioGroup;
    private TabLayout tabLayout;
    private RecyclerView recyclerView;
    private RecyclerviewAdapter recyclerviewAdapter;
    private ImageView hotImage, tabicon, searchimg;
    private int lastItem;
    private LinearLayoutManager llm;
    private List<RecyclerBean.ContentBean.Data> allList;
    private List<HotBean.ContentBean> hotlist;
    private Toolbar headbar;
    private AppBarLayout appBarLayout;
    private TextView citytxt;
    private FloatingActionButton floatingActionButton;
    private RelativeLayout refrsahLayout;

    @Override
    protected int getLayout() {
        return R.layout.fragment_homepage;
    }

    @Override
    protected void initView() {
        gridView = (GridView) root.findViewById(R.id.home_appbar_gridview);
        convenientBanner = (ConvenientBanner) root.findViewById(R.id.home_appbar_ViewPager);
        neckimgs = new ImageView[]{(ImageView) root.findViewById(R.id.home_appbar_baby)
                , (ImageView) root.findViewById(R.id.home_appbar_summer)
                , (ImageView) root.findViewById(R.id.home_appbar_around)
                , (ImageView) root.findViewById(R.id.home_appbar_ticket)};
        destinationViewpager = (ViewPager) root.findViewById(R.id.home_appbar_destination_viewpager);
        radioGroup = (RadioGroup) root.findViewById(R.id.destination_radiogroup);
        radioGroup.check(R.id.destination_radio1);
        tabLayout = (TabLayout) root.findViewById(R.id.home_tabs);
        recyclerView = (RecyclerView) root.findViewById(R.id.home_recyclerview);
        hotImage = (ImageView) root.findViewById(R.id.home_appbar_hot_img);
        headbar = (Toolbar) root.findViewById(R.id.home_toolbar);
        tabicon = (ImageView) root.findViewById(R.id.home_tab_icon);
        citytxt = (TextView) root.findViewById(R.id.home_place);
        searchimg = (ImageView) root.findViewById(R.id.home_scan);
        appBarLayout = (AppBarLayout) root.findViewById(R.id.home_appbar);
        floatingActionButton = (FloatingActionButton) root.findViewById(R.id.fab);
        refrsahLayout = (RelativeLayout) root.findViewById(R.id.home_head_refrash);
    }

    @Override
    protected void initData() {
        gridviewAdapter = new GridViewBaseAdapter(getActivity());
        gridViewData(HomeContants.HEADURL);

        hotlist = new ArrayList<>();
        llm = new LinearLayoutManager(getActivity(), OrientationHelper.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(llm);

        //设置分割
        //recyclerView.addItemDecoration(new RVDivider(getContext(),OrientationHelper.HORIZONTAL));
        recyclerviewAdapter = new RecyclerviewAdapter(0, getActivity());

        aroundData(HomeContants.AROUNDURL);

    }

    @Override
    protected void initEvents() {
        searchimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getActivity(), CaptureActivity.class),0);
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refrsahLayout.setVisibility(View.VISIBLE);
                Timecount timecount = new Timecount(3000, 1000);
                timecount.start();
            }
        });
        detinationlist = new ArrayList<>();
        for (int l = 0; l < 7; l++) {
            DestinationFragment destinationFragment = DestinationFragment.getInstence(l);
            detinationlist.add(destinationFragment);

        }
        destinationPagerAdapter = new DestinationPagerAdapter(getChildFragmentManager());
        destinationPagerAdapter.setList(detinationlist);
        destinationViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radioGroup.check(R.id.destination_radio1);
                        break;
                    case 1:
                        radioGroup.check(R.id.destination_radio2);
                        break;
                    case 2:
                        radioGroup.check(R.id.destination_radio3);
                        break;
                    case 3:
                        radioGroup.check(R.id.destination_radio4);
                        break;
                    case 4:
                        radioGroup.check(R.id.destination_radio5);
                        break;
                    case 5:
                        radioGroup.check(R.id.destination_radio6);
                        break;
                    case 6:
                        radioGroup.check(R.id.destination_radio7);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        destinationViewpager.setAdapter(destinationPagerAdapter);
        destinationPagerAdapter.notifyDataSetChanged();

        //recyclerview数据填充
        final TabLayout.Tab aroundTab = tabLayout.newTab().setText(HomeContants.AROUND);
        final TabLayout.Tab hotTab = tabLayout.newTab().setText(HomeContants.HOT);
        tabLayout.addTab(aroundTab);
        tabLayout.addTab(hotTab);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //选中的tab
                for (int i = 0; i < tabLayout.getTabCount(); i++) {
                    if (aroundTab.isSelected()) {
                        aroundData(HomeContants.AROUNDURL);
                    } else {
                        HotData(HomeContants.HOTURL);
                    }
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                String newUrl = null;
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastItem + 1 == llm.getItemCount()) {
                    newUrl = HomeContants.AROUNDURL;
                    aroundData(newUrl);
                    if (hotTab.isSelected()) {
                        newUrl = HomeContants.HOTURLHEAD + (++HomeContants.PAGESIZE) + HomeContants.HOTURLFOOT;
                        HotData(newUrl);
                    }
                }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastItem = llm.findLastCompletelyVisibleItemPosition();
            }
        });
        recyclerviewAdapter.setOnClickListen(new RecyclerviewAdapter.ItemOnClickListen() {
            @Override
            public void onClickListen(View v, RecyclerBean.ContentBean.Data dataBean, int position) {
                Toast.makeText(getContext(), "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 获取home_appbar_head数据
     */
    private void gridViewData(String url) {
        OkHttpUtils.getAsync(url, new OkHttpUtils.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) {
                GridViewBean gridViewBean = GridViewBean.getGridviewBean(result);
                List<GridViewBean.ContentBean> list = gridViewBean.getContent();
                gridviewAdapter.setList(list);
                gridView.setAdapter(gridviewAdapter);
                gridviewAdapter.notifyDataSetChanged();
                headerList = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    List<GridViewBean.ContentBean.AdBean> adList = list.get(i).getAd();
                    if (list.get(i).getOperateId().equals("5")) {
                        for (int j = 0; j < adList.size(); j++) {
                            headerList.add(adList.get(j).getCt().getApp_picpath());
                        }
                    } else if (list.get(i).getOperateId().equals("12")) {
                        for (int k = 0; k < adList.size(); k++) {
                            Picasso.with(getContext()).load(adList.get(k).getCt().getApp_picpath()).into(neckimgs[k]);
                        }
                    }
                }

                convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
                    @Override
                    public NetworkImageHolderView createHolder() {
                        return new NetworkImageHolderView();
                    }
                }, headerList)
                        .setPageIndicator(new int[]{R.drawable.home_switching_dot, R.drawable.home_switching_dot_current})
                        .setOnItemClickListener(new OnItemClickListener() {
                            @Override
                            public void onItemClick(int position) {
                                Toast.makeText(getActivity(), "666" + position, Toast.LENGTH_SHORT).show();
                            }
                        });
            }

        });
    }

    @Override
    public void onResume() {
        super.onResume();
        convenientBanner.startTurning(3000);
        appBarLayout.addOnOffsetChangedListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        convenientBanner.stopTurning();
        appBarLayout.removeOnOffsetChangedListener(this);
    }

    /**
     * 获取recyclerview的数据
     */
    public void aroundData(String url) {
        OkHttpUtils.getAsync(url, new OkHttpUtils.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) {
                RecyclerBean recyclerBean = RecyclerBean.objectFromData(result);
                List<RecyclerBean.ContentBean.Data> list = recyclerBean.getContent().get(0).getDatabean();
                recyclerviewAdapter.setList(list);
                if (allList == null) {
                    allList = new ArrayList<>();
                    recyclerView.setAdapter(recyclerviewAdapter);
                }
                allList.addAll(list);
                recyclerviewAdapter.setList(allList);
                recyclerviewAdapter.notifyDataSetChanged();
                Picasso.with(getContext()).load(list.get(0).getBigImageUrl()).into(hotImage);
            }
        });
    }

    public void HotData(String url) {
        OkHttpUtils.getAsync(url, new OkHttpUtils.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) {
                HotBean hotBean = HotBean.objectFromData(result);
                List<HotBean.ContentBean> list = hotBean.getContent();
                hotlist.addAll(list);
                List<RecyclerBean.ContentBean.Data> dataList = new ArrayList<RecyclerBean.ContentBean.Data>();
                for (int i = 0; i < hotlist.size(); i++) {
                    RecyclerBean.ContentBean.Data data = new RecyclerBean.ContentBean.Data();
                    data.setStateText(hotlist.get(i).getStateText());
                    data.setBigImageUrl(hotlist.get(i).getBigImageUrl());
                    data.setProductName(hotlist.get(i).getProductName());
                    data.setProductTitleContent(hotlist.get(i).getProductTitleContent());
                    data.setRecommend(hotlist.get(i).isRecommend());
                    data.setCityName(hotlist.get(i).getCityName());
                    data.setLabelText(hotlist.get(i).getLabelText());
                    data.setSaledCount(hotlist.get(i).getSaledCount());
                    dataList.add(data);
                }
                recyclerviewAdapter.setList(dataList);
                recyclerviewAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (verticalOffset < 0) {
            headbar.setBackgroundColor(Color.WHITE);
            citytxt.setTextColor(this.getResources().getColor(R.color.orange));
            tabicon.setImageResource(R.drawable.home_location_pull_down_cm_icon);
            searchimg.setImageResource(R.drawable.nav_bar_scanning_icon);
        } else {
            headbar.setBackgroundColor(Color.TRANSPARENT);
            citytxt.setTextColor(this.getResources().getColor(R.color.white));
            tabicon.setImageResource(R.drawable.home_location_pull_down_icon);
            searchimg.setImageResource(R.drawable.nav_bar_scanning_white_icon);
        }
    }

    /**
     * 自定义定时器
     */
    public class Timecount extends CountDownTimer {

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public Timecount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {

        }

        @Override
        public void onFinish() {
            gridViewData(HomeContants.HEADURL);
            refrsahLayout.setVisibility(View.GONE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK) {
            Bundle bundle = data.getExtras();
            String str = bundle.getString("result");
//            tv_text.setText(str);
        }
    }
}
