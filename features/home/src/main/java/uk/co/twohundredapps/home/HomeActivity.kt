package uk.co.twohundredapps.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import uk.co.twohundredapps.home.presentation.ui.HomeScreen
import uk.co.twohundredapps.mymovieromance.ui.theme.MyMovieRomanceTheme

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMovieRomanceTheme {
                HomeScreen()
            }
        }
    }
}
