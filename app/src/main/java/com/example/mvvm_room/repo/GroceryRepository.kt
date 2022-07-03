package com.example.mvvm_room.repo

import com.example.mvvm_room.Data.GroceryDatabase
import com.example.mvvm_room.Data.GroceryItems

class GroceryRepository(private val db: GroceryDatabase) {
    suspend fun insert(item: GroceryItems) = db.getGroceryDao().insert(item)
    suspend fun delete(item: GroceryItems) = db.getGroceryDao().delete(item)

    fun allGroceryItems() = db.getGroceryDao().getAllGroceryItems()
}