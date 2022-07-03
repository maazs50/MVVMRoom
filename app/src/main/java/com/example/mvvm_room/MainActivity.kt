package com.example.mvvm_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_room.Data.GroceryDatabase
import com.example.mvvm_room.Data.GroceryItems
import com.example.mvvm_room.Ui.DialogListener
import com.example.mvvm_room.Ui.GroceryAdapter
import com.example.mvvm_room.Ui.GroceryItemDialog
import com.example.mvvm_room.databinding.ActivityMainBinding
import com.example.mvvm_room.repo.GroceryRepository
import com.example.mvvm_room.viewmodel.GroceryViewModel
import com.example.mvvm_room.viewmodel.GroceryViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: GroceryViewModel
    val adapter = GroceryAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpViewModel()
        binding.rvList.layoutManager = LinearLayoutManager(this)
        binding.rvList.adapter = adapter
        setUpObservers()
        addItem()
    }

    private fun setUpViewModel(){
        viewModel = ViewModelProvider(this, GroceryViewModelFactory(GroceryRepository(GroceryDatabase.getDatabase(this)))).get(GroceryViewModel::class.java)
    }

    private fun setUpObservers(){
        Log.d("Activity","SetupobserversCalled")
        viewModel.allGroceryItems().observe(this, Observer {
            Log.d("Activity","$it")
            adapter.setGroceriesList(it)
        })
    }

    private fun addItem() {
        binding.btnAdd.setOnClickListener {
            GroceryItemDialog(this, object : DialogListener{
                override fun onAddButtonClicked(item: GroceryItems) {
                    viewModel.insert(item)
                }

            }).show()
        }
    }
}