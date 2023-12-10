package com.example.mica3.ui.state

import com.example.mica3.model.Event

data class AppUiState(
    val events: List<Event> = emptyList()
)