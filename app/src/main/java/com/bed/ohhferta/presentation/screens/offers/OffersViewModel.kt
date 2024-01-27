package com.bed.ohhferta.presentation.screens.offers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.MutableStateFlow

import com.bed.ohhferta.presentation.commons.states.States

import com.bed.core.domain.models.offers.OfferModel

import com.bed.core.usecases.coroutines.CoroutinesUseCase
import com.bed.core.usecases.authentication.GetAllOffersUseCase

class OffersViewModel(
    private val coroutinesUseCase: CoroutinesUseCase,
    private val getAllOffersUseCase: GetAllOffersUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<States<List<OfferModel>>>(States.Initial)
    val state: StateFlow<States<List<OfferModel>>> get() = _state.asStateFlow()

    init {
        getAll()
    }

    private fun getAll() {
        _state.update { States.Loading }

        viewModelScope.launch(coroutinesUseCase.main()) {
            getAllOffersUseCase().collect {
                it.fold(
                    { failure -> _state.update { States.Failure(failure.message) } },
                    { success -> _state.update { States.Success(success) } }
                )
            }
        }
    }
}
