package com.abc.latte.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.WeakHashMap;

/**
 * Created by admin on 2017/7/23.
 */

public class Configurator {
    private static final HashMap<String,Object> LATTE_CONFIGS=new HashMap<>();
    private static final ArrayList<IconFontDescriptor> ICONS=new ArrayList<IconFontDescriptor>();
    private Configurator(){
                 LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),false);
            }
    private static class Holder{
        private static final Configurator  INSTANCE=new Configurator();
     }
     public static Configurator getInstance(){
        return Holder.INSTANCE;
    }
    public final void configure(){
        initIcons();
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),true);
    }
    final HashMap<String,Object> getLatteConfigs(){
        return LATTE_CONFIGS;
    }
    public final Configurator withApiHost(String host){
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(),host);
        return this;
    }
    public final Configurator withIcon(IconFontDescriptor descriptor){
        ICONS.add(descriptor);
            return this;
    }
    private void initIcons(){
        if(ICONS.size()>0){
        final Iconify.IconifyInitializer initializer=Iconify.with(ICONS.get(0));
            for(int i=1;i<ICONS.size();i++){
                initializer.with(ICONS.get(i));
            }
        }
    }
 private void checkConfiguration(){
     final boolean isReady= ((boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name()));
     if (!isReady) {
         throw new RuntimeException("Configuration is not ready,call configure() ");
     }
 }

 final <T> T getConfiguration(Enum<ConfigType> key){
     checkConfiguration();
     return (T)LATTE_CONFIGS.get(key.name());
 }
}
