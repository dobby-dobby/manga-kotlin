package com.coding.mymanga_android_kotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coding.core.ulti.UiState
import com.coding.core.ulti.toUiState
import com.coding.domain.model.Manga
import com.coding.domain.model.usecase.GetMangaListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MangaListViewModel @Inject constructor(
    private val getMangaListUseCase: GetMangaListUseCase
) : ViewModel() {

    private val _mangaListState = MutableStateFlow<UiState<List<Manga>>>(UiState.Loading)
    val mangaListState: StateFlow<UiState<List<Manga>>> = _mangaListState.asStateFlow()

    init {
        getMangaList()
    }

    fun getMangaList() {
        viewModelScope.launch {
            _mangaListState.value = UiState.Loading // Indicate loading state
            getMangaListUseCase(1).collect { result -> // Collect the flow of Resource<List<Manga>>
                _mangaListState.value = result.toUiState() // Update the UI state
            }
        }
    }
}