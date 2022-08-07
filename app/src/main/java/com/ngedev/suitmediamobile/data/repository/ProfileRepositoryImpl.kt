package com.ngedev.suitmediamobile.data.repository

import com.ngedev.suitmediamobile.data.mapper.toEntity
import com.ngedev.suitmediamobile.data.mapper.toFlowModel
import com.ngedev.suitmediamobile.data.source.local.LocalDataSource
import com.ngedev.suitmediamobile.domain.model.Profile
import com.ngedev.suitmediamobile.domain.repository.ProfileRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch


class ProfileRepositoryImpl(private val local: LocalDataSource): ProfileRepository {
    override fun getProfile(): Flow<Profile> =
        local.getProfile().toFlowModel()

    override fun saveProfile(profile: Profile) {
        CoroutineScope(Dispatchers.IO).launch {
            local.insertProfile(profile.toEntity())
        }
    }

    override fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            local.clearProfile()
        }
    }

}