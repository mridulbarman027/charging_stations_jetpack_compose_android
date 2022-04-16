package com.nearbuck.chargingstations

import com.google.gson.annotations.SerializedName

data class CityModel(
    @SerializedName("city") val city: String,
    @SerializedName("cityCharger") val cityCharger: ArrayList<CityChargerModel>,
)