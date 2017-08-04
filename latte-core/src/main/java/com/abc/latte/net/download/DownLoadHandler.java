package com.abc.latte.net.download;

import android.os.AsyncTask;

import com.abc.latte.net.RestCreator;
import com.abc.latte.net.callback.IError;
import com.abc.latte.net.callback.IFailure;
import com.abc.latte.net.callback.IRequest;
import com.abc.latte.net.callback.ISuccess;

import java.util.WeakHashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/8/3.
 */

public class DownLoadHandler {
    private final String URL;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final String DOWNLOAD_DIR;
    private final String EXTENSION;
    private final String NAME;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROE;

    public DownLoadHandler(
            String url,
            IRequest request,
            String download_dir,
            String extension,
            String name,
            ISuccess success,
            IFailure failure,
            IError erroe) {
        this.URL = url;
        this.REQUEST = request;
        this.DOWNLOAD_DIR = download_dir;
        this.EXTENSION = extension;
        this.NAME = name;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROE = erroe;
    }


    public final void handleDownLoad() {
        if (REQUEST!=null) {
            REQUEST.onRequestStart();
        }
        RestCreator.getRestService()
                .download(URL,PARAMS)
        .enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    final ResponseBody body = response.body();
                    final SaveFileTask task = new SaveFileTask(REQUEST, SUCCESS);
                    task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,DOWNLOAD_DIR,EXTENSION,body,NAME);
                    //这里一定要注意判断，否则文件下载不全
                    if (task.isCancelled()) {
                        if (null!=REQUEST) {
                            REQUEST.onRequestEnd();
                        }
                    }
                }else {
                    if (null!=ERROE) {
                        ERROE.onError(response.code(),response.message());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (null!=FAILURE) {
                    FAILURE.onFailure();
                }
            }
        });
    }
}
