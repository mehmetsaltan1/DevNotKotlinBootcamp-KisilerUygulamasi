package com.example.kisileruygulamasi.room

import androidx.room.Dao
import androidx.room.Query
import com.example.kisileruygulamasi.entity.Kisiler

@Dao
interface KisilerDao {
    @Query("SELECT * FROM kisiler")
    suspend fun tumKisiler():List<Kisiler>
}