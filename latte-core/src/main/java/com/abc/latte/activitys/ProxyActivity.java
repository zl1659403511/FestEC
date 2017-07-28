package com.abc.latte.activitys;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;
import android.util.Log;

import com.abc.latte.R;
import com.abc.latte.delegate.LetteDelegate;

import me.yokeyword.fragmentation.BuildConfig;
import me.yokeyword.fragmentation.Fragmentation;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by admin on 2017/7/23.
 */

public abstract class ProxyActivity extends SupportActivity {
      public abstract LetteDelegate setRootDelegate();

   /* @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }*/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

    private void initContainer(@Nullable Bundle savedInstanceState){
      final   ContentFrameLayout container = new ContentFrameLayout(this);
         container.setId(R.id.delegate_container);
        super.setContentView(container);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.delegate_container,setRootDelegate());

        }
    }

    /**
     * 单activity 框架 activity 退出 即应用退出 释放资源
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }
}
