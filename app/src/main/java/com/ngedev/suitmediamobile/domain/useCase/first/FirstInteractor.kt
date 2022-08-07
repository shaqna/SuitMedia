package com.ngedev.suitmediamobile.domain.useCase.first

import com.ngedev.suitmediamobile.domain.model.Profile
import com.ngedev.suitmediamobile.domain.repository.ProfileRepository

class FirstInteractor(private val repository: ProfileRepository): FirstUseCase {
    override fun saveProfile(profile: Profile) {
        repository.saveProfile(profile)
    }
}