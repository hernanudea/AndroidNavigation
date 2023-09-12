package dev.velasquez.navigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.velasquez.navigation.views.DetailsView
import dev.velasquez.navigation.views.HomeView

@Composable
fun NavManager() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") {
            HomeView(navController)
        }
        composable(
            "Details/{id}/?{optional}", arguments = listOf(
                navArgument("id") { type = NavType.StringType },
                navArgument("optional") { type = NavType.StringType },
            )
        ) {
            val id = it.arguments?.getString("id") ?: "0"
            val optional = it.arguments?.getString("optional") ?: ""
            DetailsView(navController, id, optional)
        }
    }
}
