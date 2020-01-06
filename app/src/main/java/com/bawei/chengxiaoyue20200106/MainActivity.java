package com.bawei.chengxiaoyue20200106;

import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.chengxiaoyue20200106.adapter.LeftAdapter;
import com.bawei.chengxiaoyue20200106.adapter.RightAdapter;
import com.bawei.chengxiaoyue20200106.base.BaseActivity;
import com.bawei.chengxiaoyue20200106.base.BasePresenter;
import com.bawei.chengxiaoyue20200106.bean.LeftBean;
import com.bawei.chengxiaoyue20200106.bean.RightBean;
import com.bawei.chengxiaoyue20200106.dao.RightTable;
import com.bawei.chengxiaoyue20200106.database.DaoMaster;
import com.bawei.chengxiaoyue20200106.database.DaoSession;
import com.bawei.chengxiaoyue20200106.database.LeftTableDao;
import com.bawei.chengxiaoyue20200106.database.RightTableDao;
import com.bawei.chengxiaoyue20200106.presenter.PresenterImpl;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @BindView(R.id.left_recy)
    RecyclerView leftRecy;
    @BindView(R.id.right_recy)
    RecyclerView rightRecy;
    private LeftAdapter leftAdapter;
    private LeftTableDao leftTableDao;
    private RightTableDao rightTableDao;


    @Override
    protected void initData() {
        DaoSession daoSession = DaoMaster.newDevSession(this, "cxy,db");
        leftTableDao = daoSession.getLeftTableDao();
        rightTableDao = daoSession.getRightTableDao();
        presenter.onLeftData();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onLeftSuccess(LeftBean leftBean) {
        List<LeftBean> category = leftBean.getCategory();
        leftAdapter = new LeftAdapter(category,this);
        leftRecy.setAdapter(this.leftAdapter);
        leftRecy.setLayoutManager(new LinearLayoutManager(this));
        this.leftAdapter.setItemClick(new LeftAdapter.ItemClick() {
            @Override
            public void setItemClick(int position) {
                EventBus.getDefault().post(MainActivity.this.leftAdapter);
            }
        });
    }

   @Override
    public void onLeftError(Throwable throwable) {

    }

    @Override
    public void onRightSuccess(RightBean rightBean) {
        List<RightBean.DataBean> data = rightBean.getData();
        RightAdapter rightAdapter = new RightAdapter(data, this);
        rightRecy.setAdapter(rightAdapter);
        rightRecy.setLayoutManager(new GridLayoutManager(this,2));
        rightTableDao.deleteAll();
    }
//    public void leftDatabase(){
//        RightTable rightTable = rightTableDao.queryBuilder().unique();
//        String rightJson = rightTable.getRightDatabase();
//        RightBean rightBean = new Gson().fromJson(rightJson, RightBean.class);
//        List<RightBean.DataBean> data = rightBean.getData();
//        RightAdapter rightAdapter = new RightAdapter(data, this);
//        rightRecy.setAdapter(rightAdapter);
//        rightRecy.setLayoutManager(new GridLayoutManager(this,2));
//    }
    @Override
    public void onRightError(Throwable throwable) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe
    public void hhh(String category){
         presenter.onRightData(category);
    }
}
