package com.ngedev.suitmediamobile.ui.screen3.events

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ngedev.suitmediamobile.domain.useCase.third.EventUseCase

class EventViewModel(private val useCase: EventUseCase): ViewModel() {

    fun getEvents() = useCase.getListEvent()
}