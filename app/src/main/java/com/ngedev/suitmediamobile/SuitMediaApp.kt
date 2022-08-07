package com.ngedev.suitmediamobile

import android.app.Application
import com.ngedev.suitmediamobile.data.di.*
import com.ngedev.suitmediamobile.domain.di.eventModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class SuitMediaApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@SuitMediaApp)
            loadKoinModules(
                listOf(
                    databaseModule,
                    localSourceModule,
                    remoteSourceModule,
                    retrofitModule,
                    providerModule,
                    repositoryModule,
                    eventServiceModule
                )
            )
        }
    }
}