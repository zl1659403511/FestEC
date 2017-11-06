package com.abc.latte.delegate.web.event;


import com.abc.latte.Util.log.LatteLogger;

/**
 * Created by 傅令杰
 */

public class UndefineEvent extends Event {
    @Override
    public String execute(String params) {
        LatteLogger.e("UndefineEvent", params);
        return null;
    }
}
