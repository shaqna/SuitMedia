package com.ngedev.suitmediamobile.domain.useCase.first

import com.ngedev.suitmediamobile.domain.model.Profile

interface FirstUseCase {
    fun saveProfile(profile: Profile)
}