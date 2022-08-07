package com.ngedev.suitmediamobile.domain.repository

import com.ngedev.suitmediamobile.domain.model.Profile
import com.ngedev.suitmediamobile.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {

    fun getProfile(): Flow<Profile>
    fun saveProfile(profile: Profile)
    fun clear()


}