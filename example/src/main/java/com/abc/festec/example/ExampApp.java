package com.abc.festec.example;

import android.app.Application;

import com.abc.festec.example.event.ShareEvent;
import com.abc.festec.example.event.TestEvent;
import com.abc.latte.app.Latte;
import com.abc.latte.ec.database.DataBaseManager;
import com.abc.latte.ec.icon.FontEcModule;
import com.abc.latte.net.interceptor.DebugInterceptor;
import com.abc.latte.net.rx.AddCookieInterceptor;
import com.facebook.stetho.Stetho;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by admin on 2017/7/23.
 */

public class ExampApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initLogger();
        initStetho();
        initDa();
        Latte
                .init(this)
                .withApiHost("http://952cloud.top/RestServer/api/")
                .withLoaderDelayed(1000)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withInterceptor(new DebugInterceptor("index", R.raw.test))
                .withWeChatAppId("你的微信AppKey")
                .withWeChatAppSecret("你的微信AppSecret")
                .withJavascriptInterface("latte")
                .withWebEvent("test", new TestEvent())
                .withWebEvent("share", new ShareEvent())
                //添加Cookie同步拦截器
                .withWebHost("https://www.baidu.com/")
                .withInterceptor(new AddCookieInterceptor())
                .configure();
    }

    /**
     * 初始化数据库，保存用户信息
     */
    private void initDa() {
        DataBaseManager.getInstance().init(this);
    }

    /**
     * 初始化Logger 日志
     */
    private void initLogger() {
        //log日志
        Logger.init("shequ")               // default tag : PRETTYLOGGER or use just init()
                .setMethodCount(3)            // default 2
                .hideThreadInfo()             // default it is shown
                .setLogLevel(LogLevel.FULL);
    }

    /**
     * Chrome 调试工具
     */
    private void initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(
                                Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(
                                Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }
}


