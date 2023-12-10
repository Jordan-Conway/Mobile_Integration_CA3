package com.example.mica3.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.mica3.data.EventRepository
import com.example.mica3.model.Event
import kotlinx.coroutines.launch
import java.io.IOException
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import com.example.mica3.EventApplication

sealed interface EventUIState
{
    data class Success(
        val events: List<Event>
    ): EventUIState
    object Error: EventUIState
    object Loading: EventUIState
}

class EventViewModel(private val eventRepositroy: EventRepository): ViewModel()
{
    var eventUIState: EventUIState by mutableStateOf(EventUIState.Loading)
        private set

    init
    {
        getEvents()
    }

    fun getEvents()
    {
        viewModelScope.launch {
            eventUIState = EventUIState.Loading
            eventUIState = try{
                EventUIState.Success(eventRepositroy.getEvents())
            }
            catch (e: IOException)
            {
                Log.d("Exception", e.message.toString())
                EventUIState.Error
            }
        }
    }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as EventApplication)
                val eventRepository = application.container.eventRepository
                EventViewModel(eventRepositroy = eventRepository)
            }
        }
    }
}