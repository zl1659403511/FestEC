package com.abc.latte.app;

import android.content.Context;

import java.util.HashMap;


/**
 * Created by admin on 2017/7/23.
 */

public final  class Latte {
 public static Configurator init(Context context){
     getConfigurations().put(ConfigType.APPLICATION_CONTENT.name(),context.getApplicationContext());
     return Configurator.getInstance();
 }
public static HashMap<String,Object> getConfigurations(){
    return Configurator.getInstance().getLatteConfigs();
}
}
