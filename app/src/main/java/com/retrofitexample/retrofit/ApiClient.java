package com.retrofitexample.retrofit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "http://votivelaravel.in/grupapp/";
    private static Retrofit retrofit = null;
    private static OkHttpClient okHttpClient = null;

    private static String HEADER_KEY = "GRUPAPP";
    private static String HEADER_KEY_VALUE = "123456";

    private static String HEADER_CONTENT_TYPE = "Content-Type";
    private static String HEADER_CONTENT_TYPE_VALUE = "application/json";

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getRequestHeader())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    private static OkHttpClient getRequestHeader() {
        if (null == okHttpClient) {
            okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request.Builder builder = chain.request().newBuilder();
                            builder.addHeader(HEADER_CONTENT_TYPE, HEADER_CONTENT_TYPE_VALUE);
                            builder.addHeader(HEADER_KEY, HEADER_KEY_VALUE);
                            return chain.proceed(builder.build());
                        }
                    })
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .build();
        }
        return okHttpClient;
    }
}