package com.ngedev.suitmediamobile.data.di

import com.ngedev.suitmediamobile.data.helper.TransactionProvider
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val providerModule = module {
    singleOf(::TransactionProvider)
}