package com.ngedev.suitmediamobile.data.source.remote

import com.ngedev.suitmediamobile.data.source.remote.response.PagingResponse
import com.ngedev.suitmediamobile.data.source.remote.response.UserResponse
import com.ngedev.suitmediamobile.domain.model.User
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("api/users")
    suspend fun getListUser(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): PagingResponse<UserResponse>

    @GET("api/users/{id}")
    suspend fun getUser(@Path("id") id: Int): UserResponse
}