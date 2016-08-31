package com.example.xm.zhoubianyouofour.utils.ui;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.xm.zhoubianyouofour.R;
import com.example.xm.zhoubianyouofour.dest.ui.DestFragment;
import com.example.xm.zhoubianyouofour.find.ui.FindFragment;
import com.example.xm.zhoubianyouofour.homepage.ui.HomePageFragment;
import com.example.xm.zhoubianyouofour.mine.ui.MineFragment;
import com.example.xm.zhoubianyouofour.utils.other.LogUtil;

public class  HomeActivity extends BaseActivity {

    private long exitTime = 0;// 记录上一次按下Back键的时间

    private RadioGroup radioGroup;

    private FragmentManager manager;
    private FragmentTransaction tran;
    private Fragment[] fragments = {new HomePageFragment(),
            new DestFragment(),new FindFragment(), new MineFragment()};// 初始化fragment

    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        initState();// 沉浸式状态栏
        radioGroup = (RadioGroup) findViewById(R.id.activity_home_radiogroup);
    }

    @Override
    protected void initData() {
        manager = getSupportFragmentManager();
        tran = manager.beginTransaction();
        for (int i = 0; i < fragments.length; i++) {
            tran.add(R.id.activity_home_linearout, fragments[i], "i");// 增加fragment
            tran.hide(fragments[i]);// 隐藏fragment
        }
        tran.show(fragments[0]);// 默认显示HomePageFragment
        tran.commit();// 提交

        //设置默认被选中的RadioButton
        radioGroup.check(R.id.activity_home_rb_homepage);
    }

    @Override
    protected void initEvents() {
        //radioGroup点击不同按钮选择不同fragment页面事件
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index = 0;
                switch (checkedId) {
                    case R.id.activity_home_rb_homepage:
                        index = 0;
                        break;
                    case R.id.activity_home_rb_dest:
                        index = 1;
                        break;
                    case R.id.activity_home_rb_find:
                        index = 2;
                        break;
                    case R.id.activity_home_rb_mine:
                        index = 3;
                        break;
                    default:
                        break;
                }
                tran = manager.beginTransaction();
                for (int i = 0; i < fragments.length; i++) {
                    if (i == index) {
                        tran.show(fragments[i]);
                    } else {
                        tran.hide(fragments[i]);
                    }
                }
                tran.commit();
            }
        });
    }

    /**
     * 实现再按一次提示退出程序效果
     *
     * @param keyCode 手机虚拟按键
     * @param event   动作
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - exitTime > 2000) {// 判断系统当前时间与上一次按back键的差值
                exitTime = System.currentTimeMillis();
                Toast.makeText(HomeActivity.this, "再次点击退出周边游", Toast.LENGTH_SHORT).show();
            } else {
                LogUtil.e("----------", "程序退出");
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 沉浸式状态栏
     */
    private void initState() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
}
