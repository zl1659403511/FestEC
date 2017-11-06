package com.abc.latte.ui.launcher;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

/**
 * Created by admin on 2017/8/10.
 */

public class LauncherHolderCreator implements CBViewHolderCreator<LauncerHolder> {

    @Override
    public LauncerHolder createHolder() {
        return new LauncerHolder();
    }
}
