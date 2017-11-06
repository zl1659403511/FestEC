package com.abc.festec.example.event;

import com.abc.latte.Util.log.LatteLogger;
import com.abc.latte.delegate.web.event.Event;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


public class ShareEvent extends Event {

    @Override
    public String execute(String params) {

        LatteLogger.json("ShareEvent", params);

        final JSONObject object = JSON.parseObject(params).getJSONObject("params");
        final String title = object.getString("title");
        final String url = object.getString("url");
        final String imageUrl = object.getString("imageUrl");
        final String text = object.getString("text");

      /*  ShareSDK.initSDK(getContext());
        final OnekeyShare oks = new OnekeyShare();
        oks.disableSSOWhenAuthorize();
        oks.setTitle(title);
        oks.setText(text);
        oks.setImageUrl(imageUrl);
        oks.setUrl(url);
        oks.show(getContext());*/

        return null;
    }
}
