package com.ngedev.suitmediamobile.data.source.local.dao

import androidx.room.*
import com.ngedev.suitmediamobile.data.source.local.entities.ProfileEntity
import com.ngedev.suitmediamobile.domain.model.Profile

import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfile(profileEntity: ProfileEntity)

    @Query("SELECT * FROM profile")
    fun getProfile(): Flow<ProfileEntity>

    @Query("DELETE FROM profile")
    suspend fun clearProfile()
}