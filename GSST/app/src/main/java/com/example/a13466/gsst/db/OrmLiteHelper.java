package com.example.a13466.gsst.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class OrmLiteHelper extends OrmLiteSqliteOpenHelper {
    private static final String TABLE_NAME = "orm_lite";
    private static OrmLiteHelper ormLiteHelper;
    private Map<String,Dao> daos = new HashMap<>();
    private OrmLiteHelper(Context context) {
        super(context, TABLE_NAME,null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try{
            TableUtils.createTable(connectionSource,Table.class);//创建表
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

    }

    public static OrmLiteHelper getOrmLiteHelper(Context context) {
        if (ormLiteHelper == null) {
            synchronized (OrmLiteHelper.class){
                if (ormLiteHelper == null) {
                    ormLiteHelper = new OrmLiteHelper(context.getApplicationContext());
                }
            }
        }
        return ormLiteHelper;
    }

    public synchronized Dao getDaos(Class cs) throws SQLException {
        Dao dao = null;
        String className = cs.getSimpleName();
        if (daos.containsKey(className)){
            dao = daos.get(className);
        }
        if (dao == null){
            dao =super.getDao(cs);
            daos.put(className,dao);
        }
        return dao;
    }

    @Override
    public void close() {
        super.close();
        for (String key : daos.keySet()){
            Dao dao = daos.get(key);
            dao = null;
        }
    }
}
