package com.example.garage.network

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val baseURL = "https://api-ru.iiko.services/api/"

object NetworkController {

    fun getIIkoApi(): IIkoAPI {
        val okHTTPClient = OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor { message ->
                    Log.d("OK HTTP", message)
                }.apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .protocols(listOf(Protocol.HTTP_2, Protocol.HTTP_1_1))
            .connectTimeout(15000L, TimeUnit.SECONDS)
            .readTimeout(15000L, TimeUnit.SECONDS)
            .writeTimeout(15000L, TimeUnit.SECONDS)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .client(okHTTPClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(IIkoAPI::class.java)
    }
}