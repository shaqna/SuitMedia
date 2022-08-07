package com.ngedev.suitmediamobile.domain.useCase.third

import com.ngedev.suitmediamobile.domain.model.Event
import com.ngedev.suitmediamobile.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface EventUseCase {
    fun getListEvent(): Flow<List<Event>>
}