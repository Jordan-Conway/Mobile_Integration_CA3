package com.example.mica3.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mica3.ui.screens.EventScreen
import com.example.mica3.ui.screens.EventViewModel

@Composable
fun EventApp()
{
    val eventViewModel: EventViewModel = viewModel(factory = EventViewModel.Factory)
    EventScreen(uiState = eventViewModel.eventUIState)
}