package com.example.mica3.data

import com.example.mica3.model.Event
import com.example.mica3.network.EventApi

interface EventRepository
{
    suspend fun getEvents(): List<Event>
}

class NetworkEventRepository(private val eventApi: EventApi): EventRepository
{
    override suspend fun getEvents(): List<Event> {
        return eventApi.getEvents().data
    }
}
