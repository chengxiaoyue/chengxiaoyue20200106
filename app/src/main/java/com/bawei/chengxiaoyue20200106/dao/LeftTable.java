package com.bawei.chengxiaoyue20200106.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * date:2020/1/6
 * author:程小越
 * function:
 */
@Entity
public class LeftTable {
    private String LeftDatabase;

    @Generated(hash = 1042838193)
    public LeftTable(String LeftDatabase) {
        this.LeftDatabase = LeftDatabase;
    }

    @Generated(hash = 1059050434)
    public LeftTable() {
    }

    public String getLeftDatabase() {
        return this.LeftDatabase;
    }

    public void setLeftDatabase(String LeftDatabase) {
        this.LeftDatabase = LeftDatabase;
    }
}
