package com.bawei.zengshuyu.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.zengshuyu.R;
import com.bawei.zengshuyu.di.contract.RegisterContract;
import com.bawei.zengshuyu.di.presenter.RegisterPresenter;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<RegisterContract.RegisterView, RegisterPresenter<RegisterContract.RegisterView>> implements RegisterContract.RegisterView {

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.btn)
    Button btn;
    private Context context;

    @Override
    public void showRegister(final String string) {
        Log.e("aaa",""+string);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (string.equals("0000")){
                    Toast.makeText(context, "注册成功", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                }else{
                    Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });


    }

    @Override
    protected void initData() {

    }

    @Override
    protected RegisterPresenter<RegisterContract.RegisterView> createPresenter() {
        return new RegisterPresenter<>();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }


    @OnClick(R.id.btn)
    public void onViewClicked() {
        context = this;
        String userName = name.getText().toString();
        String userPwd = pwd.getText().toString();
        presenter.Register(context,userName,userPwd);
    }
}
