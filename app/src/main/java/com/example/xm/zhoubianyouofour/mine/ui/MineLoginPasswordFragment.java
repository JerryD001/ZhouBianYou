package com.example.xm.zhoubianyouofour.mine.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xm.zhoubianyouofour.R;
import com.example.xm.zhoubianyouofour.utils.other.LogUtil;
import com.example.xm.zhoubianyouofour.utils.ui.BaseFragment;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class MineLoginPasswordFragment extends BaseFragment {

    private EditText input_phone;
    private EditText input_password;
    private Button btn_login_enter;
    private SharedPreferences sharedPreferences;
    private int count;


    @Override
    protected int getLayout() {
        return R.layout.mine_password_login_item_layout;
    }

    @Override
    protected void initView() {

        input_phone = (EditText) root.findViewById(R.id.input_phone);
        input_password = (EditText) root.findViewById(R.id.input_password);
        btn_login_enter = (Button) root.findViewById(R.id.btn_login_enter);



//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("phoneNum",phone);
//        editor.putString("password",password);
//        editor.commit();

//        final String phone1=sharedPreferences.getString("phoneNum"," ");
//        final String pwd = sharedPreferences.getString("password"," ");


        btn_login_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getContext().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                String phone1 = sharedPreferences.getString("phoneNum", " ");
                String pwd = sharedPreferences.getString("password", " ");
                String phone = input_phone.getText().toString();
                String password = input_password.getText().toString();

                LogUtil.e("-----", "phone1: " + phone1 + "pwd=: " + pwd);
                LogUtil.e("-----=====", "phone: " + phone + "password=: " + password);
                if ((phone1.equals(phone) && pwd.equals(password))) {

                    Intent in = new Intent(getActivity(), MineLoginSuccessActivity.class);
                    startActivity(in);
                    //   SharedPreferencesUtils.save(getActivity(),++count);
                } else {
                    Toast.makeText(getContext(), "输入有误", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    @Override
    protected void initData() {


    }

    @Override
    protected void initEvents() {

    }


}