package com.bawei.zengshuyu.di.presenter;

import android.content.Context;

import com.bawei.zengshuyu.di.contract.Contract;
import com.bawei.zengshuyu.di.model.Model;

/*
 *@Auther:曾淑雨
 *@Date: 2019/7/9
 *@Time: 09:18:42
 *@Description:实现逻辑
 * */
public class Presenter<V extends Contract.View> extends BasePresenter<V>{

    private final Contract.Model model;

    public Presenter() {
        model = new Model();
    }

    public void Login(Context context, String name, String pwd) {
        model.requestLogin(context, name, pwd, new Contract.Model.LoginCallBack() {
            @Override
            public void getData(String string) {
                getView().showLogin(string);
            }
        });
    }
}
