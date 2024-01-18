package com.gunishjain.starwarsapp.ui.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.gunishjain.starwarsapp.data.model.Character
import com.gunishjain.starwarsapp.data.repository.StarWarsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CharacterListViewModel (private val repository: StarWarsRepository ) : ViewModel() {

    private val _uiState = MutableStateFlow<PagingData<Character>>(value = PagingData.empty())
    val uiState: StateFlow<PagingData<Character>> = _uiState

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        viewModelScope.launch {
            repository.getCharacters().cachedIn(viewModelScope)
                .collect {
                    _uiState.value = it
                }
        }
    }
}