package com.example.currencyconverter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyconverter.models.Currency
import com.example.currencyconverter.ui.Main.MainAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Currency>?) {
    val adapter = recyclerView.adapter as MainAdapter
    adapter.submitList(data)
}

