package com.bawei.zengshuyu.di.contract;

import android.content.Context;

/*
 *@Auther:曾淑雨
 *@Date: 2019/7/9
 *@Time: 09:36:12
 *@Description:契约接口
 * */
public interface RegisterContract {
    /*
     * v层
     * */
    public interface RegisterView{
        public void showRegister(String string);
    }
    /*
     * p层
     * */
    public interface RegisterPresenter{
        public void attachView();
        public void detachView();
    }
    /*
     * m层
     * */
    public interface RegisterModel{
       public void requestRegister(Context context, String userName, String userPwd, RegisterCallBack registerCallBack);
        public interface RegisterCallBack{
            public void getData(String string);
        }
    }
}
