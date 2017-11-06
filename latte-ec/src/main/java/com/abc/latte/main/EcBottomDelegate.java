package com.abc.latte.main;

import android.graphics.Color;

import com.abc.latte.delegate.bottom.BaseBottomDelegate;
import com.abc.latte.delegate.bottom.BottomItemDelegate;
import com.abc.latte.delegate.bottom.BottomTabBean;
import com.abc.latte.delegate.bottom.ItemBuilder;
import com.abc.latte.main.discover.DiscoverDelegate;
import com.abc.latte.main.index.IndexDelegate;
import com.abc.latte.main.sort.SortDelegate;

import java.util.LinkedHashMap;

/**
 * Created by admin on 2017/9/25.
 */

public class EcBottomDelegate extends BaseBottomDelegate {
    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}", "主页"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}", "分类"), new SortDelegate());
        items.put(new BottomTabBean("{fa-compass}", "发现"), new DiscoverDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}", "购物车"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-user}", "我的"), new IndexDelegate());
        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
