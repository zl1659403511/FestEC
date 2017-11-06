package com.abc.festec.example;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.abc.latte.delegate.LetteDelegate;
import com.abc.latte.net.RestClient;
import com.abc.latte.net.callback.IError;
import com.abc.latte.net.callback.IFailure;
import com.abc.latte.net.callback.ISuccess;

/**
 * Created by admin on 2017/7/23.
 */

public class ExampleDelegate extends LetteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(Bundle savedInstanceState, View rootView) {
        testRestClient();
    }

    private void testRestClient() {
        RestClient.builder()
                .url("http://127.0.0.1/index")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String resonse) {
                        Toast.makeText(getContext(), resonse, Toast.LENGTH_LONG).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .build()
                .get();
    }
}
