package com.gunishjain.starwarsapp

import android.app.Application
import com.gunishjain.starwarsapp.di.component.ApplicationComponent
import com.gunishjain.starwarsapp.di.module.ApplicationModule

class StarWarsApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}