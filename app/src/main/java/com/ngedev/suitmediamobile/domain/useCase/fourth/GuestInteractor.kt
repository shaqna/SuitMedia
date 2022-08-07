package com.ngedev.suitmediamobile.domain.useCase.fourth

import androidx.paging.PagingData
import com.ngedev.suitmediamobile.domain.model.User
import com.ngedev.suitmediamobile.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GuestInteractor(private val repository: UserRepository): GuestUseCase {
    override fun getUsers(): Flow<PagingData<User>> =
        repository.getAllUsers()
}