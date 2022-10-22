package com.example.currencyconverter.Authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.currencyconverter.R
import com.example.currencyconverter.databinding.FragmentLoginBinding

class LoginFragment: Fragment()  {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentLoginBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.btnGoToRegister.setOnClickListener{
            this.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        return binding.root
    }
}