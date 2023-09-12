package dev.velasquez.navigation.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import dev.velasquez.navigation.components.ActionButton
import dev.velasquez.navigation.components.MainButton
import dev.velasquez.navigation.components.Space
import dev.velasquez.navigation.components.TitleBar
import dev.velasquez.navigation.components.TitleView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { TitleBar(name = "Home View") },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Blue
            )
        )
    }, floatingActionButton = {
        ActionButton()
    }
    ) {
        ContentHomeView(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentHomeView(navController: NavController) {
    val id = "12345"
    var optional by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Home View")
        Space()
        TextField(
            value = optional,
            onValueChange = { optional = it },
            label = { Text(text = "Optional") })
        MainButton(name = "Detail View", backColor = Color.Blue, color = Color.White) {
            navController.navigate("Details/${id}/?${optional}")
        }
    }
}