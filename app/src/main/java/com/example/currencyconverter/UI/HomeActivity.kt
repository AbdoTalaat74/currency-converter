package com.example.currencyconverter.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.currencyconverter.R
import com.example.currencyconverter.databinding.HomeActivityBinding


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnItemSelectedListener { item ->

            when (item.itemId) {
                R.id.currencies_page -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.currenciesFragment)
                    true
                }
                R.id.convert_page -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.convertFragment)
                    true
                }
                R.id.statistics_page -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.statisticsFragment)
                    true
                }
                R.id.info_page -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.infoFragment)
                    true
                }
                else -> false
            }
        }

    }
}