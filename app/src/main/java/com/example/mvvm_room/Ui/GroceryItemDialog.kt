package com.example.mvvm_room.Ui

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.mvvm_room.Data.GroceryItems
import com.example.mvvm_room.databinding.GrocerydialogBinding


class GroceryItemDialog(context: Context, dialogListener: DialogListener) : AppCompatDialog(context) {
    lateinit var binding: GrocerydialogBinding
    val listener = dialogListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = GrocerydialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvSave.setOnClickListener {
            /*val name = binding.etItemName.text.toString()
            val quantity = binding.etItemQuantity.text.toString()
            val price = binding.etItemPrice.text.toString()
            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(quantity) || TextUtils.isEmpty(price)) {
                Toast.makeText(context, "Please Enter all items", Toast.LENGTH_SHORT).show()
            } else {
                val item = GroceryItems("Hayat",5,20.0)
                listener.onAddButtonClicked(item)
                dismiss()
            }*/
            val item = GroceryItems("Hayat",5,20.0)
            listener.onAddButtonClicked(item)
            dismiss()
        }
        binding.tvCancel.setOnClickListener {
            cancel()
        }
    }

}