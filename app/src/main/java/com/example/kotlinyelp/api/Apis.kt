package com.example.kotlinyelp.api

import com.example.kotlinyelp.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val AUTH = "Bearer " + BuildConfig.YELP_API_KEY

inline fun <reified T : Any> api(): T = Apis.create(T::class.java)

object Apis {
    private val client = OkHttpClient.Builder().addNetworkInterceptor {
        it.proceed(it.request().newBuilder().addHeader("Authorization", AUTH).build())
    }.build()

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    fun <T> create(service: Class<T>): T {
        return Retrofit.Builder()
                .baseUrl("https://api.yelp.com/")
                .client(client)
                .addCallAdapterFactory(RxJava2SchedulerCallAdapterFactory(client))
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(service)
    }
}
