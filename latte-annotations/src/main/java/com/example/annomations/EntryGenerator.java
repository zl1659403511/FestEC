package com.example.annomations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



/**
 * Created by admin on 2017/9/24.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)//在源码上进行处理 ，打包后 不在使用 对性能 没有影响
public @interface EntryGenerator {
    String packageName();
    Class<?> entryTemplete();
}
