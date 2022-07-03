package com.example.mvvm_room.Ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_room.Data.GroceryItems
import com.example.mvvm_room.R
import com.example.mvvm_room.databinding.GroceryadapterBinding
import com.example.mvvm_room.viewmodel.GroceryViewModel

class GroceryAdapter() :
    RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder>() {

    var groceries = mutableListOf<GroceryItems>()

    fun setGroceriesList(groceriesList: List<GroceryItems>){
        groceries = groceriesList.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = GroceryadapterBinding.inflate(inflater,parent,false)
        return GroceryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
        var currentPosition = groceries.get(position)
        holder.bind(currentPosition)
        Log.d("Adapter","$currentPosition")
/*        holder.itemView.ibDelete.setOnClickListener {
            viewModel.delete(currentPosition)
        }*/
        // To get total cost
/*        if (position == list.size - 1) {
            var totalCost = 0.0
            for (i in 0 until list.size) {
                totalCost += list[i].itemPrice
            }
            holder.itemView.txtItemTotalCost.visibility = View.VISIBLE
            holder.itemView.txtTotalCostTitle.visibility = View.VISIBLE
            holder.itemView.txtItemTotalCost.text = "$totalCost"
        }*/
    }

    override fun getItemCount(): Int {
        return groceries.size
    }

    class GroceryViewHolder(val binding: GroceryadapterBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(groceryItems: GroceryItems){
            binding.txtItemName.text = groceryItems.itemName
            binding.txtItemPrice.text = "${groceryItems.itemPrice}"
            binding.txtItemQuantity.text = "${groceryItems.itemQuantity}"
        }
    }

}