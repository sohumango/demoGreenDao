package com.example.demoapp;

import android.app.Application;

public class DemoApp extends Application {
    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();

//        mDaoSession = new DaoMaster(
//                new DaoMaster.DevOpenHelper(this, "greendao_demo.db").getWritableDb()).newSession();

        mDaoSession =
                new DaoMaster(new DbOpenHelper(this, "greendao_demo.db").getWritableDb()).newSession();

        // USER CREATION FOR DEMO PURPOSE
        if(mDaoSession.getUserDao().loadAll().size() == 0){
            mDaoSession.getUserDao().insert(new User(1L, "Janishar Ali","", ""));
        }
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}

