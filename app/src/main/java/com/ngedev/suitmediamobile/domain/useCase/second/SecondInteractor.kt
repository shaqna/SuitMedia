package com.ngedev.suitmediamobile.domain.useCase.second

import com.ngedev.suitmediamobile.domain.model.Profile
import com.ngedev.suitmediamobile.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow

class SecondInteractor(private val repository: ProfileRepository): SecondUseCase {
    override fun getProfile(): Flow<Profile> =
        repository.getProfile()
}