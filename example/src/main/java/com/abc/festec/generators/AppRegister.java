package com.abc.festec.generators;


import com.abc.latte.wechat.template.AppRegisterTemplate;
import com.example.annomations.AppRegisterGenerator;

@SuppressWarnings("unused")
@AppRegisterGenerator(
        packageName = "com.abc.festec.example",
        registerTemplete = AppRegisterTemplate.class
)
public interface AppRegister {
}
