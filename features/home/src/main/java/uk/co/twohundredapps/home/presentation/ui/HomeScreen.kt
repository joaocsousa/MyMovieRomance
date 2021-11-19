package uk.co.twohundredapps.home.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.inject
import org.koin.androidx.compose.viewModel
import uk.co.twohundredapps.home.presentation.models.HomeScreenState
import uk.co.twohundredapps.home.presentation.models.HomeScreenState.Loaded
import uk.co.twohundredapps.home.presentation.models.MovieItem
import uk.co.twohundredapps.home.presentation.viewmodels.HomeViewModel
import uk.co.twohundredapps.logger.Logger
import uk.co.twohundredapps.mymovieromance.ui.theme.MyMovieRomanceTheme

@Composable
fun HomeScreen() {
    val logger by inject<Logger>()
    val homeViewModel by viewModel<HomeViewModel>()
    val state by homeViewModel.state.collectAsState()

    MyMovieRomanceTheme {
        when (state) {
            is HomeScreenState.Init -> {
                logger.d("INIT")
            }
            is HomeScreenState.Error -> {
                logger.d("ERROR")
            }
            is Loaded -> {
                logger.d("LOADED")
                MoviesList(
                    movies = (state as Loaded).items,
                    onSelected = {
                        homeViewModel.onMovieSelected(movie = it)
                    }
                )
            }
            is HomeScreenState.Loading -> {
                logger.d("LOADING")
            }
        }
    }
}

@Composable
private fun MoviesList(
    movies: List<MovieItem>,
    onSelected: (MovieItem) -> Unit
) {
    LazyColumn {
        items(movies) { movie ->
            MovieColumnItem(
                movieItem = movie,
            ) {
                onSelected(movie)
            }
        }
    }
}

@Composable
private fun MovieColumnItem(
    movieItem: MovieItem,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.clickable(onClick = onClick),
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = movieItem.title,
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    MyMovieRomanceTheme {
        HomeScreen()
    }
}

@Preview
@Composable
fun MoviesListPreview() {
    MyMovieRomanceTheme {
        MoviesList(
            movies = listOf(
                MovieItem(
                    title = "Some title 1",
                    url = ""
                ),
                MovieItem(
                    title = "Some title 2",
                    url = ""
                ),
                MovieItem(
                    title = "Some title 3",
                    url = ""
                ),
                MovieItem(
                    title = "Some title 4",
                    url = ""
                ),
                MovieItem(
                    title = "Some title 5",
                    url = ""
                ),
                MovieItem(
                    title = "Some title 6",
                    url = ""
                )
            ),
            onSelected = { }
        )
    }
}

@Preview
@Composable
fun MovieItemPreview() {
    MyMovieRomanceTheme {
        MovieColumnItem(
            movieItem = MovieItem(
                title = "Some Movie",
                url = ""
            ),
            onClick = { }
        )
    }
}