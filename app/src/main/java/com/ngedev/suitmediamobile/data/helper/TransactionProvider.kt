package com.ngedev.suitmediamobile.data.helper

import androidx.room.withTransaction
import com.ngedev.suitmediamobile.data.source.local.LocalDatabase

class TransactionProvider(private val db: LocalDatabase) {
    suspend fun <R> runAsTransaction(block: suspend () -> R): R {
        return db.withTransaction(block)
    }
}