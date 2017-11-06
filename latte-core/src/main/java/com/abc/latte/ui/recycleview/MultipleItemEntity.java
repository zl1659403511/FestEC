package com.abc.latte.ui.recycleview;

import com.chad.library.adapter.base.entity.MultiItemEntity;


import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

/**
 * Created by admin on 2017/10/13.
 */

public class MultipleItemEntity implements MultiItemEntity {
    private final ReferenceQueue<LinkedHashMap<Object, Object>> ITEM_QUENE = new ReferenceQueue<>();
    private final LinkedHashMap<Object, Object> MULTIPLE_FIELDS = new LinkedHashMap<>();
    private final SoftReference<LinkedHashMap<Object, Object>> FIELDS_REFERENCE
            = new SoftReference<LinkedHashMap<Object, Object>>(MULTIPLE_FIELDS, ITEM_QUENE);

    @Override
    public int getItemType() {
        return ((int) FIELDS_REFERENCE.get().get(MultipleFields.ITEM_TYPE));
    }

    public MultipleItemEntity(LinkedHashMap<Object, Object> multiple_fields) {
        FIELDS_REFERENCE.get().putAll(multiple_fields);
    }
    public static MultipleItemEntityBuilder builder() {
        return new MultipleItemEntityBuilder();
    }

    @SuppressWarnings("unchecked")
    public final <T> T getField(Object key) {
        return (T) FIELDS_REFERENCE.get().get(key);
    }

    public final LinkedHashMap<?, ?> getFields() {
        return FIELDS_REFERENCE.get();
    }

    public final MultipleItemEntity setField(Object key, Object value) {
        FIELDS_REFERENCE.get().put(key, value);
        return this;
    }
}
