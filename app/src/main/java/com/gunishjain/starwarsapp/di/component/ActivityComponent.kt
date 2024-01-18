package com.gunishjain.starwarsapp.di.component

import com.gunishjain.starwarsapp.ui.character.CharacterListActivity
import com.gunishjain.starwarsapp.di.ActivityScope


@ActivityScope
interface ActivityComponent {

    fun inject(activity: CharacterListActivity)
}