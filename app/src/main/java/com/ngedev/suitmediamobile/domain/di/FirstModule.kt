package com.ngedev.suitmediamobile.domain.di

import com.ngedev.suitmediamobile.domain.useCase.first.FirstInteractor
import com.ngedev.suitmediamobile.domain.useCase.first.FirstUseCase
import com.ngedev.suitmediamobile.ui.screen1.FirstViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf


val firstModule = module {
    factoryOf(::FirstInteractor) {
        bind<FirstUseCase>()
    }
    viewModelOf(::FirstViewModel)
}