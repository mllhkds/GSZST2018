package com.example.a13466.gsst.utils;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpUtil {
    private String Url;
    private String param;
    private static HttpUtil httpUtil;
    private static OkHttpClient client = new OkHttpClient();
    public static  final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public void okHttpPostAsync (Callback callback){
        client.dispatcher().setMaxRequests(1);
        RequestBody body = RequestBody.create(JSON,param);
        Request request = new Request.Builder()
                .url(Url)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);

    }

    public HttpUtil setUrl (String url) {
          this.Url = url;
          return this;
    }

    public HttpUtil setParam (String param) {
        this.param = param;
        return this;
    }

    public static HttpUtil getInstance (){
        if (httpUtil == null){
            synchronized (HttpUtil.class){
                if (httpUtil == null){
                    httpUtil = new HttpUtil();
                }
            }
        }
        return httpUtil;
    }
}
