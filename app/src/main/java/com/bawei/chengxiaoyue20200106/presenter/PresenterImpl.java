package com.bawei.chengxiaoyue20200106.presenter;

import com.bawei.chengxiaoyue20200106.base.BasePresenter;
import com.bawei.chengxiaoyue20200106.bean.LeftBean;
import com.bawei.chengxiaoyue20200106.bean.RightBean;
import com.bawei.chengxiaoyue20200106.contract.IContract;
import com.bawei.chengxiaoyue20200106.model.ModelImpl;

/**
 * date:2020/1/6
 * author:程小越
 * function:
 */
public class PresenterImpl extends BasePresenter {
    private ModelImpl model;

    @Override
    protected void initModel() {
        model = new ModelImpl();
    }

    @Override
    public void onLeftData() {
        model.onLeftData(new IContract.MyCallBack() {
            @Override
            public void onLeftSuccess(LeftBean leftBean) {
                getView().onLeftSuccess(leftBean);
            }

            @Override
            public void onLeftError(Throwable throwable) {
                getView().onLeftError(throwable);
            }

            @Override
            public void onRightSuccess(RightBean rightBean) {
                getView().onRightSuccess(rightBean);
            }

            @Override
            public void onRightError(Throwable throwable) {
                getView().onRightError(throwable);
            }
        });
    }

    @Override
    public void onRightData(String category) {
        model.onRightData(category, new IContract.MyCallBack() {
            @Override
            public void onLeftSuccess(LeftBean leftBean) {
                getView().onLeftSuccess(leftBean);
            }

            @Override
            public void onLeftError(Throwable throwable) {
                getView().onLeftError(throwable);
            }

            @Override
            public void onRightSuccess(RightBean rightBean) {
                getView().onRightSuccess(rightBean);
            }

            @Override
            public void onRightError(Throwable throwable) {
                getView().onRightError(throwable);
            }
        });
    }
}
