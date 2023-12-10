package com.example.mica3.network

import com.example.mica3.model.RequestResult
import retrofit2.http.GET

interface EventApi
{
    @GET("655cb110fe187fcebac17ec6/events")
    suspend fun getEvents(): RequestResult
}