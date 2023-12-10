package com.example.mica3.data

import com.example.mica3.network.EventApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer
{
    val eventRepository: EventRepository
}

class DefaultAppContainer: AppContainer
{
    private val URL = "http://192.168.178.178:4000/user/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(URL)
        .build()

    private val retrofitService: EventApi by lazy {
        retrofit.create(EventApi::class.java)
    }

    override val eventRepository: EventRepository by lazy{
        NetworkEventRepository(retrofitService)
    }
}
