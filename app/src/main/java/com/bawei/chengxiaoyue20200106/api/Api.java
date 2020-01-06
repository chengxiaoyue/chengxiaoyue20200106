package com.bawei.chengxiaoyue20200106.api;

import com.bawei.chengxiaoyue20200106.bean.LeftBean;
import com.bawei.chengxiaoyue20200106.bean.RightBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * date:2020/1/6
 * author:程小越
 * function:
 */
public interface Api {
    @GET("baweiapi/category")
    Observable<LeftBean> getLeftData();

    @GET("baweiapi/shopByCategory?category=生活")
    Observable<RightBean> getRightData(@Query("category") String category);
}
