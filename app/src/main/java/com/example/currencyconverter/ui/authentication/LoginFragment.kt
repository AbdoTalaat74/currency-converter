package com.example.currencyconverter.ui.authentication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.currencyconverter.api.UserAuthentication
import com.example.currencyconverter.models.User
import com.example.currencyconverter.ui.HomeActivity
import com.example.currencyconverter.R
import com.example.currencyconverter.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {

    private lateinit var email: String
    private lateinit var password: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        inflater.context.setTheme(R.style.Theme_CurrencyConverter)
        val binding = FragmentLoginBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.btnGoToRegister.setOnClickListener {
            this.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.btnLogin.setOnClickListener {

            email = binding.etEmail.text.toString()
            password = binding.etPassword.text.toString()

            val user = User(email, password, null)
            val call = UserAuthentication.retrofitUserService.login(user)

            call.enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful) {
                        Snackbar.make(
                            binding.loginLayout,
                            "Login Successfully",
                            Snackbar.LENGTH_LONG
                        ).show()
                        goToHomeActivity()

                    } else {
                        Snackbar.make(binding.loginLayout, "Login Failed", Snackbar.LENGTH_LONG)
                            .show()
                        Log.e("responseCode", response.code().toString())
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Snackbar.make(binding.loginLayout, "onFailure", Snackbar.LENGTH_LONG).show()
                    Log.e("responseCode", t.printStackTrace().toString())
                }

            })


        }

        return binding.root
    }

    private fun goToHomeActivity() {
        val intent = Intent(this.context, HomeActivity::class.java)
        startActivity(intent)
    }

}