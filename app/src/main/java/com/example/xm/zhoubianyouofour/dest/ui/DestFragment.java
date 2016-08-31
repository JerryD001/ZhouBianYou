package com.example.xm.zhoubianyouofour.dest.ui;


import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xm.zhoubianyouofour.R;
import com.example.xm.zhoubianyouofour.dest.Contants_dest;
import com.example.xm.zhoubianyouofour.dest.adapter.DestFragmentStatePagerAdapter;
import com.example.xm.zhoubianyouofour.dest.adapter.PopupWindowAdapter;
import com.example.xm.zhoubianyouofour.dest.entity.CityTitleBean;
import com.example.xm.zhoubianyouofour.find.ui.FindCityActivity;
import com.example.xm.zhoubianyouofour.utils.other.OkHttpUtils;
import com.example.xm.zhoubianyouofour.utils.ui.BaseFragment;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DestFragment extends BaseFragment implements View.OnClickListener {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TextView tv_select_area;
    private List<String> titleList;
    private List<CityTitleBean.ContentBean> cbList;
    private List<BaseFragment> fragmentsList;
    private DestFragmentStatePagerAdapter adapter;

    private RelativeLayout btn_rl_search;
    private LinearLayout btn_ll;
    private ImageButton imageButton;
    private PopupWindow popupWindow;
    private View contentView;
    private GridView gridView;
    private PopupWindowAdapter pwAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_dest;
    }

    @Override
    protected void initView() {
        viewPager = (ViewPager) root.findViewById(R.id.dest_choose_city_viewpager);
        tabLayout = (TabLayout) root.findViewById(R.id.dest_tablayout);
        tv_select_area = (TextView) root.findViewById(R.id.dest_select_area);
        btn_rl_search = (RelativeLayout) root.findViewById(R.id.dest_header_search);
        btn_ll = (LinearLayout) root.findViewById(R.id.button_show_popowindow);
        imageButton = (ImageButton) root.findViewById(R.id.imgbutton_show_popowindow);
        imageButton.setBackgroundResource(R.drawable.destination_city_up_icon);//设置按钮背景图

        //初始化popupWindow
        contentView = LayoutInflater.from(getActivity()).inflate(R.layout.dest_citylist_gridview, null);
        popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        gridView = (GridView) contentView.findViewById(R.id.dest_citylist_gridview);
    }

    @Override
    protected void initData() {
        //初始化viewPager适配器
        adapter = new DestFragmentStatePagerAdapter(getChildFragmentManager());

        //初始化popupWindow适配器
        pwAdapter = new PopupWindowAdapter(getActivity());

        getTitleData();
    }

    @Override
    protected void initEvents() {
        btn_ll.setOnClickListener(this);
        btn_rl_search.setOnClickListener(this);
    }

    private void getTitleData() {
        titleList = new ArrayList<>();
        OkHttpUtils.getAsync(Contants_dest.SlidingTabLayout, new OkHttpUtils.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {
                Toast.makeText(getActivity(), "网络连接失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void requestSuccess(String result) {
                CityTitleBean cityTitlebean = CityTitleBean.objectFromData(result);
                cbList = cityTitlebean.getContent();

                //new出所有fragment页，得到它的list集合
                fragmentsList = new ArrayList<>();
                for (int i = 0; i < cbList.size(); i++) {
                    BaseFragment fragment;
                    if (i == 0) {
                        fragment = HotCityChoseFragment.newInstance(cbList.get(i));
                    } else {
                        fragment = CommonCityChoseFragment.newInstance(cbList.get(i));
                    }
                    fragmentsList.add(fragment);

                    titleList.add(cbList.get(i).getName());// 获取title名称集合
                }

                adapter.setFragmentList(fragmentsList);//设置fragmentsList集合

                adapter.setTitleList(titleList);//设置tabLayout数据
                //设置viewPager适配器
                viewPager.setAdapter(adapter);
                // TabLayout和ViewPager关联\TabLayout属性已全部在xml中设置
                tabLayout.setupWithViewPager(viewPager);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_show_popowindow:
                if (!popupWindow.isShowing()) {
                    imageButton.setBackgroundResource(R.drawable.destination_city_down_icon);//改变按钮背景图
                    showPopupWindow();
                    tabLayout.setVisibility(View.GONE);
                    tv_select_area.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.dest_header_search:
                startActivity(new Intent(getActivity(), FindCityActivity.class));
            default:
                break;
        }
    }

    /**
     * 显示poPoWindow
     */
    private void showPopupWindow() {

        //popupWindow.setTouchable(true);//设置PopupWindow是否响应touch事件
        popupWindow.setFocusable(true);//加了这行，onItemClick才好用
        popupWindow.setBackgroundDrawable(new BitmapDrawable());//加上它之后，setOutsideTouchable（）才会生效; 而且，只有加上它之后，PopupWindow才会对手机的返回按钮有响应
        popupWindow.setOutsideTouchable(true);//PopupWindow以外的区域是否可点击，即如果点击PopupWindow以外的区域，PopupWindow是否会消失。

        popupWindow.setAnimationStyle(R.style.popupwindow_anim);
        popupWindow.showAsDropDown(btn_ll);//设置popupWindow的显示位置

        //设置popupWindow适配器
        pwAdapter.setTitleList(titleList);
        gridView.setAdapter(pwAdapter);

        //popupWindow内容gridView的item点击事件
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //Toast.makeText(getActivity(), "点击了popupWindow: " + titleList.get(position), Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
                tabLayout.setVisibility(View.VISIBLE);
                tv_select_area.setVisibility(View.GONE);
                viewPager.setCurrentItem(position);
            }
        });

        //popupWindow消失的监听事件
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                imageButton.setBackgroundResource(R.drawable.destination_city_up_icon);//改变按钮背景图
                tabLayout.setVisibility(View.VISIBLE);
                tv_select_area.setVisibility(View.GONE);
            }
        });

        /*contentView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK){
                    if(popupWindow.isShowing()) {
                        popupWindow.dismiss();
                    }
                }
                return false;
            }
        });*/

    }

}
