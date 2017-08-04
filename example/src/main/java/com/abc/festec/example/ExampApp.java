package com.abc.festec.example;

import android.app.Application;

import com.abc.latte.app.Latte;
import com.abc.latte.ec.icon.FontEcModule;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * Created by admin on 2017/7/23.
 */

public class ExampApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
            Latte
                .init(this)
                .withApiHost("http://blog.csdn.net/carson_ho/article/details/73732076/")
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                 .configure();
    }
}


