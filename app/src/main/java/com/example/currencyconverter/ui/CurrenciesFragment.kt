package com.example.currencyconverter.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.currencyconverter.R
import com.example.currencyconverter.ui.main.MainAdapter
import com.example.currencyconverter.ui.main.MainViewModel
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

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.addCurrencyFragment)
        }

        return binding.root

    }
}