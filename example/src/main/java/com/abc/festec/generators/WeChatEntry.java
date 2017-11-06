package com.abc.festec.generators;

import com.abc.latte.wechat.template.WXEntryTemplate;
import com.example.annomations.EntryGenerator;

/**
 * Created by admin on 2017/9/24.
 */


@SuppressWarnings("unused")
@EntryGenerator(
        packageName = "com.abc.festec.example",
        entryTemplete = WXEntryTemplate.class
)
public interface WeChatEntry {
}
