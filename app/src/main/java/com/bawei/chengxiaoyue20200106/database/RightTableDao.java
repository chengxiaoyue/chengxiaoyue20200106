package com.bawei.chengxiaoyue20200106.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.bawei.chengxiaoyue20200106.dao.RightTable;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "RIGHT_TABLE".
*/
public class RightTableDao extends AbstractDao<RightTable, Void> {

    public static final String TABLENAME = "RIGHT_TABLE";

    /**
     * Properties of entity RightTable.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property RightDatabase = new Property(0, String.class, "RightDatabase", false, "RIGHT_DATABASE");
    }


    public RightTableDao(DaoConfig config) {
        super(config);
    }
    
    public RightTableDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"RIGHT_TABLE\" (" + //
                "\"RIGHT_DATABASE\" TEXT);"); // 0: RightDatabase
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"RIGHT_TABLE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, RightTable entity) {
        stmt.clearBindings();
 
        String RightDatabase = entity.getRightDatabase();
        if (RightDatabase != null) {
            stmt.bindString(1, RightDatabase);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, RightTable entity) {
        stmt.clearBindings();
 
        String RightDatabase = entity.getRightDatabase();
        if (RightDatabase != null) {
            stmt.bindString(1, RightDatabase);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public RightTable readEntity(Cursor cursor, int offset) {
        RightTable entity = new RightTable( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0) // RightDatabase
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, RightTable entity, int offset) {
        entity.setRightDatabase(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(RightTable entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(RightTable entity) {
        return null;
    }

    @Override
    public boolean hasKey(RightTable entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}