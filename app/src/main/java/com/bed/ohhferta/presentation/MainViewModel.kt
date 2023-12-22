package com.bed.ohhferta.presentation

import javax.inject.Inject

import androidx.lifecycle.ViewModel

import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.MutableStateFlow

import dagger.hilt.android.lifecycle.HiltViewModel

import com.bed.core.usecases.authentication.IsLoggedInUseCase

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: IsLoggedInUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<States>(States.Initial)
    val state: StateFlow<States> get() = _state.asStateFlow()

    fun isLoggedIn() {
        _state.update { States.IsLoggedIn(useCase()) }
    }

    sealed class States {
        data object Initial : States()
        data class IsLoggedIn(val isLogged: Boolean) : States()
    }
}
