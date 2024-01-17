package com.gunishjain.starwarsapp.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.gunishjain.starwarsapp.di.ActivityContext
import dagger.Provides

class ActivityModule(private val activity: AppCompatActivity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }
}