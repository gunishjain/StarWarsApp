package com.gunishjain.starwarsapp.di.component

import android.content.Context
import com.gunishjain.starwarsapp.StarWarsApplication
import com.gunishjain.starwarsapp.data.api.NetworkService
import com.gunishjain.starwarsapp.data.repository.StarWarsRepository
import com.gunishjain.starwarsapp.di.ApplicationContext
import com.gunishjain.starwarsapp.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: StarWarsApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getStarWarsRepository(): StarWarsRepository
}