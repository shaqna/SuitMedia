

package com.ngedev.suitmediamobile.data.cache

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.ngedev.suitmediamobile.data.helper.TransactionProvider
import com.ngedev.suitmediamobile.data.mapper.toListModel
import com.ngedev.suitmediamobile.data.source.local.LocalDataSource
import com.ngedev.suitmediamobile.data.source.local.entities.RemoteKeysEntity
import com.ngedev.suitmediamobile.data.source.remote.RemoteDataSource
import com.ngedev.suitmediamobile.domain.model.User

@OptIn(ExperimentalPagingApi::class)
class UserRemoteMediator(
    private val remote: RemoteDataSource,
    private val local: LocalDataSource,
    private val transactionProvider: TransactionProvider
) : RemoteMediator<Int, User>() {


    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, User>
    ): MediatorResult {
        return try {
            val currentPage = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }
                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    prevPage
                }
                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    nextPage
                }
            }

            val response = remote.getListUser(page = currentPage, perPage = 10)
            Log.d("MyMyPag", response.toString())
            val endOfPaginationReached = response.data.isEmpty()

            val prevPage = if (currentPage == 1) null else currentPage - 1
            val nextPage = if (endOfPaginationReached) null else currentPage + 1

            transactionProvider.runAsTransaction {
                if (loadType == LoadType.REFRESH) {
                    local.clearUsers()
                    local.clearRemoteKeys()
                }
                val keys = response.data.map { userResponse ->
                    RemoteKeysEntity(
                        id = userResponse.id,
                        prevPage = prevPage,
                        nextPage = nextPage
                    )
                }
                local.addAllRemoteKeys(remoteKeys = keys)
                local.insertUsers(response.data.toListModel())
            }
            Log.d("MyMyPag", endOfPaginationReached.toString())
            MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, User>
    ): RemoteKeysEntity? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                local.getRemoteKeys(id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(
        state: PagingState<Int, User>
    ): RemoteKeysEntity? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { user ->
                local.getRemoteKeys(user.id)
            }
    }

    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, User>
    ): RemoteKeysEntity? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { user ->
                local.getRemoteKeys(user.id)
            }
    }

}