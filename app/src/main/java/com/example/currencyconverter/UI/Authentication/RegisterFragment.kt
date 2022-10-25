package com.example.currencyconverter.UI.Authentication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.currencyconverter.API.UserAuthentication
import com.example.currencyconverter.Models.User
import com.example.currencyconverter.R
import com.example.currencyconverter.databinding.FragmentRegisterBinding
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class RegisterFragment : Fragment() {

    private lateinit var email: String
    private lateinit var password: String
    private lateinit var phoneNumber: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentRegisterBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.btnGoToLogin.setOnClickListener {
            this.findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }


        binding.btnRegister.setOnClickListener {
            email = binding.etRegisterEmail.text.toString()
            password = binding.etRegisterPassword.text.toString()
            phoneNumber = binding.etRegisterPhoneNumber.text.toString()

            val user = User(email, password, phoneNumber)

            val call: Call<User> = UserAuthentication.retrofitService.register(user)

            call.enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful) {
                        Snackbar.make(requireView(), "Account Created! ", Snackbar.LENGTH_LONG)
                            .show()
                        Log.e("onResponse", response.body()!!.email)

                        binding.etRegisterEmail.text = null
                        binding.etRegisterPassword.text = null
                        binding.etRegisterPhoneNumber.text = null

                    } else {
                        Snackbar.make(requireView(), "Register Failed", Snackbar.LENGTH_LONG).show()
                        Log.e("responseCode", response.code().toString())

                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Snackbar.make(requireView(), "onFailure", Snackbar.LENGTH_LONG).show()
                    Log.e("onFailure", t.printStackTrace().toString())
                    Snackbar.make(requireView(), "onFailure", Snackbar.LENGTH_LONG).show()

                }

            })


        }
        return binding.root
    }
}