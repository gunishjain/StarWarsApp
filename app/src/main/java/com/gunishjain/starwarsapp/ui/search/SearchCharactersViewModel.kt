package com.gunishjain.starwarsapp.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.gunishjain.starwarsapp.data.model.Character
import com.gunishjain.starwarsapp.data.repository.StarWarsRepository
import com.gunishjain.starwarsapp.utils.AppConstant.DEBOUNCE_TIMEOUT
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchCharactersViewModel @Inject constructor(private val repository: StarWarsRepository) :
    ViewModel() {

    private val searchText = MutableStateFlow("")
    private val _uiState = MutableStateFlow<PagingData<Character>>(value = PagingData.empty())
    val uiState: StateFlow<PagingData<Character>> = _uiState

    init {
        createSearchFlow()
    }

    @OptIn(FlowPreview::class)
    private fun createSearchFlow() {
        viewModelScope.launch {
            searchText.debounce(DEBOUNCE_TIMEOUT)
                .filter {
                    if (it.isNotEmpty() && it.length >= 1) {
                        return@filter true
                    } else {
                        _uiState.value = PagingData.empty()
                        return@filter false
                    }
                }.distinctUntilChanged()
                .flatMapLatest {
                    return@flatMapLatest repository.getSearchResult(it).cachedIn(viewModelScope)
                        .catch {
                            _uiState.value = PagingData.empty()
                        }
                }
                .flowOn(Dispatchers.IO)
                .collect {
                    _uiState.value = it
                }
        }
    }

    fun onQuerySearch(query: String) {
        searchText.value = query
    }


}