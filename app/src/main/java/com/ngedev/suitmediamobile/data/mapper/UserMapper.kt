package com.ngedev.suitmediamobile.data.mapper

import com.ngedev.suitmediamobile.data.source.remote.response.UserResponse
import com.ngedev.suitmediamobile.domain.model.User


fun UserResponse.toModel(): User =
    User(id, email, first_name, last_ame, avatar)

fun List<UserResponse>.toListModel() =
    this.map {
        it.toModel()
    }


