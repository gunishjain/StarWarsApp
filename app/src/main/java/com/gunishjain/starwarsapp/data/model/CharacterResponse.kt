package com.gunishjain.starwarsapp.data.model

data class CharacterResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val characters: List<Character>
)