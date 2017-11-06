package com.abc.latte.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by admin on 2017/7/23.
 */

public enum  EcIcons implements Icon{
    icon_scan('\ue602'),
    icon_ali_pay('\ue606');


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
