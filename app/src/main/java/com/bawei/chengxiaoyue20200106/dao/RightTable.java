package com.bawei.chengxiaoyue20200106.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * date:2020/1/6
 * author:程小越
 * function:
 */
@Entity
public class RightTable {
    private String RightDatabase;

    @Generated(hash = 120930811)
    public RightTable(String RightDatabase) {
        this.RightDatabase = RightDatabase;
    }

    @Generated(hash = 683407862)
    public RightTable() {
    }

    public String getRightDatabase() {
        return this.RightDatabase;
    }

    public void setRightDatabase(String RightDatabase) {
        this.RightDatabase = RightDatabase;
    }
}
