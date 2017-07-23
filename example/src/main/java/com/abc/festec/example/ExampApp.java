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
        Latte.init(this).withIcon(new FontAwesomeModule()).withIcon(new FontEcModule()).configure();
    }
}


