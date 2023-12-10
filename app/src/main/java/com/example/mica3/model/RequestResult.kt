package com.example.mica3.model

import kotlinx.serialization.Serializable

@Serializable
class RequestResult (
    val status: Int,
    val message: String,
    val data: List<Event>
)