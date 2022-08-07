package com.ngedev.suitmediamobile.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ngedev.suitmediamobile.data.cache.NetworkBoundResource
import com.ngedev.suitmediamobile.data.cache.UserRemoteMediator
import com.ngedev.suitmediamobile.data.helper.TransactionProvider
import com.ngedev.suitmediamobile.data.mapper.toEntity
import com.ngedev.suitmediamobile.data.mapper.toModel
import com.ngedev.suitmediamobile.data.source.local.LocalDataSource
import com.ngedev.suitmediamobile.data.source.remote.RemoteDataSource
import com.ngedev.suitmediamobile.data.source.remote.response.ApiResponse
import com.ngedev.suitmediamobile.data.source.remote.response.UserResponse
import com.ngedev.suitmediamobile.domain.model.User
import com.ngedev.suitmediamobile.domain.repository.UserRepository
import com.ngedev.suitmediamobile.domain.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagingApi::class)
class UserRepositoryImpl(
    private val local: LocalDataSource,
    private val remote: RemoteDataSource,
    private val transactionProvider: TransactionProvider
) : UserRepository {

    override fun getAllUsers(): Flow<PagingData<User>> {
        val pagingSourceFactory = {
            local.getUsers()
        }
        return Pager(
            config = PagingConfig(10),
            remoteMediator = UserRemoteMediator(remote, local, transactionProvider),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun getUserById(id: Int): Flow<Resource<User>> =
        object : NetworkBoundResource<User, UserResponse>() {
            override fun loadFromDB(): Flow<User> {
                return local.getUserById(id)
            }

            override fun shouldFetch(data: User?): Boolean {
                return data == null
            }

            override suspend fun createCall(): Flow<ApiResponse<UserResponse>> {
                return remote.getUserById(id)
            }

            override suspend fun saveCallResult(data: UserResponse) {
                local.insertUser(data.toModel())
            }


        }.asFlow()

    override fun clearUserData() {
        CoroutineScope(Dispatchers.IO).launch {
            local.clearUsers()
        }
    }
}