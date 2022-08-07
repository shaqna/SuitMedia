package com.ngedev.suitmediamobile.domain.useCase.fourth

import androidx.paging.PagingData
import com.ngedev.suitmediamobile.domain.model.User
import kotlinx.coroutines.flow.Flow

interface GuestUseCase {
    fun getUsers(): Flow<PagingData<User>>
}
