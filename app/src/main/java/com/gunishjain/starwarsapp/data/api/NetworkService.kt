package com.gunishjain.starwarsapp.data.api

import com.gunishjain.starwarsapp.data.model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("people")
    suspend fun getCharacterList(@Query("page") page: Int): CharacterResponse

}