package com.mks.mvvm.webservice

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val API_BASE_URL = "https://reqres.in/"

    fun buildApiInterface() : ApiInterface{
        val retrofitBuilder : Retrofit.Builder = Retrofit.Builder().baseUrl(API_BASE_URL).addConverterFactory(
            GsonConverterFactory.create())
        val okHttpClient : OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(
            okHttpInterceptor()
        )

        val retrofit : Retrofit = retrofitBuilder.client(okHttpClient.build()).build()
        return retrofit.create(ApiInterface::class.java)
    }

    private fun okHttpInterceptor() : HttpLoggingInterceptor {
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return logInterceptor
    }
}