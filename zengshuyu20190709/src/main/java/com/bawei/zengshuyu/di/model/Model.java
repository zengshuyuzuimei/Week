package com.bawei.zengshuyu.di.model;

import android.content.Context;

import com.bawei.zengshuyu.data.LoginInterceptor;
import com.bawei.zengshuyu.data.constant.Constant;
import com.bawei.zengshuyu.di.contract.Contract;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*
 *@Auther:曾淑雨
 *@Date: 2019/7/9
 *@Time: 09:16:59
 *@Description:实现网络请求
 * */
public class Model implements Contract.Model {
    @Override
    public void requestLogin(Context context, String name, String pwd, final LoginCallBack loginCallBack) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoginInterceptor())
                .build();
        FormBody formBody = new FormBody.Builder()
                .add("phone", name)
                .add("pwd", pwd)
                .build();
        Request request = new Request.Builder().url(Constant.LOGIN_URL)
                .post(formBody)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                loginCallBack.getData(e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String string = response.body().string();
                loginCallBack.getData(string);
            }
        });
    }

}
