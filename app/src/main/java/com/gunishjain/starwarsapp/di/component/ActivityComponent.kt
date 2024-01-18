package com.gunishjain.starwarsapp.di.component

import com.gunishjain.starwarsapp.di.ActivityScope
import com.gunishjain.starwarsapp.di.module.ActivityModule
import com.gunishjain.starwarsapp.ui.character.CharacterListActivity
import dagger.Component


@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: CharacterListActivity)
}