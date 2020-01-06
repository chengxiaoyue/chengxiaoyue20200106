package com.bawei.chengxiaoyue20200106.contract;

import com.bawei.chengxiaoyue20200106.bean.LeftBean;
import com.bawei.chengxiaoyue20200106.bean.RightBean;

/**
 * date:2020/1/6
 * author:程小越
 * function:
 */
public interface IContract {
    interface IModel {
        void onLeftData(MyCallBack callBack);

        void onRightData(String category, MyCallBack callBack);
    }

    interface IView {
        void onLeftSuccess(LeftBean leftBean);

        void onLeftError(Throwable throwable);

        void onRightSuccess(RightBean rightBean);

        void onRightError(Throwable throwable);
    }

    interface IPresenter {
        void onLeftData();

        void onRightData(String category);
    }

    interface MyCallBack {
        void onLeftSuccess(LeftBean leftBean);

        void onLeftError(Throwable throwable);

        void onRightSuccess(RightBean rightBean);

        void onRightError(Throwable throwable);
    }
}
