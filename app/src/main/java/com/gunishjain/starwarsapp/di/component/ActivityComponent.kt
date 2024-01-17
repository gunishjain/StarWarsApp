package com.gunishjain.starwarsapp.di.component

import com.gunishjain.starwarsapp.MainActivity
import com.gunishjain.starwarsapp.di.ActivityScope
import dagger.Component


@ActivityScope
interface ActivityComponent {

    fun inject(activity: MainActivity)
}