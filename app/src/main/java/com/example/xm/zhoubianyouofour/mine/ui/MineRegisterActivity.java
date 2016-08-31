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
import com.example.xm.zhoubianyouofour.utils.ui.BaseActivity;

public class MineRegisterActivity extends BaseActivity implements View.OnClickListener {

    private Button register_back;
    private Button register_back_mine;
    private EditText input_phone_register;
    private EditText input_password_register;
    private Button btn_register_1;
    private SharedPreferences sharedPreferences;

    @Override
    protected int getLayout() {
        return R.layout.mine_register_layout;
    }

    @Override
    protected void initView() {

        register_back= (Button) findViewById(R.id.register_back);
        register_back_mine= (Button) findViewById(R.id.register_back_mine);

        input_phone_register = (EditText) findViewById(R.id.input_password_register);
        input_password_register = (EditText) findViewById(R.id.input_password_register);
        btn_register_1 = (Button) findViewById(R.id.btn_register_1);

//        final String phone= input_phone_register.getText().toString();
//        final String password= input_password_register.getText().toString();


        btn_register_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone= input_phone_register.getText().toString();
                String password= input_password_register.getText().toString();
                LogUtil.e("----","phone="+phone+"    password"+password);
                sharedPreferences = MineRegisterActivity.this.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("phoneNum",phone);
                editor.putString("password",password);
                editor.commit();

                if ((phone!=null)&&(password!=null)) {
                    Intent in = new Intent(MineRegisterActivity.this, MineLoginActivity.class);
                    startActivity(in);
                    //   SharedPreferencesUtils.save(getActivity(),++count);
                }else {
                    Toast.makeText(MineRegisterActivity.this,"密码不能为空",Toast.LENGTH_SHORT).show();
                }
            }
        });


        register_back_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        register_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MineRegisterActivity.this,MineLoginActivity.class);
                startActivity(in);
            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvents() {

    }

    @Override
    public void onClick(View v) {


    }
}
