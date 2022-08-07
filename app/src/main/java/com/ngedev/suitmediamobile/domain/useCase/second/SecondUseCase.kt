package com.ngedev.suitmediamobile.domain.useCase.second

import com.ngedev.suitmediamobile.domain.model.Profile
import kotlinx.coroutines.flow.Flow

interface SecondUseCase {
    fun getProfile(): Flow<Profile>
}