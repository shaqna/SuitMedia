package com.ngedev.suitmediamobile.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ngedev.suitmediamobile.data.source.local.dao.EventDao
import com.ngedev.suitmediamobile.data.source.local.dao.ProfileDao
import com.ngedev.suitmediamobile.data.source.local.dao.RemoteKeysDao
import com.ngedev.suitmediamobile.data.source.local.dao.UserDao
import com.ngedev.suitmediamobile.data.source.local.entities.ProfileEntity
import com.ngedev.suitmediamobile.data.source.local.entities.RemoteKeysEntity
import com.ngedev.suitmediamobile.domain.model.Event
import com.ngedev.suitmediamobile.domain.model.User

@Database(
    entities = [User::class, ProfileEntity::class, RemoteKeysEntity::class, Event::class],
    version = 1,
    exportSchema = false
)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun profileDao(): ProfileDao
    abstract fun remoteKeysDao(): RemoteKeysDao
    abstract fun eventDao(): EventDao
}