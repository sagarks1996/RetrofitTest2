package com.example.retrofittest2;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static RetrofitClientInstance mInstance;
    private Retrofit retrofit;
    private static final String BASE_URL = "http://192.168.101.49:8085/";

    public RetrofitClientInstance()
    {
        Log.d("Apicall","retrofit instance");
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .connectTimeout(2, TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .build();

        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public static synchronized RetrofitClientInstance getInstance() {

        if (mInstance == null) {
           mInstance = new RetrofitClientInstance();
        }
        return mInstance;
    }

    public GetDataService getApi()
    {
        return retrofit.create(GetDataService.class);
    }
}
