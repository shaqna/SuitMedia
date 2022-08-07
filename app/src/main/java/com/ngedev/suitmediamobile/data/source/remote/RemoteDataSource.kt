package com.ngedev.suitmediamobile.data.source.remote


import android.util.Log
import com.ngedev.suitmediamobile.data.source.remote.response.ApiResponse
import com.ngedev.suitmediamobile.data.source.remote.response.PagingResponse
import com.ngedev.suitmediamobile.data.source.remote.response.UserResponse
import com.ngedev.suitmediamobile.domain.model.Event
import com.ngedev.suitmediamobile.domain.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(
    private val userService: ApiService,
    private val eventService: EventService
) {

    suspend fun getListUser(page: Int, perPage: Int): PagingResponse<UserResponse> =
        userService.getListUser(page, perPage)

    fun getUserById(id: Int): Flow<ApiResponse<UserResponse>> =
        flow {
            try {
                val response = userService.getUser(id)
                emit(ApiResponse.Success(response))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)

    fun getListEvent(): Flow<List<Event>> =
        eventService.getListEvent()
}