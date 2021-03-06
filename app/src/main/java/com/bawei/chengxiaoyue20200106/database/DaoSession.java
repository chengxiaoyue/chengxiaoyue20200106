package com.bawei.chengxiaoyue20200106.database;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.bawei.chengxiaoyue20200106.dao.LeftTable;
import com.bawei.chengxiaoyue20200106.dao.RightTable;

import com.bawei.chengxiaoyue20200106.database.LeftTableDao;
import com.bawei.chengxiaoyue20200106.database.RightTableDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig leftTableDaoConfig;
    private final DaoConfig rightTableDaoConfig;

    private final LeftTableDao leftTableDao;
    private final RightTableDao rightTableDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        leftTableDaoConfig = daoConfigMap.get(LeftTableDao.class).clone();
        leftTableDaoConfig.initIdentityScope(type);

        rightTableDaoConfig = daoConfigMap.get(RightTableDao.class).clone();
        rightTableDaoConfig.initIdentityScope(type);

        leftTableDao = new LeftTableDao(leftTableDaoConfig, this);
        rightTableDao = new RightTableDao(rightTableDaoConfig, this);

        registerDao(LeftTable.class, leftTableDao);
        registerDao(RightTable.class, rightTableDao);
    }
    
    public void clear() {
        leftTableDaoConfig.clearIdentityScope();
        rightTableDaoConfig.clearIdentityScope();
    }

    public LeftTableDao getLeftTableDao() {
        return leftTableDao;
    }

    public RightTableDao getRightTableDao() {
        return rightTableDao;
    }

}
