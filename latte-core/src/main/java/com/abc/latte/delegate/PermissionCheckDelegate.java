package com.abc.latte.delegate;

/**
 * Created by admin on 2017/7/23.
 */

public abstract class PermissionCheckDelegate extends BaseDelegate {
    public <T extends LetteDelegate> T getParentDelegate()
    {
        return (T) getParentFragment();
    }
}
