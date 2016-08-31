package com.example.xm.zhoubianyouofour.find.ui;


import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xm.zhoubianyouofour.R;
import com.example.xm.zhoubianyouofour.find.FindContants;
import com.example.xm.zhoubianyouofour.find.adapter.MyRecyclerViewAdapter;
import com.example.xm.zhoubianyouofour.find.entity.BottomImgBean;
import com.example.xm.zhoubianyouofour.find.entity.MessageEvent;
import com.example.xm.zhoubianyouofour.utils.other.LogUtil;
import com.example.xm.zhoubianyouofour.utils.other.OkHttpUtils;
import com.example.xm.zhoubianyouofour.utils.ui.BaseFragment;
import com.squareup.okhttp.Request;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private MyRecyclerViewAdapter adapter;
    private List<BottomImgBean.ContentBean.ThemeListBean> themeListBeanList;
    private SwipeRefreshLayout swipeRefreshLayout;
    private BottomImgBean.ContentBean contentBean;
    private BottomImgBean bottomImgBean;
    private TextView find_place;
    private ImageView find_searchimg;

    @Override
    protected int getLayout() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initView() {
        recyclerView = (RecyclerView) root.findViewById(R.id.find_bottom_recyclerView);
        swipeRefreshLayout = (SwipeRefreshLayout) root.findViewById(R.id.find_swiperefreshlayout);
        find_place = (TextView) root.findViewById(R.id.find_place);
        find_searchimg = (ImageView) root.findViewById(R.id.find_searchimg);
    }

    @Override
    protected void initData() {
        /**
         * 设置SwipeRefreshLayout下拉刷新的进度条的颜色、位置
         */
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Color.WHITE);
        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.BLACK, Color.GREEN);
        swipeRefreshLayout.setProgressViewOffset(false, 0, 50);

        /**
         * 设置RecyclerView的方向 水平or垂直
         */
        linearLayoutManager = new LinearLayoutManager(getActivity(), OrientationHelper.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new MyRecyclerViewAdapter(getActivity(), 1);

        requestData(FindContants.FINDURL);


    }


    @Override
    protected void initEvents() {
        adapter.setRecyclerViewFindItemClickListener(new MyRecyclerViewAdapter.OnRecyclerViewFindItemClickListener() {
            @Override
            public void OnItemClick(View view, Object object, int position) {
//                EventBus.getDefault().cancelEventDelivery(object); //取消事件提供(发送)
                if (position >= 8) {
                    LogUtil.e("----", "发送:" + ((BottomImgBean.ContentBean.ThemeListBean) object).getSubTitle() + "--------->" + position);
                    EventBus.getDefault().postSticky(new MessageEvent(object, position));
                    Intent intent = new Intent(getActivity(), FindThemeActivity.class);
//                Bundle bundle = new Bundle();//传值改用EvnetBus
//                bundle.putInt("position",position);
//                intent.putExtras(bundle);
                    startActivity(intent);
                } else if (position == 1 || position == 3 || position == 5) {
                    Toast.makeText(getActivity(), "点击了" + position, Toast.LENGTH_SHORT).show();
                }
            }
        })
        ;

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (bottomImgBean == null) {
                    requestData(FindContants.FINDURL);
                } else {
                    adapter.notifyDataSetChanged();
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (swipeRefreshLayout.isRefreshing()) {
                            swipeRefreshLayout.setRefreshing(false);
                        }
                    }
                }, 2000);
            }
        });

        find_place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FindCityActivity.class);
                startActivity(intent);
            }
        });

        find_searchimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FindCityActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     * 20条RecyclerView数据以及设置适配器和更新数据
     */
    private void requestData(String url) {
        OkHttpUtils.getAsync(url, new OkHttpUtils.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) {
                LogUtil.e("", "" + result);
                bottomImgBean = BottomImgBean.objectFromData(result);
                contentBean = bottomImgBean.getContent();
                themeListBeanList = contentBean.getThemeList();


                /**设置设置下面的网络数据*/
                adapter.setBottomImgBeenList(themeListBeanList);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
    }


}
