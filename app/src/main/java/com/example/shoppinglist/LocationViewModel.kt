package com.example.shoppinglist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LocationViewModel : ViewModel() {

    private val _location = mutableStateOf<LocationData?>(null)
    val location = _location

    fun updateLocation(newLocation : LocationData){
        _location.value = newLocation
    }


}