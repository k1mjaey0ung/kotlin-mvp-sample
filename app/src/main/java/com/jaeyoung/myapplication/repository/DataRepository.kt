package com.jaeyoung.myapplication.repository

import com.jaeyoung.myapplication.data.api.DataApi
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class DataRepository {

    fun create(): DataApi {
        return createRetrofit().create(DataApi::class.java)
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(OkHttpClient.Builder()
                .connectionPool(ConnectionPool(5, 20, TimeUnit.SECONDS))
                .build())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://dummy.restapiexample.com/")
            .build()
    }
}