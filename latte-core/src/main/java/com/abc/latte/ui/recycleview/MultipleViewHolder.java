package com.abc.latte.ui.recycleview;

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by admin on 2017/10/15.
 */

public class MultipleViewHolder  extends BaseViewHolder {
    private MultipleViewHolder(View view) {
        super(view);
    }
    public static MultipleViewHolder create(View view) {
        return new MultipleViewHolder(view);
    }
}
