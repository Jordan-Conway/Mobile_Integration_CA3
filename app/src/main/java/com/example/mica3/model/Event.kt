package com.example.mica3.model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Event(
    val datetime: String,
    val sensor: String,
    @SerialName(value = "isopen")
    val isOpen: Boolean
)