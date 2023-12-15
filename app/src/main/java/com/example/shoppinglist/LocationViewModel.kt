package com.example.shoppinglist

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LocationViewModel : ViewModel() {

    private val _location = mutableStateOf<LocationData?>(null)
    val location = _location

    private val _address = mutableStateOf(listOf<GeocodingResult>())
    val address = _address

    fun updateLocation(newLocation : LocationData){
        _location.value = newLocation
    }

    fun fetchAddress(latlng : String, ){
        try{
            viewModelScope.launch {
                val result = RetrofitClient.create().getAddressFromCoordinates(
                    latlng,
                    "paste here your api key"
                )
                _address.value = result.results
            }
        }catch (e : Exception){
            Log.d("res1",  "${e.cause} ${e.message}")
        }
    }

}