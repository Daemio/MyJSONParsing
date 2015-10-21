package com.example.damian.myjsonparsing;

import android.app.Application;

import com.example.damian.myjsonparsing.database.HelperFactory;

/**
 * Created by Admin on 20.10.2015.
 */
public class TheApplication extends Application {

    private static TheApplication instance;

    public static TheApplication getInstance() {
        return instance;
    }

    @Override
    public void onTerminate() {
        HelperFactory.releaseHelper(); //close DB
        super.onTerminate();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        HelperFactory.setHelper(getApplicationContext()); //open dbHelper
        instance = this;
    }
}