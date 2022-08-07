package com.ngedev.suitmediamobile.domain.repository

import androidx.paging.PagingData
import com.ngedev.suitmediamobile.domain.model.User
import com.ngedev.suitmediamobile.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getAllUsers(): Flow<PagingData<User>>
    fun getUserById(id: Int): Flow<Resource<User>>
    fun clearUserData()

}