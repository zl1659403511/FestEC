package com.abc.festec.example;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.abc.latte.delegate.LetteDelegate;

import butterknife.BindView;

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

    }
}
