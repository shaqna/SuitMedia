package com.ngedev.suitmediamobile.domain.repository

import com.ngedev.suitmediamobile.domain.model.Event
import com.ngedev.suitmediamobile.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface EventRepository {
    fun getListEvent(): Flow<List<Event>>
}