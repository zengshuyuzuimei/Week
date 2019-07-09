package com.bawei.zengshuyu.di.contract;

import android.content.Context;

/*
 *@Auther:曾淑雨
 *@Date: 2019/7/9
 *@Time: 09:14:21
 *@Description:契约接口
 * */
public interface Contract {
    /*
    * v层
    * */
    public interface View{
        public void showLogin(String string);
    }
    /*
    * p层
    * */
    public interface Presenter{
        public void attachView();
        public void detachView();
    }
    /*
    * m层
    * */
    public interface Model{
        public void requestLogin(Context context, String name, String pwd, LoginCallBack loginCallBack);
        public interface LoginCallBack{
            public void getData(String string);
        }
    }
}
