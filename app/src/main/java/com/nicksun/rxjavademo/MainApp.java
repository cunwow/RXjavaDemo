package com.nicksun.rxjavademo;

import android.app.Application;

import utils.Utils;

/**
 * Created by nick on 2017/9/11.
 */

public class MainApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.setsAppContext(this);
    }
}
