package com.example.mvvm_room.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mvvm_room.Data.GroceryItems
import com.example.mvvm_room.repo.GroceryRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GroceryViewModel(val repository: GroceryRepository): ViewModel() {
    fun insert(item: GroceryItems) = GlobalScope.launch {
        repository.insert(item)
    }

    fun delete(item: GroceryItems) = GlobalScope.launch {
        repository.delete(item)
    }

    fun allGroceryItems() = repository.allGroceryItems()
}