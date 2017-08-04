package com.abc.latte.ui;

import android.content.Context;

import com.wang.avi.AVLoadingIndicatorView;
import com.wang.avi.Indicator;

import java.util.WeakHashMap;

import retrofit2.Call;

/**
 * Created by admin on 2017/7/30.
 */

public class LoaderCreator {
    private static final WeakHashMap<String, Indicator> LOADING_MAP = new WeakHashMap();

    static AVLoadingIndicatorView create(String type, Context context) {
        AVLoadingIndicatorView avLoadingIndicatorView = new AVLoadingIndicatorView(context);
        if (null == LOADING_MAP.get(type)) {  //         final Indicator indicator=
            final Indicator indicator = getIndicator(type);
            LOADING_MAP.put(type, indicator);
        }
        avLoadingIndicatorView.setIndicator(LOADING_MAP.get(type));
        return avLoadingIndicatorView;
    }

    private static Indicator getIndicator(String name) {
        if (null == name || name.isEmpty()) {
            return null;
        }
        final StringBuffer drawableClassName = new StringBuffer();
        if (!name.contains(".")) {
            final String defaultPackName = AVLoadingIndicatorView.class.getPackage().getName();
            drawableClassName.append(defaultPackName)
                    .append(".indicators")
                    .append(".");
        }
        drawableClassName.append(name);
        try {
            final Class<?> drewableClass = Class.forName(drawableClassName.toString());
            return ((Indicator) drewableClass.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
