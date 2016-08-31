package com.example.xm.zhoubianyouofour;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.xm.zhoubianyouofour.utils.ui.GuideActivity;
import com.example.xm.zhoubianyouofour.utils.ui.HomeActivity;

import cn.jpush.android.api.JPushInterface;

public class MainActivity extends AppCompatActivity {

    private boolean flag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = getSharedPreferences("FLAG_ENTRY_TIMES", MODE_PRIVATE);
        flag = sp.getBoolean("FLAG_USED", true);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (flag) {
                    jumpToGuide(MainActivity.this);
                } else {
                    jumpToHome(MainActivity.this);
                }
                finish();
            }
        }, 2000);


    }

    @Override
    protected void onResume() {
        super.onResume();
        JPushInterface.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        JPushInterface.onPause(this);
    }

    /**
     * 跳转到主页面
     *
     * @param activity
     */
    public void jumpToHome(Activity activity) {
        Intent intent = new Intent(activity, HomeActivity.class);
        activity.startActivity(intent);
        finish();

    }

    /**
     * 跳转到引导页面
     *
     * @param activity
     */
    public void jumpToGuide(Activity activity) {
        Intent intent = new Intent(activity, GuideActivity.class);
        activity.startActivity(intent);
        finish();
    }
}
