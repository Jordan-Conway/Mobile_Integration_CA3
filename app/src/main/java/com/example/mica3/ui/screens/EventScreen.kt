package com.example.mica3.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mica3.model.Event
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.res.colorResource
import com.example.mica3.R

@Composable
fun EventScreen(uiState: EventUIState)
{
    when(uiState)
    {
        is EventUIState.Success -> EventList(events = uiState.events)
        is EventUIState.Loading -> LoadingScreen()
        is EventUIState.Error -> ErrorScreen()
    }

    
}

@Composable 
fun EventList(events: List<Event>)
{
    LazyColumn{
        items(events){ event ->
            EventDisplay(event = event)
        }
    }
}

@Composable
fun EventDisplay(event: Event)
{
    Box(
        modifier = Modifier
            .background(colorResource(R.color.okay))
    )
    {
        Row()
        {
            Text(event.datetime)
        }

    }
}

@Composable
fun ErrorScreen()
{
    Text("Failed to load events")
}

@Composable
fun LoadingScreen()
{
    Text("Loading")
}


