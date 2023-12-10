package com.example.mica3

import android.app.Application
import com.example.mica3.data.AppContainer
import com.example.mica3.data.DefaultAppContainer

class EventApplication : Application()
{
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}