package com.ngedev.suitmediamobile.data.source.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_keys")
data class RemoteKeysEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "prevPage")
    val prevPage: Int?,

    @ColumnInfo(name = "nextPage")
    val nextPage: Int?

)
