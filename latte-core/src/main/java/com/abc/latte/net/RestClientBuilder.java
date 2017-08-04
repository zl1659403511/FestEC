package com.abc.latte.net;


import android.content.Context;
import android.widget.RelativeLayout;

import com.abc.latte.R;
import com.abc.latte.net.callback.IError;
import com.abc.latte.net.callback.IFailure;
import com.abc.latte.net.callback.IRequest;
import com.abc.latte.net.callback.ISuccess;
import com.abc.latte.ui.LoaderStyle;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * Created by admin on 2017/7/29.
 */

public class RestClientBuilder {
    private String mUrl;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private String mDownloadDir;
    private  String mExtension;
    private  String mName;
    private IRequest mIRequest;
    private ISuccess mISuccess;
    private IFailure mIFailure;
    private IError mIErroe;
    private RequestBody mBody;
    private  LoaderStyle mLoaderStyle;
    private  Context mContext;
    private File mFile;

    public RestClientBuilder loader(LoaderStyle mLoaderStyle, Context mContext) {
        this.mLoaderStyle = mLoaderStyle;
        this.mContext = mContext;
        return this;
    }
 public RestClientBuilder loader(Context mContext) {
        this.mLoaderStyle = LoaderStyle.BallClipRotatePulseIndicator;
        this.mContext = mContext;
        return this;
    }

    RestClientBuilder() {

    }
    public final RestClientBuilder dir(String downloadDir) {
        this.mDownloadDir = downloadDir;
        return this;
    }
    public final RestClientBuilder extension(String extension) {
        this.mExtension = extension;
        return this;
    }
    public final RestClientBuilder name(String name) {
        this.mName = name;
        return this;
    }
    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }
    public final RestClientBuilder file(File file) {
       this.mFile=file;
        return this;
    }
    public final RestClientBuilder file(String filePath) {
        this.mFile=new File(filePath);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {

        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);//不懂
        return this;
    }

    public final RestClientBuilder success(ISuccess iSuccess) {
        this.mISuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure) {
        this.mIFailure = iFailure;
        return this;
    }

    public final RestClientBuilder error(IError iError) {
        this.mIErroe = iError;
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest) {
        this.mIRequest = iRequest;
        return this;
    }

    public final RestClient build() {
        return new RestClient(mUrl, PARAMS, mDownloadDir,mExtension,mName,mIRequest, mISuccess, mIFailure, mIErroe, mBody,mFile,mLoaderStyle,mContext);
    }

}
