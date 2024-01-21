package com.bed.ohhferta.framework.modules.viewmodels

import org.koin.dsl.module

import org.koin.androidx.viewmodel.dsl.viewModelOf

import com.bed.ohhferta.presentation.screens.home.offers.OffersViewModel

val viewModelsModule = module {
    viewModelOf(::OffersViewModel)
}
