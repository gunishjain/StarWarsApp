package com.gunishjain.starwarsapp.data.api

import com.gunishjain.starwarsapp.data.model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @GET("people")
    suspend fun getCharacterList(@Query("page") page: Int): CharacterResponse

    @GET("people/")
    suspend fun searchCharacterList(@Query("search") query: String, @Query("page") page: Int): CharacterResponse

}
