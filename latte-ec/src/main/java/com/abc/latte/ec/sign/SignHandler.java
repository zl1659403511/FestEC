package com.abc.latte.ec.sign;

import com.abc.latte.app.AccountManager;
import com.abc.latte.ec.database.DataBaseManager;
import com.abc.latte.ec.database.UserProfile;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by admin on 2017/9/24.
 */

public class SignHandler {
    public static void onSingUp(String response, ISignListener iSignListener) {
        final JSONObject profielJson = JSON.parseObject(response).getJSONObject("data");
        final long userId = profielJson.getLong("userId");
        final String name = profielJson.getString("name");
        final String avatar = profielJson.getString("avatar");
        final String gender = profielJson.getString("gender");
        final String address = profielJson.getString("address");
        final UserProfile userProfile = new UserProfile(userId, name, avatar, gender, address);
        DataBaseManager.getInstance().getDao().insertOrReplace(userProfile);
        AccountManager.setSignState(true);
        iSignListener.onSignUpSuccess();
    }

    public static void onSignIn(String response, ISignListener iSignListener) {
        final JSONObject profielJson = JSON.parseObject(response).getJSONObject("data");
        final long userId = profielJson.getLong("userId");
        final String name = profielJson.getString("name");
        final String avatar = profielJson.getString("avatar");
        final String gender = profielJson.getString("gender");
        final String address = profielJson.getString("address");
        final UserProfile userProfile = new UserProfile(userId, name, avatar, gender, address);
        DataBaseManager.getInstance().getDao().insertOrReplace(userProfile);
        AccountManager.setSignState(true);
        iSignListener.onSignInSuccess();
    }
}
