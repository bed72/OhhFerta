package com.bed.ohhferta.framework.modules.usecases

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

import com.bed.core.usecases.coroutines.CoroutinesUseCase
import com.bed.core.usecases.coroutines.CoroutinesUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
interface CoroutinesUseCaseModule {
    @Binds
    fun bindCoroutinesUseCase(useCase: CoroutinesUseCaseImpl): CoroutinesUseCase
}
