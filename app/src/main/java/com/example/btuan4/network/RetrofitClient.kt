package com.example.btuan4.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    // ✅ Base URL phải kết thúc bằng dấu "/"
    // vì trong ApiService bạn đã khai báo @GET("tasks"), @GET("task/{id}")
    private const val BASE_URL = "https://amock.io/api/researchUTH/"

    // Ghi log mọi request/response để dễ debug
    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    // Tạo OkHttp client
    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    // Tạo Retrofit instance
    val apiService: TaskApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(TaskApiService::class.java)
    }
}
