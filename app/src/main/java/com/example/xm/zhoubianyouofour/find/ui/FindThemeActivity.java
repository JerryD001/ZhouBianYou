package com.example.xm.zhoubianyouofour.find.ui;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.xm.zhoubianyouofour.R;
import com.example.xm.zhoubianyouofour.find.FindContants;
import com.example.xm.zhoubianyouofour.find.adapter.MyBaseAdapter;
import com.example.xm.zhoubianyouofour.find.entity.BottomImgBean;
import com.example.xm.zhoubianyouofour.find.entity.BottomImgClickBean;
import com.example.xm.zhoubianyouofour.find.entity.MessageEvent;
import com.example.xm.zhoubianyouofour.utils.other.LogUtil;
import com.example.xm.zhoubianyouofour.utils.other.OkHttpUtils;
import com.example.xm.zhoubianyouofour.utils.ui.BaseActivity;
import com.squareup.okhttp.Request;
import com.squareup.picasso.Picasso;
import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.sso.QZoneSsoHandler;
import com.umeng.socialize.sso.UMQQSsoHandler;
import com.umeng.socialize.sso.UMSsoHandler;
import com.umeng.socialize.weixin.controller.UMWXHandler;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.List;


public class FindThemeActivity extends BaseActivity {
    private BottomImgBean.ContentBean.ThemeListBean themeListBean;
    private int position;
    private ImageView topImg;
    private TextView topTV, find_activity_topbartv, find_toptvbar, find_districtName;
    private List<BottomImgClickBean.ContentBean.ProductListBean> productListBeenList;
    private MyBaseAdapter adapter;
    private ListView find_clicklist;
    private UMSocialService mController;
    private View headerView;
    private LayoutInflater inflater;
    private SwipeRefreshLayout find_list_srl;

    @Override
    protected int getLayout() {
        return R.layout.find_activity_theme;
    }

    /**
     * threadMode 表示在哪个线程中接收消息
     * sticky 如果为true，表示收到粘性事件；相应的在发送事件时，要使用postSticky(Object event);
     * priority 优先级，值越大，越先处理
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true, priority = 1)
    public void onEventMainThread(MessageEvent event) {
//        LogUtil.e("----","接收"+((BottomImgBean.ContentBean.ThemeListBean)event.getObject()).getSubTitle());
        position = event.getPosition();
        themeListBean = (BottomImgBean.ContentBean.ThemeListBean) event.getObject();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        LogUtil.e("----", "注册");
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        EventBus.getDefault().removeAllStickyEvents();//删除所有粘性事件
    }

    @Override
    protected void initView() {
/*        Intent intent = getIntent();//改用EventBus传值了
        Bundle bundle = intent.getExtras();
        int position = (int) bundle.get("position");
        LogUtil.e("----","position="+position);*/
        find_clicklist = (ListView) findViewById(R.id.find_clicklist);
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        headerView = inflater.inflate(R.layout.find_item_listviewheader,find_clicklist,false);

        /** 给listview 添加头部 */
        find_clicklist.addHeaderView(headerView);

        topImg = (ImageView) findViewById(R.id.cardview_img);
        topTV = (TextView) findViewById(R.id.find_toptv);
        find_activity_topbartv = (TextView) findViewById(R.id.find_activity_topbartv);
        find_toptvbar = (TextView) findViewById(R.id.find_toptvbar);
        find_districtName = (TextView) findViewById(R.id.find_districtName);

        find_list_srl = (SwipeRefreshLayout) findViewById(R.id.find_list_swiperefreshlayout);

    }

    @Override
    protected void initData() {
            /** 友盟分享 */
// 首先在您的Activity中添加如下成员变量
        mController = UMServiceFactory.getUMSocialService("com.umeng.share");
// 设置分享内容
        mController.setShareContent(themeListBean.getSubTitle() + "\n" + themeListBean.getDescription());
// 设置分享图片, 参数2为图片的url地址
        mController.setShareMedia(new UMImage(this, themeListBean.getImageUrl()));

        String appID = "wx967daebe835fbeac";
        String appSecret = "5fa9e68ca3970e87a1f83e563c8dcbce";

// 添加微信平台
        UMWXHandler wxHandler = new UMWXHandler(this, appID, appSecret);
        wxHandler.addToSocialSDK();
// 添加微信朋友圈
        UMWXHandler wxCircleHandler = new UMWXHandler(this, appID, appSecret);
        wxCircleHandler.setToCircle(true);
        wxCircleHandler.addToSocialSDK();


//参数1为当前Activity，参数2为开发者在QQ互联申请的APP ID，参数3为开发者在QQ互联申请的APP kEY.
        UMQQSsoHandler qqSsoHandler = new UMQQSsoHandler(this, "1105438321",
                "PAFoIRZLk7znrNVS");
        qqSsoHandler.addToSocialSDK();

//参数1为当前Activity，参数2为开发者在QQ互联申请的APP ID，参数3为开发者在QQ互联申请的APP kEY.
        QZoneSsoHandler qZoneSsoHandler = new QZoneSsoHandler(this, "1105438321",
                "PAFoIRZLk7znrNVS");
        qZoneSsoHandler.addToSocialSDK();


        /**
         * 设置SwipeRefreshLayout下拉刷新的进度条的颜色、位置
         */
        find_list_srl.setProgressBackgroundColorSchemeColor(Color.WHITE);
        find_list_srl.setColorSchemeColors(Color.RED, Color.BLUE, Color.BLACK, Color.GREEN);
        find_list_srl.setProgressViewOffset(false, 0, 50);


        Picasso.with(this).load(themeListBean.getImageUrl()).into(topImg);
        find_activity_topbartv.setText(themeListBean.getTitle());
        find_toptvbar.setText(themeListBean.getSubTitle());
        topTV.setText(themeListBean.getDescription());
        find_districtName.setText(themeListBean.getDistrictName());
        /** 拼接url */
        String url = FindContants.FINDRECYCLERVIEWURL1 + themeListBean.getThemeId() + FindContants.FINDRECYCLERVIEWURL2;
        /** 获取网络数据 */
        OkHttpUtils.getAsync(url, new OkHttpUtils.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) {
                BottomImgClickBean bottomImgClickBean = BottomImgClickBean.objectFromData(result);
                BottomImgClickBean.ContentBean contentBean = bottomImgClickBean.getContent();
                productListBeenList = contentBean.getProductList();
                adapter = new MyBaseAdapter(productListBeenList, FindThemeActivity.this, R.layout.find_item_activitylist);

                find_clicklist.setAdapter(adapter);



            }
        });

    }


    @Override
    protected void initEvents() {
        /** 下拉刷新  及刷新时间 */
        find_list_srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.notifyDataSetChanged();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (find_list_srl.isRefreshing()){
                            find_list_srl.setRefreshing(false);
                        }
                    }
                }, 2000);
            }
        });


    }

    public void onBackFromThemeActivity(View view) {
        finish();
    }

    public void onShareClick(View view) {
        mController.openShare(this, false);
    }

    /**
     * 如果有使用新浪、人人的SSO授权或者集成了facebook平台, 则必须在对应的activity中实现onActivityResult方法, 并添加如下代码
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMSsoHandler ssoHandler = mController.getConfig().getSsoHandler(requestCode);
        if (ssoHandler != null) {
            ssoHandler.authorizeCallBack(requestCode, resultCode, data);
        }
    }


}
