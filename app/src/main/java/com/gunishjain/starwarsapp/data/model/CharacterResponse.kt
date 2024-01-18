package com.gunishjain.starwarsapp.data.model

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    @SerializedName("results")
    val characters: List<Character>
)