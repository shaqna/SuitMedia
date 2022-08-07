package com.ngedev.suitmediamobile.ui.screen4

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.ngedev.suitmediamobile.data.mapper.toModel
import com.ngedev.suitmediamobile.domain.model.User
import com.ngedev.suitmediamobile.domain.useCase.fourth.GuestUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GuestViewModel(private val useCase: GuestUseCase): ViewModel() {

    fun getUsers(): Flow<PagingData<User>> =
        useCase.getUsers().cachedIn(viewModelScope)


}