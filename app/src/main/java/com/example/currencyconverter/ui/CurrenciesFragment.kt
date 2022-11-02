package com.example.currencyconverter.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.currencyconverter.ui.Main.MainAdapter
import com.example.currencyconverter.models.MainViewModel
import com.example.currencyconverter.databinding.FragmentCurrenciesBinding

class CurrenciesFragment : Fragment() {
    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCurrenciesBinding.inflate(inflater)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.getCurrencies()

        binding.lifecycleOwner = this

        binding.vModel = viewModel

        val adapter = MainAdapter()
        binding.currenciesRecycler.adapter = adapter


        return binding.root

    }
}