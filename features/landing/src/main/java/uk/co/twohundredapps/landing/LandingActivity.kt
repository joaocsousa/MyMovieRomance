package uk.co.twohundredapps.landing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import uk.co.twohundredapps.mymovieromance.ui.theme.MyMovieRomanceTheme

@AndroidEntryPoint
class LandingActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            MyMovieRomanceTheme() {
                Scaffold() {
                    NavigationComponent(navController)
                }
            }
        }
    }
}

@Composable
fun NavigationComponent(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController)
        }
        composable("details") {
            DetailScreen()
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Button(onClick = { navController.navigate("detail") }) {
        Text(text = "Go to detail")
    }
}

@Composable
fun DetailScreen() {
    Text(text = "Detail")
}
