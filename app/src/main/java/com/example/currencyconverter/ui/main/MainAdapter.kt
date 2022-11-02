package com.example.currencyconverter.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyconverter.models.Currency
import com.example.currencyconverter.databinding.CurrenciesListItemBinding

class MainAdapter : ListAdapter<Currency, MainAdapter.MainViewHolder>(DiffCallback()) {


    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val currencyProperty = getItem(position)
        holder.bind(currencyProperty)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            CurrenciesListItemBinding.inflate(
                (LayoutInflater.from(parent.context)),
                parent, false
            )
        )
    }

    class MainViewHolder(var binding: CurrenciesListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(currency: Currency){
            binding.currency = currency
            binding.executePendingBindings()
        }
    }



}

class DiffCallback:DiffUtil.ItemCallback<Currency>() {
    override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean {
        return oldItem == newItem
    }

}
