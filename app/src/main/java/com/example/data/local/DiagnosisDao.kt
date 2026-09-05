package com.example.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DiagnosisDao {
    @Query("SELECT * FROM diagnoses ORDER BY timestamp DESC")
    fun getAllDiagnoses(): Flow<List<DiagnosisEntity>>

    @Query("SELECT * FROM diagnoses WHERE id = :id LIMIT 1")
    suspend fun getDiagnosisById(id: Long): DiagnosisEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDiagnosis(diagnosis: DiagnosisEntity): Long

    @Delete
    suspend fun deleteDiagnosis(diagnosis: DiagnosisEntity)

    @Query("DELETE FROM diagnoses WHERE id = :id")
    suspend fun deleteById(id: Long)
}
