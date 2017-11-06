package com.abc.latte.main.sort;

import android.os.Bundle;
import android.view.View;

import com.abc.latte.delegate.bottom.BottomItemDelegate;
import com.abc.latte.ec.R;
import com.abc.latte.main.sort.content.ContentDelegate;
import com.abc.latte.main.sort.list.VerticalListDelegate;

/**
 * Created by Administrator on 2017/10/20.
 */

public class SortDelegate  extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_sort;
    }

    @Override
    public void onBindView(Bundle savedInstanceState, View rootView) {
        final VerticalListDelegate listDelegate = new VerticalListDelegate();
        getSupportDelegate().loadRootFragment(R.id.vertical_list_container, listDelegate);
        //设置右侧第一个分类显示，默认显示分类一
        getSupportDelegate().loadRootFragment(R.id.sort_content_container, ContentDelegate.newInstance(1));
    }
}
