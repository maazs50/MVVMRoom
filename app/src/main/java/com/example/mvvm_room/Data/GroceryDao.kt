package com.example.mvvm_room.Data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GroceryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(items: GroceryItems)

    @Delete
    suspend fun delete(items: GroceryItems)

    @Query("SELECT * FROM grocery_items")
    fun getAllGroceryItems(): LiveData<List<GroceryItems>>
}