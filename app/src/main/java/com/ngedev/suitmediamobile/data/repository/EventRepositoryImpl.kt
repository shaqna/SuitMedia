package com.ngedev.suitmediamobile.data.repository

import com.ngedev.suitmediamobile.data.source.remote.RemoteDataSource
import com.ngedev.suitmediamobile.domain.model.Event
import com.ngedev.suitmediamobile.domain.repository.EventRepository
import kotlinx.coroutines.flow.Flow

class EventRepositoryImpl(
    private val remote: RemoteDataSource
) :
    EventRepository {
    override fun getListEvent(): Flow<List<Event>> =
       remote.getListEvent()

}