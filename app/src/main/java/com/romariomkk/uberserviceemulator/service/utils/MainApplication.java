package com.romariomkk.uberserviceemulator.service.utils;

import android.app.Application;

import com.romariomkk.uberserviceemulator.service.RetrofitManager;

/**
 * Created by romariomkk on 10.02.2017.
 */
public class MainApplication extends Application {

    private static MainApplication INSTANCE;
    public static MainApplication getInstance(){
        return INSTANCE;
    }

    private RetrofitManager manager = new RetrofitManager();
    public RetrofitManager getRequestManager() {
        return manager;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

}
