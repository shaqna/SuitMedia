package com.ngedev.suitmediamobile.ui.screen2

import androidx.lifecycle.ViewModel
import com.ngedev.suitmediamobile.domain.model.Profile
import com.ngedev.suitmediamobile.domain.useCase.second.SecondUseCase
import kotlinx.coroutines.flow.Flow

class SecondViewModel(private val useCase: SecondUseCase): ViewModel() {


    fun getProfile(): Flow<Profile> = useCase.getProfile()
}