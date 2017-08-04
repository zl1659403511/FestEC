package com.abc.latte.net;

import android.content.Context;

import com.abc.latte.app.Latte;
import com.abc.latte.net.callback.IError;
import com.abc.latte.net.callback.IFailure;
import com.abc.latte.net.callback.IRequest;
import com.abc.latte.net.callback.ISuccess;
import com.abc.latte.net.callback.RequestCallbacks;
import com.abc.latte.net.download.DownLoadHandler;
import com.abc.latte.ui.LatteLoader;
import com.abc.latte.ui.LoaderStyle;

import java.io.File;
import java.io.PipedReader;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.abc.latte.net.RestCreator.getRestService;

/**
 * Created by admin on 2017/7/28.
 * 使用建造者模式（alertdialog 源码就是使用这个模式）
 */

public class RestClient {
    private final String URL;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final String DOWNLOAD_DIR;
    private final String EXTENSION;
    private final String NAME;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROE;
    private final RequestBody BODY;
    private final File FILE;
    private final LoaderStyle LOADER_STYLE;
    private final Context CONTEXT;

    public RestClient(String url,
                      Map<String, Object> params,
                      String downloaDir,
                      String extension,
                      String name,
                      IRequest request,
                      ISuccess success,
                      IFailure failure,
                      IError error,
                      RequestBody body,
                      File file,
                      LoaderStyle loadstyle,
                      Context context) {
        this.URL = url;
        PARAMS.putAll(params);
        this.DOWNLOAD_DIR = downloaDir;
        this.EXTENSION = extension;
        this.NAME = name;
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROE = error;
        this.BODY = body;
        this.FILE = file;
        this.LOADER_STYLE = loadstyle;
        this.CONTEXT = context;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }

    private void request(HttpMethod method) {
        final RestService service = getRestService();
        Call<String> call = null;
        if (null != REQUEST) {
            REQUEST.onRequestStart();
        }
        if (null != LOADER_STYLE) {
            LatteLoader.showLoading(CONTEXT, LOADER_STYLE);
        }
        switch (method) {
            case GET:
                call = service.get(URL, PARAMS);
                break;
            case POST:
                call = service.post(URL, PARAMS);
                break;
            case POST_RAW:
                call = service.postRaw(URL, BODY);
                break;
            case PUT:
                call = service.put(URL, PARAMS);
                break;
            case PUT_RAW:
                call = service.putRaw(URL, BODY);
                break;
            case DELETE:
                call = service.delete(URL, PARAMS);
                break;
            case UPLOAD:
                final RequestBody requestBody = RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()), FILE);
                final MultipartBody.Part body = MultipartBody.Part.createFormData("file", FILE.getName(), requestBody);
                call = RestCreator.getRestService().upload(URL, body);
                break;
            default:
                break;
        }
        if (null != call) {
            call.enqueue(getRequestCallback());
        }
    }

    private Callback<String> getRequestCallback() {
        return new RequestCallbacks(REQUEST,
                SUCCESS,
                FAILURE,
                ERROE,
                LOADER_STYLE);
    }

    public final void get() {
        request(HttpMethod.GET);
    }

    public final void post() {
        if (null == BODY) {
            request(HttpMethod.POST);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null!");
            }
            request(HttpMethod.PUT_RAW);
        }
        request(HttpMethod.POST);
    }
    public final void put() {
        if (null == BODY) {
            request(HttpMethod.PUT);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null!");
            }
            request(HttpMethod.PUT_RAW);
        }
        request(HttpMethod.PUT);
    }
    public final void delete() {
        request(HttpMethod.DELETE);
    }

    public final void download() {
        new DownLoadHandler(URL, REQUEST, DOWNLOAD_DIR, EXTENSION, NAME, SUCCESS, FAILURE, ERROE).handleDownLoad();
    }
}
