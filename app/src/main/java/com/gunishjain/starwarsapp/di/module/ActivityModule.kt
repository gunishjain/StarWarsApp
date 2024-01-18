package com.gunishjain.starwarsapp.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.gunishjain.starwarsapp.data.repository.StarWarsRepository
import com.gunishjain.starwarsapp.di.ActivityContext
import com.gunishjain.starwarsapp.ui.base.ViewModelProviderFactory
import com.gunishjain.starwarsapp.ui.character.CharacterListViewModel
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideCharacterListViewModel(repository: StarWarsRepository): CharacterListViewModel {
        return ViewModelProvider(activity,
            ViewModelProviderFactory(CharacterListViewModel::class) {
                CharacterListViewModel(repository)
            })[CharacterListViewModel::class.java]
    }
}