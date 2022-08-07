package com.ngedev.suitmediamobile.data.di

import com.ngedev.suitmediamobile.data.repository.EventRepositoryImpl
import com.ngedev.suitmediamobile.data.repository.ProfileRepositoryImpl
import com.ngedev.suitmediamobile.data.repository.UserRepositoryImpl
import com.ngedev.suitmediamobile.domain.repository.EventRepository
import com.ngedev.suitmediamobile.domain.repository.ProfileRepository
import com.ngedev.suitmediamobile.domain.repository.UserRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::UserRepositoryImpl) {
        bind<UserRepository>()
    }
    singleOf(::ProfileRepositoryImpl) {
        bind<ProfileRepository>()
    }
    singleOf(::EventRepositoryImpl) {
        bind<EventRepository>()
    }
}