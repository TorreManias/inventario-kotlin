package com.example.inventory.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item:Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    // Seleccionar registro usando el ID del producto
    @Query("SELECT * from item WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    // Obtener todos los items de forma ascendente
    @Query("SELECT * from item ORDER BY name ASC")
    fun getItems(): Flow<List<Item>>
}