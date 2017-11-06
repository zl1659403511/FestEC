package com.abc.latte.ec.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.abc.latte.Util.storage.LattePreference;
import com.abc.latte.Util.timer.BaseTimeTask;
import com.abc.latte.Util.timer.ITimerListener;
import com.abc.latte.app.AccountManager;
import com.abc.latte.app.IUserChecker;
import com.abc.latte.delegate.LetteDelegate;
import com.abc.latte.ec.R;
import com.abc.latte.ec.R2;
import com.abc.latte.ui.launcher.ILauncherListener;
import com.abc.latte.ui.launcher.OnLauncherFinishTag;
import com.abc.latte.ui.launcher.ScrollLaunchTag;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by admin on 2017/8/9.
 */

public class LauncherDelegate extends LetteDelegate implements ITimerListener {
    @BindView(R2.id.tv_launcher_timer)
    TextView mTvTimer;
    private Timer mTimer;
    private int mCount = 5;
    private  ILauncherListener mILauncherListener=null;

    @OnClick(R2.id.tv_launcher_timer)
    void onClickTimerView() {
        if (null != mTimer) {
            mTimer.cancel();
            mTimer = null;
            checkIsShowScroll();
        }
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ILauncherListener) {
            mILauncherListener = (ILauncherListener) activity;
        }
    }
    /**
     * 倒计时
     */
    private void initTimer() {
        mTimer = new Timer();
        final BaseTimeTask tast = new BaseTimeTask(this);
        mTimer.schedule(tast, 0, 1000);
    }

    @Override
    public Object setLayout() {
        return R.layout.delegrate_launcher;
    }

    @Override
    public void onBindView(Bundle savedInstanceState, View rootView) {
        initTimer();
    }

    //判断是否显示启动页
    private void checkIsShowScroll() {
        if (!LattePreference.getAppFlag(ScrollLaunchTag.HAS_FIRST_LAUNCHER_APP.name())) {
            start(new LauncherScrollDelegrate(),SINGLETASK);
        }else {
            //检查用户是否登录app
            AccountManager.checkAccount(new IUserChecker() {
                @Override
                public void onSignIn() {
                    if (mILauncherListener != null) {
                        mILauncherListener.onLauncherFinish(OnLauncherFinishTag.SIGNED);
                    }
                }
                @Override
                public void onNoSignIn() {
                    if (mILauncherListener != null) {
                        mILauncherListener.onLauncherFinish(OnLauncherFinishTag.NOT_SIGNED);
                    }
                }
            });
        }
    }

    @Override
    public void onTimer() {
        getProxyActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (null != mTvTimer) {
                    mTvTimer.setText(MessageFormat.format("跳过\n{0}s", mCount));
                    mCount--;
                    if (mCount < 0) {
                        if (null != mTimer) {
                            mTimer.cancel();
                            mTimer = null;
                            checkIsShowScroll();
                        }
                    }
                }
            }
        });
    }
}
