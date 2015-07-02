package com.roro.debugdemo;

import android.util.Log;

import com.facebook.stetho.Stetho;

/**
 * Created by roro on 2015/7/2.
 */
public class DebugApplication extends MyApplication {

    private static final String TAG = "DebugApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());
        Log.e(TAG,"onCreate");
    }
}
