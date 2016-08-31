package com.example.xm.zhoubianyouofour.dest.ui;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xm.zhoubianyouofour.R;
import com.example.xm.zhoubianyouofour.dest.Contants_dest;
import com.example.xm.zhoubianyouofour.dest.adapter.CityScenicListActivityRVAdapter;
import com.example.xm.zhoubianyouofour.dest.entity.CityScenicListBean;
import com.example.xm.zhoubianyouofour.dest.entity.CommonCityContentBean;
import com.example.xm.zhoubianyouofour.utils.other.LogUtil;
import com.example.xm.zhoubianyouofour.utils.other.OkHttpUtils;
import com.example.xm.zhoubianyouofour.utils.other.RVDivider;
import com.example.xm.zhoubianyouofour.utils.ui.BaseActivity;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.util.List;

public class CityScenicListActivity extends BaseActivity implements View.OnClickListener {

    private ImageView img_back;
    private TextView tv_bar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager manager;

    private CityScenicListActivityRVAdapter adapter;
    private List<CityScenicListBean.ContentBean> cbList;
    private Intent intent;

    private Bundle bundle;
    private CommonCityContentBean.ContentBean.HotCityBean city;
    private PopupWindow popupWindow;

    //popupWindow 这里用popupWindow不太好实现，可以换成fragment(下部透明，点击隐藏整个fragment)或其他
    private View contentView;
    private int windowHeight;
    private int windowWidth;
    private RadioGroup radioGroup;
    private RadioButton btn_order;
    private RadioButton btn_category;
    private RadioButton btn_filter;


    @Override
    protected int getLayout() {
        return R.layout.activity_city_scenic_list;
    }

    @Override
    protected void initView() {
        radioGroup = (RadioGroup) findViewById(R.id.dest_option_radiogroup);
        btn_order = (RadioButton) findViewById(R.id.dest_btn_order);
        btn_category = (RadioButton) findViewById(R.id.dest_btn_category);
        btn_filter = (RadioButton) findViewById(R.id.dest_btn_filter);
        img_back = (ImageView) findViewById(R.id.dest_back);
        tv_bar = (TextView) findViewById(R.id.dest_citysceniclist_bar_title);
        recyclerView = (RecyclerView) findViewById(R.id.dest_city_scenic_list_recyclerview);

        initPopupWindow();
    }

    private void initPopupWindow() {
        contentView = LayoutInflater.from(this).inflate(R.layout.dest_citysceniclist_option_popupwindow, null);
        //windowHeight = this.getWindowManager().getDefaultDisplay().getHeight();
        windowWidth = this.getWindowManager().getDefaultDisplay().getWidth();
        popupWindow = new PopupWindow(contentView, windowWidth, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    protected void initData() {
        adapter = new CityScenicListActivityRVAdapter(this);
        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.addItemDecoration(new RVDivider(this, OrientationHelper.HORIZONTAL));
        recyclerView.setLayoutManager(manager);

        intent = getIntent();// 获取上一个页面点击事件传过来的intent，bundle携带过来的是一个CityScenicListBean.ContentBean对象
        bundle = intent.getExtras();
        city = (CommonCityContentBean.ContentBean.HotCityBean) bundle.getSerializable(Contants_dest.HOT_CITY_LIST_KEY);
        if (bundle != null) {
            if (bundle.containsKey(Contants_dest.HOT_CITY_LIST_KEY)) {
                String URL = Contants_dest.CITY_BUTTON_URL1 + city.getCityName() + Contants_dest.CITY_BUTTON_URL2;
                LogUtil.e("----------------areaCode", city.getAreaCode() + city.getCityName() + "  " + URL);
                getData(URL);
            }
        }
    }

    private void getData(String URL) {

        OkHttpUtils.getAsync(URL, new OkHttpUtils.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {
                Toast.makeText(CityScenicListActivity.this, "网络连接异常", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void requestSuccess(String result) {
                CityScenicListBean citySLBean = CityScenicListBean.objectFromData(result);
                cbList = citySLBean.getContent();
                tv_bar.setText(cbList.get(0).getCity());//设置最上部城市名称，每条json的city相同，随便取一条数据
                adapter.setCbList(cbList);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void initEvents() {
        //注册监听事件
        img_back.setOnClickListener(this);
        btn_order.setOnClickListener(this);
        btn_category.setOnClickListener(this);
        btn_filter.setOnClickListener(this);

        //监听popupWindow消失事件
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1);// 设置activity窗口完全透明
                btn_order.setClickable(true);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dest_back: //返回按钮
                finish();
            case R.id.dest_btn_order:
                if (!popupWindow.isShowing()) {
                    showOrderPopupWindow();
                    btn_order.setClickable(false);// 解决popupWindow在显示时点击外部使其消失时(刚好点击button处)与button点击冲突
                }
                break;
            case R.id.dest_btn_category:
                break;
            case R.id.dest_btn_filter:
                break;
        }
    }

    private void showOrderPopupWindow() {
        backgroundAlpha(0.6f);// 设置activity窗口半透明
        popupWindow.setBackgroundDrawable(new BitmapDrawable());// 加上这句话，下面这句话才会生效
        popupWindow.setOutsideTouchable(true);// 设置点击popupWindow外其他位置，popupWindow消失
        //popupWindow.setFocusable(true); //为了能够点击另外两个button，不能让popupWindow获取焦点
        popupWindow.showAsDropDown(radioGroup);
    }


    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha) {// 0.0f-1.0f
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.alpha = bgAlpha;
        getWindow().setAttributes(params);
    }

}
