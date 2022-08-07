package com.ngedev.suitmediamobile.domain.useCase.third

import com.ngedev.suitmediamobile.domain.model.Event
import com.ngedev.suitmediamobile.domain.repository.EventRepository
import kotlinx.coroutines.flow.Flow

class EventInteractor(private val repository: EventRepository): EventUseCase {
    override fun getListEvent(): Flow<List<Event>> =
        repository.getListEvent()
}