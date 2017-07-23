package com.abc.festec.example;

import android.app.Application;

import com.abc.latte.app.Latte;

/**
 * Created by admin on 2017/7/23.
 */

public class ExampApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this).configure();
    }
}


