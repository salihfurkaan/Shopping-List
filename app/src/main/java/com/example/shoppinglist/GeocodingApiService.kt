package com.example.shoppinglist

import retrofit2.http.GET
import retrofit2.http.Query



interface GeocodingApiService {

    @GET("maps/api/geocode/json")
    suspend fun getAddressFromCoordinates(
        @Query("latlng") latlng : String, // adds these queries to the URL
        @Query("key") apiKey : String
    ) : GeocodingResponse

}