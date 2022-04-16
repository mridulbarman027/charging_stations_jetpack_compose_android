package com.nearbuck.chargingstations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CityItem(city: CityModel) {
    Row(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            modifier = Modifier.weight(1f, true),
            text = "City: " +city.city,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        /*Text(
            modifier = Modifier.weight(1f, true),
            text = city.cityCharger.availability,
            color = Color.Black,
            fontWeight = FontWeight.Normal
        )
        Text(
            modifier = Modifier.weight(1f, true),
            text = city.cityCharger.type,
            color = Color.Black,
            fontWeight = FontWeight.Normal
        )*/
    }
}


@Composable
@Preview
fun CityItemPreview() {
    val array = ArrayList<CityChargerModel>()
    array.add(CityChargerModel("Free", "AC"))
    CityItem(
        city = CityModel("Delhi", array)
    )
}