package com.example.mica3.ui.state

import androidx.lifecycle.ViewModel
import com.example.mica3.model.Event
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(AppUiState())
    val uiState: StateFlow<AppUiState> = _uiState.asStateFlow()

    fun addEvents(toAdd: List<Event>)
    {
        val oldEventList: List<Event> = uiState.value.events
        _uiState.update { currentState ->
            currentState.copy(events = oldEventList + toAdd)
        }
    }
}