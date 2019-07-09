package com.bawei.zengshuyu.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.zengshuyu.R;
import com.bawei.zengshuyu.data.net.MessageEvent;
import com.bawei.zengshuyu.di.contract.Contract;
import com.bawei.zengshuyu.di.presenter.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 *@Auther:曾淑雨
 *@Date: 2019/7/9
 *@Time: 09:19:15
 *@Description:登录界面
 * */
public class MainActivity extends BaseActivity<Contract.View, Presenter<Contract.View>> implements Contract.View {

    @BindView(R.id.user_name)
    EditText user_Name;
    @BindView(R.id.user_pwd)
    EditText user_Pwd;
    @BindView(R.id.btn_register)
    Button btn_Register;
    @BindView(R.id.btn_login)
    Button btn_Login;
    private Context context;

    @Override
    protected void initData() {
    }

    @Override
    public void showLogin(final String string) {
        Log.e("aaa",""+string);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (!string.equals("0000")) {
                    Toast.makeText(context, "登录成功", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,ShowActivity.class));
                } else {
                    Toast.makeText(context, "登录失败", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });


    }

    @OnClick({R.id.btn_register, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_login:
                context = this;
                String name = user_Name.getText().toString();
                String pwd = user_Pwd.getText().toString();
                presenter.Login(context, name, pwd);
                MessageEvent messageEvent = new MessageEvent();
                String s = user_Name.getText().toString();
                messageEvent.setPhone(s);
                messageEvent.setHeadPic("http://172.17.8.100/images/small/head_pic/2019-07-08/20190708164654.jpg");
                EventBus.getDefault().postSticky(messageEvent);
                break;
        }
    }

    @Override
    protected Presenter<Contract.View> createPresenter() {
        return new Presenter<>();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

}
