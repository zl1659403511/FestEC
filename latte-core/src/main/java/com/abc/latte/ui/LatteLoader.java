package com.abc.latte.ui;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.abc.latte.R;
import com.abc.latte.Util.dimen.DimenUtil;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

/**
 * Created by admin on 2017/7/30.
 */

public class LatteLoader {
    private static final int LOADER_SIZE_SCALLE = 8;
    private static final int LOADER_OFFSET_SIZE = 10;
    private static ArrayList<AppCompatDialog> DAILOGS = new ArrayList<>();
    final static String DEFAULT_LOADER = LoaderStyle.BallClipRotatePulseIndicator.name();
    public static void showLoading(Context context, Enum<LoaderStyle> type) {
        showLoading(context, type.name());
    }

    public static void showLoading(Context context, String type) {

        final AppCompatDialog dialog = new AppCompatDialog(context, R.style.dialog);
        final AVLoadingIndicatorView avLoadingIndicatorView = LoaderCreator.create(type, context);
        dialog.setContentView(avLoadingIndicatorView);

        final int deviceWidth = DimenUtil.getScreenWidth();
        final int devieceHeight = DimenUtil.getScreenHeight();
        final Window dialogWindow = dialog.getWindow();
        if (null != dialogWindow) {
            final WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = deviceWidth / LOADER_SIZE_SCALLE;
            lp.height = devieceHeight / LOADER_SIZE_SCALLE;
            lp.height = lp.height + devieceHeight / LOADER_OFFSET_SIZE;
            lp.gravity = Gravity.CENTER;

        }
        DAILOGS.add(dialog);
        dialog.show();
    }

    public static void showLoading(Context context) {
        showLoading(context, DEFAULT_LOADER);
    }

    public static void stopLoading() {
        for (AppCompatDialog dialog :
                DAILOGS) {
            if (null != dialog) {
                if (dialog.isShowing()) {
                    dialog.cancel();//可以回掉 （onCancle）
                    //       dialog.dismiss();单纯的消失
                }
            }
        }
    }
}
