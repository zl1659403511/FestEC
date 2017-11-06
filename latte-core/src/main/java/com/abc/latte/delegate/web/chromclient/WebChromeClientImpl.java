package com.abc.latte.delegate.web.chromclient;

import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;



public class WebChromeClientImpl extends WebChromeClient {

    @Override
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        return super.onJsAlert(view, url, message, result);
    }
}
