
package com.example.finalproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.network.Countries


import com.example.finalproject.network.CountriesApi
import com.example.finalproject.network.CountryDetail

import kotlinx.coroutines.launch

enum class CountriesApiStatus {LOADING, ERROR, DONE}

class CountriesViewModel : ViewModel() {


    private val _status = MutableLiveData<CountriesApiStatus>()
     val status : LiveData<CountriesApiStatus> = _status

    private val _countries = MutableLiveData<List<Countries>>()
    val countries : LiveData<List<Countries>> = _countries

    private val _country = MutableLiveData<Countries>()
    val country : LiveData<Countries> = _country

    fun getCountries() {
        viewModelScope.launch {
            _status.value = CountriesApiStatus.LOADING
            try{
                _countries.value = CountriesApi.retrofitService.getCountries()
                    _countries.value = CountriesApiStatus.DONE

            }   catch (e: Exception){
                _countries.value = CountriesApiStatus.ERROR
                _countries.value = listOf()
            }
        }
    }
// zdes to je nado posmotret
    fun onCountriesClicked(country: Countries) {

        _country.value = country


    }
}
