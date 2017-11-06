package com.abc.latte.Util.timer;

import java.util.TimerTask;

/**
 * Created by admin on 2017/8/9.
 */

public class BaseTimeTask extends TimerTask {
    private ITimerListener mITimerListener;

    public BaseTimeTask(ITimerListener mITimerListener) {
        this.mITimerListener = mITimerListener;
    }

    @Override
    public void run() {
        if (null != mITimerListener) {
            mITimerListener.onTimer();
        }
    }
}
