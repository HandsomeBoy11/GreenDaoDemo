package com.xrd.www.greendaodemo.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.xrd.www.greendaodemo.dao.DaoMaster;
import com.xrd.www.greendaodemo.dao.DaoSession;
import com.xrd.www.greendaodemo.dao.MyOpenHelper;

/**
 * Created by user on 2018/8/14.
 */

public class MyApp extends Application {

    private static MyApp instances;
    private MyOpenHelper helper;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        this.instances=this;
        helper = new MyOpenHelper(this, "user.db");
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }
    public static MyApp getInstances() {
        return instances;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
