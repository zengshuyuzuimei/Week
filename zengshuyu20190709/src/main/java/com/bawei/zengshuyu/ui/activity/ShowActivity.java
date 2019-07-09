package com.bawei.zengshuyu.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.zengshuyu.R;
import com.bawei.zengshuyu.data.net.MessageEvent;
import com.bawei.zengshuyu.di.contract.ShowContract;
import com.bawei.zengshuyu.di.presenter.ShowPresenter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShowActivity extends BaseActivity<ShowContract.ShowView, ShowPresenter<ShowContract.ShowView>> implements ShowContract.ShowView {

    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.scan)
    ImageView scan;
    @BindView(R.id.btn)
    Button btn;

    @Override
    public void showLogin() {

    }

    @Override
    protected void initData() {
        Bitmap image = CodeUtils.createImage("zsy", 200, 200, null);
        scan.setImageBitmap(image);
        scan.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(ShowActivity.this, "zsy", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getMsg(MessageEvent event) {
        phone.setText("手机号是:"+event.getPhone());
        Glide.with(this).load(event.getHeadPic())
                .placeholder(R.mipmap.hhh)
                .error(R.mipmap.hhh)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .into(img);
    }

    @Override
    protected ShowPresenter<ShowContract.ShowView> createPresenter() {
        return new ShowPresenter<>();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_show;
    }

}
