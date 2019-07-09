package com.bawei.zengshuyu.di.presenter;

import com.bawei.zengshuyu.di.contract.ShowContract;
import com.bawei.zengshuyu.di.model.ShowModel;

/*
 *@Auther:吴亦凡的小可爱
 *@Date: 2019/7/9
 *@Time: 10:36:11
 *@Description:
 * */
public class ShowPresenter<V extends ShowContract.ShowView> extends BasePresenter<V>{

    private final ShowContract.ShowModel model;

    public ShowPresenter() {
        model = new ShowModel();
    }
}
