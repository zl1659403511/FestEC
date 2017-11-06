package com.abc.latte.ui.recycleview;

import com.google.auto.value.AutoValue;

/**
 * Created by Administrator on 2017/10/19.
 */
@AutoValue
public abstract class RgbValue {
    public abstract int red();

    public abstract int green();

    public abstract int blue();
    public static RgbValue create(int red, int green, int blue) {
        return new AutoValue_RgbValue(red, green, blue);
    }


}
