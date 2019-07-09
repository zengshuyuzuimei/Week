package com.bawei.zengshuyu.di.presenter;

import android.content.Context;

import com.bawei.zengshuyu.di.contract.RegisterContract;
import com.bawei.zengshuyu.di.model.RegisterModel;

/*
 *@Auther:吴亦凡的小可爱
 *@Date: 2019/7/9
 *@Time: 09:38:23
 *@Description:
 * */
public class RegisterPresenter<V extends RegisterContract.RegisterView> extends BasePresenter<V>{

    private final RegisterContract.RegisterModel model;

    public RegisterPresenter() {
        model = new RegisterModel();

    }

    public void Register(Context context, String userName, String userPwd) {
        model.requestRegister(context,userName,userPwd, new RegisterContract.RegisterModel.RegisterCallBack() {
            @Override
            public void getData(String string) {
                getView().showRegister(string);
            }
        });
    }
}
