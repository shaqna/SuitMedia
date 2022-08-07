package com.ngedev.suitmediamobile.domain.di


import com.ngedev.suitmediamobile.domain.useCase.second.SecondInteractor
import com.ngedev.suitmediamobile.domain.useCase.second.SecondUseCase
import com.ngedev.suitmediamobile.ui.screen2.SecondViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val secondModule = module {
    factoryOf(::SecondInteractor) {
        bind<SecondUseCase>()
    }
    viewModelOf(::SecondViewModel)
}