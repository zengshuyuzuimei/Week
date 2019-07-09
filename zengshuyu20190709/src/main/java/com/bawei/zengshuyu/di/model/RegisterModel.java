package com.bawei.zengshuyu.di.model;

import android.content.Context;

import com.bawei.zengshuyu.data.constant.Constant;
import com.bawei.zengshuyu.di.contract.RegisterContract;
import com.bawei.zengshuyu.ui.activity.MainActivity;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/*
 *@Auther:吴亦凡的小可爱
 *@Date: 2019/7/9
 *@Time: 09:38:04
 *@Description:
 * */
public class RegisterModel implements RegisterContract.RegisterModel {
    @Override
    public void requestRegister(Context context, String userName, String userPwd, final RegisterCallBack registerCallBack) {
        //请求网络
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        //获取参数内容
        FormBody formBody = new FormBody.Builder()
                .add("phone", userName)
                .add("pwd", userPwd)
                .build();
        //请求接口
        Request request = new Request.Builder()
                .url(Constant.REGISTER_URL)
                .post(formBody)
                .build();
            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    registerCallBack.getData(e.getMessage());
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    String string = response.body().string();
                    registerCallBack.getData(string);
                }
            });
    }
}
