package com.ngedev.suitmediamobile.data.mapper

import com.ngedev.suitmediamobile.data.source.local.entities.ProfileEntity
import com.ngedev.suitmediamobile.domain.model.Profile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun Profile.toEntity() =
    ProfileEntity(id, name, image)

fun ProfileEntity.toModel() =
    Profile(id, name, image)

fun Flow<ProfileEntity>.toFlowModel() =
    this.map {
        it.toModel()
    }