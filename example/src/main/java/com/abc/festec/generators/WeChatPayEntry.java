package com.abc.festec.generators;

/**
 * Created by admin on 2017/9/24.
 */

import com.abc.latte.wechat.template.WXPayEntryTemplate;
import com.example.annomations.PayEntryGenerator;

@SuppressWarnings("unused")
@PayEntryGenerator(
        packageName = "com.abc.festec.example",
        payEntryTemplete = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
