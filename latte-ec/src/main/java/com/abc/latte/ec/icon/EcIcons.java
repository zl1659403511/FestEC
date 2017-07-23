package com.abc.latte.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by admin on 2017/7/23.
 */

public enum  EcIcons implements Icon{
    icon_scan('\ue646') ,
    icon_ali_pay('\ue938');


    EcIcons(char character) {
        this.character = character;
    }

    private char character;
    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
