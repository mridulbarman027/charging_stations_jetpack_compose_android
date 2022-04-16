package com.nearbuck.chargingstations

import com.google.gson.annotations.SerializedName

data class CitiesList (
    @SerializedName("cities") val citiesList: ArrayList<CityModel>,
)