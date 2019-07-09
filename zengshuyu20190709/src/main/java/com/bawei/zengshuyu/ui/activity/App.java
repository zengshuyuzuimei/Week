package com.bawei.zengshuyu.ui.activity;

import android.app.Application;

import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/*
 *@Auther:吴亦凡的小可爱
 *@Date: 2019/7/9
 *@Time: 11:19:59
 *@Description:
 * */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ZXingLibrary.initDisplayOpinion(this);
    }
}
