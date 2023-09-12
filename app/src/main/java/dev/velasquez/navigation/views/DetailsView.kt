package dev.velasquez.navigation.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.velasquez.navigation.components.MainButton
import dev.velasquez.navigation.components.MainIconButton
import dev.velasquez.navigation.components.Space
import dev.velasquez.navigation.components.TitleBar
import dev.velasquez.navigation.components.TitleView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsView(navController: NavController, id: String, optional: String?) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Details View") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Cyan
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) {
        ContentDetailsView(navController, id, optional)
    }
}

@Composable
fun ContentDetailsView(navController: NavController, id: String, optional: String?) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Details View")
        Space()
        TitleView(name = id)
        Space()
        if (optional==""){
            Spacer(modifier = Modifier.height(0.dp))
        }else{
            TitleView(name = optional.orEmpty())
        }
        MainButton(name = "Return Home", backColor = Color.Blue, color = Color.White) {
            navController.popBackStack()
        }
    }

}