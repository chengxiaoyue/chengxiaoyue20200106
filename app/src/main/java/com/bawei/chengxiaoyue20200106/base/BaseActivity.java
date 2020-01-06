package com.bawei.chengxiaoyue20200106.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.chengxiaoyue20200106.contract.IContract;

import butterknife.ButterKnife;

/**
 * date:2020/1/6
 * author:程小越
 * function:
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IContract.IView {
    public P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        presenter = initPresenter();
        if (presenter != null) {
            presenter.onAttch(this);
        }
        ButterKnife.bind(this);
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P initPresenter();

    protected abstract int layoutId();

    //内存泄漏
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDeAttch();
    }
}
