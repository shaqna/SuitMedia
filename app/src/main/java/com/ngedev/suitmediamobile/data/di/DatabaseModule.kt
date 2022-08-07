package com.ngedev.suitmediamobile.data.di

import androidx.room.Room
import com.ngedev.suitmediamobile.data.source.local.LocalDataSource
import com.ngedev.suitmediamobile.data.source.local.LocalDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            LocalDatabase::class.java,
            "LocalDatabase.db"
        ).fallbackToDestructiveMigration().build()
    }

    factory {
        get<LocalDatabase>().userDao()
    }

    factory {
        get<LocalDatabase>().profileDao()
    }

    factory {
        get<LocalDatabase>().remoteKeysDao()
    }
    factory {
        get<LocalDatabase>().eventDao()
    }
}

val localSourceModule = module {
    single {
        LocalDataSource(get(),get(), get(), get())
    }

}