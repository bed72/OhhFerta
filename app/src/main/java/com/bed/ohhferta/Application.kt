package com.bed.ohhferta

import android.app.Application

import org.koin.core.logger.Level
import org.koin.core.context.startKoin

import org.koin.android.ext.koin.androidLogger
import org.koin.android.ext.koin.androidContext

import com.bed.ohhferta.framework.modules.clients.clientsModule
import com.bed.ohhferta.framework.modules.usecases.useCasesModule
import com.bed.ohhferta.framework.modules.viewmodels.viewModelsModule
import com.bed.ohhferta.framework.modules.datasources.dataSourcesModule
import com.bed.ohhferta.framework.modules.repositories.repositoriesModule

class Application : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@Application)

            modules(
                clientsModule(),
                dataSourcesModule,
                repositoriesModule,
                useCasesModule,
                viewModelsModule
            )
        }
    }
}
