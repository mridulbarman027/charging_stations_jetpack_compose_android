package com.nearbuck.chargingstations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.gson.Gson

@Composable
fun CityView(
    navController: NavController,
    cityData: String
) {

    val cityModel: CityModel = Gson().fromJson(cityData, CityModel::class.java)

    val cityCharger: ArrayList<CityChargerModel> = cityModel.cityCharger

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(Color.White)
        .padding(20.dp)) {
        Text(
            modifier = Modifier.fillMaxWidth().padding(4.dp, 10.dp),
            text = "${cityModel.city} charging stations",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()) {
            cityCharger.forEach { section ->
                items(1) {
                    CityChargingStationItems(cityCharger = section)
                }

            }
        }
    }
}

@Composable
@Preview
fun CityViewPreview() {
    val array = ArrayList<CityChargerModel>()
    array.add(CityChargerModel("Free", "AC"))
    //CityView(CityModel("Delhi", array))
    CityView(navController = rememberNavController(), "")
}