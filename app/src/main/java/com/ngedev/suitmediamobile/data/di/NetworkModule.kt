package com.ngedev.suitmediamobile.data.di


import com.ngedev.suitmediamobile.data.source.remote.RemoteDataSource
import com.ngedev.suitmediamobile.data.source.remote.ApiService
import com.ngedev.suitmediamobile.data.source.remote.EventService
import com.ngedev.suitmediamobile.utils.Constants
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val retrofit: Retrofit =
    Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

val retrofitModule = module {
    single {
        retrofit.create(ApiService::class.java)
    }
}

val remoteSourceModule = module {
    singleOf(::RemoteDataSource)
}

val eventServiceModule = module {
    factoryOf(::EventService)
}