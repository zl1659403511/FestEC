package com.abc.latte.ui.recycleview;

import java.util.LinkedHashMap;

/**
 * Created by admin on 2017/10/13.
 */

public class MultipleItemEntityBuilder {
    private final LinkedHashMap<Object, Object> FIELD = new LinkedHashMap<>();

    public MultipleItemEntityBuilder() {
        FIELD.clear();
    }

    public final MultipleItemEntityBuilder setItemType(int itemType) {
        FIELD.put(MultipleFields.ITEM_TYPE,itemType);
        return this;
    }
    public final MultipleItemEntityBuilder setField(Object key,Object value) {
        FIELD.put(key,value);
        return this;
    }

    public final MultipleItemEntityBuilder setFields(LinkedHashMap<Object, Object> field) {
        FIELD.putAll(field);
        return this;
    }
    public final MultipleItemEntity build() {
        return new MultipleItemEntity(FIELD);

    }

}
