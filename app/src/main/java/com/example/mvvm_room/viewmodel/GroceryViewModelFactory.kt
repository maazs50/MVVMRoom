package com.example.mvvm_room.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_room.repo.GroceryRepository

class GroceryViewModelFactory(private val repository: GroceryRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(GroceryViewModel::class.java)){
            GroceryViewModel(repository) as T
        } else{
            throw IllegalArgumentException("ViewModel not found")
        }
    }
}