package com.bawei.chengxiaoyue20200106.model;

import com.bawei.chengxiaoyue20200106.bean.LeftBean;
import com.bawei.chengxiaoyue20200106.bean.RightBean;
import com.bawei.chengxiaoyue20200106.contract.IContract;
import com.bawei.chengxiaoyue20200106.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * date:2020/1/6
 * author:程小越
 * function:
 */
public class ModelImpl implements IContract.IModel {
    @Override
    public void onLeftData(IContract.MyCallBack callBack) {
        NetUtil.getInstance().getApi().getLeftData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LeftBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LeftBean leftBean) {
                        callBack.onLeftSuccess(leftBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onLeftError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onRightData(String category, IContract.MyCallBack callBack) {
        NetUtil.getInstance().getApi().getRightData(category)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RightBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RightBean rightBean) {
                        callBack.onRightSuccess(rightBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onRightError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
