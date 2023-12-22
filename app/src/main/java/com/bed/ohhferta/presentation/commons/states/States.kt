package com.bed.ohhferta.presentation.commons.states

sealed class States<out S> {
    data object Initial : States<Nothing>()
    data object Loading : States<Nothing>()
    data class Success<T>(val data: T) : States<T>()
    data class Failure(val data: String) : States<Nothing>()
}
