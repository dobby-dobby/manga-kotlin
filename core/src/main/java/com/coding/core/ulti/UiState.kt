package com.coding.core.ulti

sealed class UiState<out T> {
    data object Loading : UiState<Nothing>()
    data class Success<out T>(val data: T) : UiState<T>()
    data class Error(val message: String) : UiState<Nothing>()
}

fun <T> Resource<T>.toUiState(): UiState<T> {
    return when (this) {
        is Resource.Success -> UiState.Success(data)
        is Resource.Error -> UiState.Error(message ?: "Unknown error")
        is Resource.Loading -> UiState.Loading
        null -> UiState.Error("An unexpected error occurred") }
}