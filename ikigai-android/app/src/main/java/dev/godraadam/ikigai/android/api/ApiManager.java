package dev.godraadam.ikigai.android.api;

import android.content.Context;

import com.google.gson.GsonBuilder;

import java.util.Arrays;

import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {
    private ApiManager() {}

    private static String baseUrl = "http://192.168.100.3:8081";

    public static Retrofit getClient(Context context) {
        return getClient(baseUrl);
    }


    private static Retrofit getClient(String url) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(httpLoggingInterceptor).build();
        client.connectionSpecs(Arrays.asList(ConnectionSpec.CLEARTEXT));
        OkHttpClient okHttpClient = client.build();
        GsonBuilder gsonBuilder = new GsonBuilder();
        GsonConverterFactory factory = GsonConverterFactory.create(gsonBuilder.create());
        return new Retrofit.Builder().baseUrl(url).addConverterFactory(factory).client(okHttpClient).build();
    }
}
