package com.example.xm.zhoubianyouofour.mine.ui;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xm.zhoubianyouofour.R;
import com.example.xm.zhoubianyouofour.mine.adapter.MyTabPagerAdapter;
import com.example.xm.zhoubianyouofour.utils.ui.BaseActivity;
import com.example.xm.zhoubianyouofour.utils.ui.BaseFragment;
import com.squareup.picasso.Picasso;
import com.tencent.connect.UserInfo;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MineLoginActivity extends BaseActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<String> mTitles;
    private MyTabPagerAdapter adapter;
    private List<BaseFragment> fragmentList =  Arrays.asList(new MineLoginPasswordFragment(),
      new MineLoginPhoneCheckFragment());

    private Button register_back;
    private Button login_back_mine;
    private ImageView qq_login;
    private TextView qq_nickName;


    private Tencent mTencent;
    private static final String AppID="1105436847";
    private UserInfo mUserInfo;


    @Override
    protected int getLayout() {
        return R.layout.mine_login_layout;
    }

    @Override
    protected void initView() {
        tabLayout = (TabLayout) findViewById(R.id.login_tabLayout);
        viewPager = (ViewPager) findViewById(R.id.login_viewPager);
        register_back = (Button) findViewById(R.id.register_back);
        login_back_mine = (Button) findViewById(R.id.login_back_mine);
        qq_login= (ImageView) findViewById(R.id.qq_login_head);
        qq_nickName = (TextView) findViewById(R.id.qq_nickName);


        login_back_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        register_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MineLoginActivity.this,MineRegisterActivity.class);
                startActivity(in);
            }
        });

        //获取Tencent实例
        if(mTencent==null){
            mTencent = Tencent.createInstance(AppID,this);
        }

       qq_login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                mTencent.login(MineLoginActivity.this,"all",loginListener);
           }
       });
    }

    /**
     * 当第三方应用授权登陆成功后，返回到我们应用中，执行该方法，并将数据回传回来
     * @param requestCode
     * @param resultCode
     * @param data
     */
    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode== Constants.REQUEST_LOGIN){
            Tencent.onActivityResultData(requestCode,resultCode,data,loginListener);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }*/

    /**
     * 获取到了用户信息之后，更新UI
     */
    private void updateUI(JSONObject json){

        try {
            String nickeName = json.getString("nickname");
            String image = json.getString("figureurl_qq_2");
            qq_nickName.setText(nickeName);
            Picasso.with(this).load(image).into(qq_login);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取登陆成功后返回的数据，并进行处理
     */
    IUiListener loginListener=new LoginListener(){
        @Override
        protected void doComplete(JSONObject jsonObject) {
            initOpenIdAndToken(jsonObject);
            updateUserInfo();
        }
    };

    /**
     * 通过opneid、Access_Token、expires_in去获取账号的信息
     * 注意：必须要声明UserInfo实例
     */
    private void updateUserInfo(){
        IUiListener listener = new IUiListener() {
            @Override
            public void onComplete(Object o) {
                JSONObject json = (JSONObject) o;
                updateUI(json);
            }

            @Override
            public void onError(UiError uiError) {

            }

            @Override
            public void onCancel() {

            }
        };

        mUserInfo = new UserInfo(this,mTencent.getQQToken());
        mUserInfo.getUserInfo(listener);
    }

    /**
     * 授权登陆成功之后，获取opneid、Access_Token、expires_in
     * 并设置到Tencent
     * @param jsonObject
     */
    private void initOpenIdAndToken(JSONObject jsonObject){
        try {
            String openid = jsonObject.getString("openid");
            String expires_in = jsonObject.getString("expires_in");
            String token=jsonObject.getString("access_token");
            if(!TextUtils.isEmpty(openid)&&!TextUtils.isEmpty(expires_in)&&!TextUtils.isEmpty(token)){
                mTencent.setOpenId(openid);
                mTencent.setAccessToken(token,expires_in);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    private class LoginListener implements IUiListener{

        @Override
        public void onComplete(Object obj) {
           JSONObject jsonObject =(JSONObject) obj;
            doComplete(jsonObject);
        }

        @Override
        public void onError(UiError uiError) {
        }

        @Override
        public void onCancel() {
        }

        protected void doComplete(JSONObject jsonObject){
        }
    }


    @Override
    protected void initData() {
        mTitles = new ArrayList<>();
        mTitles.add("密码登录");
        mTitles.add("手机验证登录");
        for(int i=0;i<mTitles.size();i++){
            tabLayout.addTab(tabLayout.newTab().setText(mTitles.get(i)));
        }

        // 设置适配器
        adapter = new MyTabPagerAdapter(getSupportFragmentManager(),fragmentList,mTitles);
        viewPager.setAdapter(adapter);

        //tabLayout和ViewPager关联
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabsFromPagerAdapter(adapter);

    }

    @Override
    protected void initEvents() {

    }

}
