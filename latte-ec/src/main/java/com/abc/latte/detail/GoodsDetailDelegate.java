package com.abc.latte.detail;

import android.os.Bundle;
import android.view.View;

import com.abc.latte.delegate.LetteDelegate;
import com.abc.latte.ec.R;

/**
 * Created by Administrator on 2017/10/20.
 */

public class GoodsDetailDelegate extends LetteDelegate{
    public static GoodsDetailDelegate create(){
        return new GoodsDetailDelegate();
    }
    @Override
    public Object setLayout() {
        return  R.layout.delegate_goods_detail;
    }

    @Override
    public void onBindView(Bundle savedInstanceState, View rootView) {

    }
}
