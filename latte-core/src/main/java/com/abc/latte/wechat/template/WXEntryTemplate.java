package com.abc.latte.wechat.template;

import com.abc.latte.activitys.ProxyActivity;
import com.abc.latte.delegate.LetteDelegate;
import com.abc.latte.wechat.BaseWXEntryActivity;
import com.abc.latte.wechat.LatteWeChat;

/**
 * Created by admin on 2017/9/24.
 */


public class WXEntryTemplate extends BaseWXEntryActivity {

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {
       LatteWeChat.getInstance().getSignInCallback().onSignInSuccess(userInfo);
    }


}
