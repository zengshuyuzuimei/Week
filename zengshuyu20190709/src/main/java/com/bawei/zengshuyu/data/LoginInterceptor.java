package com.bawei.zengshuyu.data;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/*
 *@Auther:吴亦凡的小可爱
 *@Date: 2019/7/9
 *@Time: 15:28:57
 *@Description:
 * */
public class LoginInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        String method = request.method();
        Log.e("aaaa",method);
        Response response = chain.proceed(request);
        int code = response.code();
        Log.e("aaa",""+code);
        return response;
    }
}
