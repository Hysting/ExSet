package com.roro.debugdemo;

import android.app.Application;
import android.util.Log;

import com.facebook.stetho.Stetho;

/**
 * Created by roro on 2015/7/2.
 */
public class MyApplication extends Application {

    private static final String TAG = "MyApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG,"onCreate()");
    }
}
