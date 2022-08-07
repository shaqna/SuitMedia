package com.ngedev.suitmediamobile.data.source.local

import androidx.paging.PagingSource
import com.ngedev.suitmediamobile.data.source.local.dao.EventDao
import com.ngedev.suitmediamobile.data.source.local.dao.ProfileDao
import com.ngedev.suitmediamobile.data.source.local.dao.RemoteKeysDao
import com.ngedev.suitmediamobile.data.source.local.dao.UserDao
import com.ngedev.suitmediamobile.data.source.local.entities.ProfileEntity
import com.ngedev.suitmediamobile.data.source.local.entities.RemoteKeysEntity
import com.ngedev.suitmediamobile.domain.model.Event
import com.ngedev.suitmediamobile.domain.model.User
import kotlinx.coroutines.flow.Flow

class LocalDataSource(
    private val userDao: UserDao,
    private val profileDao: ProfileDao,
    private val remoteKeysDao: RemoteKeysDao,
    private val eventDao: EventDao
) {

    suspend fun insertEvents(events: List<Event>) = eventDao.insertEvents(events)

    suspend fun insertEvent(event: Event) = eventDao.insertEvent(event)

    fun getEventById(id: Int) = eventDao.getEventById(id)

    fun getEvents(): Flow<List<Event>> = eventDao.getEvents()

    suspend fun clearEvent() = eventDao.clearEvent()

    fun getUserById(id: Int): Flow<User> = userDao.getUserById(id)

    suspend fun insertUser(user: User) = userDao.insertUser(user)

    suspend fun insertUsers(user: List<User>) = userDao.insertUsers(user)

    fun getUsers(): PagingSource<Int, User> = userDao.getUsers()

    suspend fun clearUsers() = userDao.clearUser()

    suspend fun insertProfile(entity: ProfileEntity) = profileDao.insertProfile(entity)

    fun getProfile(): Flow<ProfileEntity> = profileDao.getProfile()

    suspend fun clearProfile() = profileDao.clearProfile()

    suspend fun getRemoteKeys(id: Int): RemoteKeysEntity = remoteKeysDao.getRemoteKeys(id)

    suspend fun addAllRemoteKeys(remoteKeys: List<RemoteKeysEntity>) =
        remoteKeysDao.addAllRemoteKeys(remoteKeys)

    suspend fun clearRemoteKeys() = remoteKeysDao.clearRemoteKeys()

}