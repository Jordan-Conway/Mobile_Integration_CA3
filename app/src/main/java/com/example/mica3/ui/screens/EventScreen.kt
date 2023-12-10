package com.example.mica3.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mica3.model.Event
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.mica3.R

@Composable
fun EventScreen(eventViewModel: EventViewModel)
{
    val uiState = eventViewModel.eventUIState
    Log.d("uiState", "Got uiState")
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
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 5.dp)
    ){
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
            .fillMaxWidth(fraction = 0.9F)
            .padding(5.dp),
        contentAlignment = Alignment.Center
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically
        )
        {
            var string: String = event.datetime.substringBefore('T') +
                                '\n' +
                                event.datetime.substringAfter('T').substringBefore('Z')

            if(event.sensor == "switch")
            {
                string += '\n'
                string += "Box was "

                if(event.isOpen)
                {
                    string += "opened"
                }
                else
                {
                    string += "closed"
                }
            }

            Text(string)
        }
    }
}

@Composable
fun ErrorScreen()
{
    Log.e("Error", "Failed to load events")
    Text("Failed to load events")
}

@Composable
fun LoadingScreen()
{
    Log.d("Loading", "Loading Images")
    Text("Loading")
}


