package com.nearbuck.chargingstations

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.gson.Gson
import com.nearbuck.chargingstations.ui.theme.ChargingStationsTheme
import java.io.InputStream

private fun getJsonData(context: Context): String {
    // val context = LocalContext.current
    runCatching {
        val inputStream: InputStream = context.assets.open("data.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        String(buffer)
    }.onSuccess {
        return it
    }.onFailure {
        return "error"
    }
    return ""
}

@Composable
fun HomeView(
    navController: NavController
) {

    val jsonData: String = getJsonData(LocalContext.current)

    val objectList = Gson().fromJson(jsonData, CitiesList::class.java)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(androidx.compose.ui.graphics.Color.Gray)
                .padding(12.dp),
            text = "Cities List",
            color = androidx.compose.ui.graphics.Color.Green,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            objectList.citiesList.forEach { section: CityModel ->
                items(1) {
                    val jsonString = Gson().toJson(section)
                    Surface(modifier = Modifier.clickable {
                        navController.navigate(route = "city/${jsonString}")
                    }) {
                        CityItem(city = section)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeViewPreview() {
    ChargingStationsTheme {
        HomeView(navController = rememberNavController())
    }
}