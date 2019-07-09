package com.bawei.zengshuyu.di.contract;

import android.content.Context;

/*
 *@Auther:曾淑雨
 *@Date: 2019/7/9
 *@Time: 09:14:21
 *@Description:契约接口
 * */
public interface ShowContract {
    /*
    * v层
    * */
    public interface ShowView{
        public void showLogin();
    }
    /*
    * p层
    * */
    public interface ShowPresenter{
        public void attachView();
        public void detachView();
    }
    /*
    * m层
    * */
    public interface ShowModel{
        public void requestLogin(ShowCallBack showCallBack);
        public interface ShowCallBack{
            public void getData();
        }
    }
}
