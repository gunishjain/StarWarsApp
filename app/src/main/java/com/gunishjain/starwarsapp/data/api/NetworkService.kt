package com.gunishjain.starwarsapp.data.api

import com.gunishjain.starwarsapp.data.model.CharacterResponse
import retrofit2.http.GET

interface NetworkService {

    @GET("people")
    suspend fun getCharacterList() : CharacterResponse

}