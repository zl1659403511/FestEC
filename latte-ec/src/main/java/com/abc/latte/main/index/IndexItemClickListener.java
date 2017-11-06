package com.abc.latte.main.index;

import android.view.View;

import com.abc.latte.delegate.LetteDelegate;
import com.abc.latte.detail.GoodsDetailDelegate;
import com.abc.latte.ui.recycleview.MultipleFields;
import com.abc.latte.ui.recycleview.MultipleItemEntity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;

/**
 * Created by Administrator on 2017/10/20.
 */

public class IndexItemClickListener extends SimpleClickListener {
    private final LetteDelegate DELEGATE;

    public IndexItemClickListener(LetteDelegate delegate) {
        DELEGATE = delegate;
    }

    public static IndexItemClickListener create(LetteDelegate delegate) {
        return new IndexItemClickListener(delegate);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        final MultipleItemEntity entity = (MultipleItemEntity) baseQuickAdapter.getData().get(position);
        final int goodsId = entity.getField(MultipleFields.ID);
        final GoodsDetailDelegate delegate = GoodsDetailDelegate.create();
        DELEGATE.getSupportDelegate().start(delegate);
    }

    @Override
    public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
