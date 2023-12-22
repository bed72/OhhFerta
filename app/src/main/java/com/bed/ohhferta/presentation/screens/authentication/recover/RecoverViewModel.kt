package com.bed.ohhferta.presentation.screens.authentication.recover

import javax.inject.Inject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.MutableStateFlow

import dagger.hilt.android.lifecycle.HiltViewModel

import com.bed.core.usecases.coroutines.CoroutinesUseCase
import com.bed.core.usecases.authentication.RecoverUseCase

import com.bed.ohhferta.presentation.commons.states.States
import com.bed.ohhferta.presentation.commons.states.FormState

import com.bed.core.domain.parameters.authentication.RecoverParameter

@HiltViewModel
class RecoverViewModel @Inject constructor(
    private val recoverUseCase: RecoverUseCase,
    private val coroutinesUseCase: CoroutinesUseCase,
) : ViewModel() {
    val email = FormState()

    private val _state = MutableStateFlow<States<Boolean>>(States.Initial)
    val state: StateFlow<States<Boolean>> get() = _state.asStateFlow()

    fun recover(parameter: RecoverParameter) {
        _state.update { States.Loading }

        viewModelScope.launch(coroutinesUseCase.main()) {
            _state.update { States.Success(recoverUseCase(parameter).first()) }
        }
    }
}
