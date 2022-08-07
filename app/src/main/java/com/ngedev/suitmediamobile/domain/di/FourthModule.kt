package com.ngedev.suitmediamobile.domain.di

import com.ngedev.suitmediamobile.domain.useCase.fourth.GuestInteractor
import com.ngedev.suitmediamobile.domain.useCase.fourth.GuestUseCase
import com.ngedev.suitmediamobile.ui.screen4.GuestViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val guestModule = module {
    factoryOf(::GuestInteractor) {
        bind<GuestUseCase>()
    }
    viewModelOf(::GuestViewModel)
}