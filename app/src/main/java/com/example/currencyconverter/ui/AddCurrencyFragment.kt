package com.example.currencyconverter.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.currencyconverter.api.CurrencyObject
import com.example.currencyconverter.databinding.FragmentAddCurrencyBinding
import com.example.currencyconverter.models.Currency
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddCurrencyFragment : Fragment() {

    private lateinit var binding: FragmentAddCurrencyBinding
    private lateinit var currency: Currency
    private lateinit var currencyName: String
    private lateinit var currencySign: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentAddCurrencyBinding.inflate(inflater)

        binding.addCurrency.setOnClickListener {
            currencyName = binding.currencyName.text.toString()
            currencySign = binding.currencySign.text.toString()
            val currencyValue:Float = binding.currencyValue.text.toString().toFloat()

            currency = Currency(null,currencyName,currencySign,currencyValue)

            val call: Call<Currency> = CurrencyObject.retrofitCurrencyService.addCurrency(currency)

            call.enqueue(object : Callback<Currency>{
                override fun onResponse(call: Call<Currency>, response: Response<Currency>) {
                    if (response.code() == 200){
                        Snackbar.make(binding.addCurrencyLayout,"Added Successfully",Snackbar.LENGTH_LONG).show()
                        Log.i("AddCurrencyFragment",response.body().toString())
                    }else{
                        Log.i("AddCurrencyFragment",response.body().toString())
                        Snackbar.make(binding.addCurrencyLayout,"Added Successfully",Snackbar.LENGTH_LONG).show()


                    }
                }

                override fun onFailure(call: Call<Currency>, t: Throwable) {
                    Log.i("AddCurrencyFragment","onFailure")
                    t.printStackTrace()
                }

            })

        }


        return binding.root
    }

}