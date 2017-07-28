package com.abc.latte.net;

import java.util.Map;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by admin on 2017/7/28.
 */

public interface RestService {

    /** get 提交
     * @param url
     * @param params 提交参数  拼接到url上
     * @return
     */
    @GET
    Call<String> get(@Url String url, @QueryMap Map<String,Object> params);

    /** 表单post 提交
     * @param url 表单提交 的url
     *
     * @param params  提交的参数
     * @return
     */
    @FormUrlEncoded
    @POST
    Call<String> post(@Url String url, @FieldMap Map<String,Object> params);

    /**
     * @param url
     * @param params
     * @return
     */
    @FormUrlEncoded
    @PUT
    Call<String> put(@Url String url,@FieldMap Map<String,Object> params);

    /**
     * @param url
     * @param params
     * @return
     */
    @GET
    Call<String> delete(@Url String url, @QueryMap Map<String,Object> params);

    /**
     * @param url
     * @param params
     * @return
     */
    @Streaming  // 文件下载到内存中,当文件过大，会造成内存紧张，@streaming 注解 边下载边 保存到硬盘中
    @GET
    Call<ResponseBody> download(@Url String url,@QueryMap Map<String,Object> params);

    /**
     * @param url
     * @param file
     * @return
     */
    @Multipart
    @POST
    Call<String> upload(@Url String url, @Part MultipartBody.Part file);
}

