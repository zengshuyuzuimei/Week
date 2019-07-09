package com.bawei.zengshuyu.di.presenter;

import java.lang.ref.WeakReference;

/*
 *@Auther:曾淑雨
 *@Date: 2019/7/9
 *@Time: 09:17:23
 *@Description:封装p层
 * */
public class BasePresenter<V> {

    private WeakReference<V> weakReference;
    //绑定方法
    public void attachView(V v){
        weakReference = new WeakReference<>(v);
    }
    //获取视图
    public V getView(){
        return weakReference.get();
    }
    //解绑方法
    public void detachView(){
        weakReference.clear();
    }
}
