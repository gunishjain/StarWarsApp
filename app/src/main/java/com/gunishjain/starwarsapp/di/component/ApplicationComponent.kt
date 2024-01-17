package com.gunishjain.starwarsapp.di.component

import android.content.Context
import com.gunishjain.starwarsapp.StarWarsApplication
import com.gunishjain.starwarsapp.data.api.NetworkService
import com.gunishjain.starwarsapp.di.ApplicationContext

interface ApplicationComponent {

    fun inject(application: StarWarsApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService
}