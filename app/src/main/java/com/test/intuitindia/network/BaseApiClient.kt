package com.test.intuitindia.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

open class BaseApiClient<I> constructor(baseUrl: String, service: Class<I>) {

    protected val apiInterface: I

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(OkHttpClient())
            .build()

        apiInterface = retrofit.create(service)
    }
}