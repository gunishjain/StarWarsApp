package com.gunishjain.starwarsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.gunishjain.starwarsapp.data.api.NetworkService
import com.gunishjain.starwarsapp.data.model.Character
import com.gunishjain.starwarsapp.data.repository.paging.CharacterPagingSource
import kotlinx.coroutines.flow.Flow

class StarWarsRepository (private val networkService: NetworkService) {

    fun getCharacters(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(
                pageSize = 1
            ),
            pagingSourceFactory = {
                CharacterPagingSource(networkService)
            }
        ).flow
    }




}