package uk.co.twohundredapps.landing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import uk.co.twohundredapps.home.presentation.ui.HomeScreen
import uk.co.twohundredapps.mymovieromance.ui.theme.MyMovieRomanceTheme

@AndroidEntryPoint
class LandingActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            MyMovieRomanceTheme {
                Scaffold {
                    NavigationComponent(navController)
                }
            }
        }
    }
}

@Composable
fun NavigationComponent(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(hiltViewModel())
        }
        composable("details") {
            DetailScreen()
        }
    }
}

@Composable
fun DetailScreen() {
    Text(text = "Detail")
}

@Preview
@Composable
fun DetailsScreenPreview() {
    DetailScreen()
}
