package com.abc.latte.net;

import com.abc.latte.app.ConfigType;
import com.abc.latte.app.Latte;

import org.w3c.dom.ProcessingInstruction;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by admin on 2017/7/28.
 */
//单例创建模式 内部类holder
public class RestCreator {
    private static final class ParamsHolder {
        public static final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
    }

    public static WeakHashMap<String, Object> getParams() {
        return ParamsHolder.PARAMS;
    }


    public static RestService getRestService() {
        return RestServiceHolder.REST_SERVICE;
    }

    private static final class RetrofitHolder {
        private static final String BASE_URL = ((String) Latte.getConfigurations().get(ConfigType.API_HOST.name()));
        private static final Retrofit RETROGT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(ScalarsConverterFactory.create())
                .client(OkHttpHolder.OK_HTTP_CLIENT)
                .build();
    }

    private static final class OkHttpHolder {
        private static final int TIME_OUT = 60;
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    private static final class RestServiceHolder {
        private static final RestService REST_SERVICE =
                RetrofitHolder.RETROGT_CLIENT.create(RestService.class);
    }
}
