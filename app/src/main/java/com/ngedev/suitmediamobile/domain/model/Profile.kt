package com.ngedev.suitmediamobile.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.IDN

data class Profile(
    val id: Int,
    val name: String,
    val image: String
)
