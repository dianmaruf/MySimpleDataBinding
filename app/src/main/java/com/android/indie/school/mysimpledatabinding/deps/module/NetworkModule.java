package com.android.indie.school.mysimpledatabinding.deps.module;

import com.android.indie.school.mysimpledatabinding.networking.NetworkService;
import com.android.indie.school.mysimpledatabinding.networking.Service;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by herisulistiyanto on 3/12/17.
 */
@Module
public class NetworkModule {
    private final String OKHTTP_LOG_INTERCEPTOR = "loggingInterceptor";
    private final String BASE_OKHTTP = "baseOkhttp3";
    private final String BASE_RETROFIT = "baseRetrofit";
    private final String BASE_NETWORK_SERVICE = "baseNetworkService";
    String baseUrl;

    public NetworkModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    @Named(OKHTTP_LOG_INTERCEPTOR)
    public HttpLoggingInterceptor providesLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    @Named(BASE_OKHTTP)
    public OkHttpClient providesOkHttpClient3(@Named(OKHTTP_LOG_INTERCEPTOR) HttpLoggingInterceptor interceptor) {
        final int timeout = 3;

        return new okhttp3.OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(timeout, TimeUnit.SECONDS)
                .writeTimeout(timeout, TimeUnit.SECONDS)
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    @Named("gson")
    public Gson providesGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    @Named(BASE_RETROFIT)
    public Retrofit provideBaseRetrofit(@Named(BASE_OKHTTP) OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(this.baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    @Named(BASE_NETWORK_SERVICE)
    public NetworkService providesNetworkService(@Named(BASE_RETROFIT) Retrofit retrofit) {
        return retrofit.create(NetworkService.class);
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public Service providesService(@Named(BASE_NETWORK_SERVICE) NetworkService networkService) {
        return new Service(networkService);
    }
}
