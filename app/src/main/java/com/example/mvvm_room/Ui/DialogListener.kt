package com.example.mvvm_room.Ui

import com.example.mvvm_room.Data.GroceryItems

interface DialogListener {
    // Create a function to add items
      // in GroceryItems on clicking
    fun onAddButtonClicked(item: GroceryItems)
}