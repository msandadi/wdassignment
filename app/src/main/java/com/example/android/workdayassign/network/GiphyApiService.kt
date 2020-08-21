package com.example.android.workdayassign.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.giphy.com/v1/gifs/"

//MoshiBuilder is used to create Moshi object with KotlinJsonAdapterFactory
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// Retrofit Builder to build a retrofit object using a Moshi converter with our Moshi object
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface GiphyApi{
    @GET("search?q=funny+cat&api_key=dc6zaTOxFJmzC")
    fun getGiphyProperties(): Call<String>
}

object GiphyApiService {
    val retrofitSerive: GiphyApi by lazy{retrofit.create(GiphyApi::class.java)}
}
