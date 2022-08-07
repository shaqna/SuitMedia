package com.ngedev.suitmediamobile.domain.di

import com.ngedev.suitmediamobile.domain.repository.EventRepository

import com.ngedev.suitmediamobile.domain.useCase.third.EventInteractor
import com.ngedev.suitmediamobile.domain.useCase.third.EventUseCase
import com.ngedev.suitmediamobile.ui.screen3.events.EventViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val eventModule = module {
    factoryOf(::EventInteractor) {
        bind<EventUseCase>()
    }
    viewModelOf(::EventViewModel)
}