package com.abc.latte.net.callback;

import android.os.Handler;

import com.abc.latte.ui.LatteLoader;
import com.abc.latte.ui.LoaderStyle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/7/30.
 */

public class RequestCallbacks implements Callback<String> {
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROE;
    private final LoaderStyle LOADE_STYLE;
    private static final Handler HANDLER = new Handler();

    public RequestCallbacks(IRequest request, ISuccess success, IFailure failure, IError erroe, LoaderStyle style) {
        REQUEST = request;
        SUCCESS = success;
        FAILURE = failure;
        ERROE = erroe;
        this.LOADE_STYLE = style;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (null != SUCCESS) {
                    SUCCESS.onSuccess(response.body());
                }
            }
        } else {
            if (null != ERROE) {
                ERROE.onError(response.code(), response.message());
            }
        }
        stopLoad();
    }

    private void stopLoad() {
        if (null != LOADE_STYLE) {
            HANDLER.postDelayed(new Runnable() {
                @Override
                public void run() {
                    LatteLoader.stopLoading();
                }
            }, 3000);
        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if (null != FAILURE) {
            FAILURE.onFailure();
        }
        if (null != REQUEST) {
            REQUEST.onRequestEnd();
        }
        stopLoad();
    }
}
