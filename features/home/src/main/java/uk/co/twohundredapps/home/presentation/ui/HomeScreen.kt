package uk.co.twohundredapps.home.presentation.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer
import uk.co.twohundredapps.home.presentation.models.MovieItem
import uk.co.twohundredapps.home.presentation.viewmodels.HomeViewModel
import uk.co.twohundredapps.mymovieromance.ui.theme.MyMovieRomanceTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {

    val state = homeViewModel.state.collectAsLazyPagingItems()

    MyMovieRomanceTheme {
        HomeScreenRenderer(
            state = state,
            onSelected = {
                homeViewModel.onMovieSelected(movie = it)
            }
        )
    }
}

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
private fun HomeScreenRenderer(
    state: LazyPagingItems<MovieItem>,
    onSelected: (MovieItem) -> Unit,
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(count = 3),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(state.itemCount) { index ->
            MovieColumnItem(
                movieItem = state[index]!!,
                onClick = {
                    onSelected(state[index]!!)
                }
            )
        }
    }
}

@ExperimentalCoilApi
@Composable
private fun MovieColumnItem(
    movieItem: MovieItem,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .clickable { onClick() }
            .padding(4.dp),
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(ratio = (2.0f / 3))
        ) {

            val painter = rememberImagePainter(
                data = movieItem.posters.first().url,
                builder = {
                    size(OriginalSize)
                    crossfade(true)
                },
            )
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .placeholder(
                        visible = painter.state is ImagePainter.State.Loading,
                        highlight = PlaceholderHighlight.shimmer()
                    )
                    .fillMaxSize()
            )
            Box(
                modifier = Modifier.matchParentSize()
            ) {
                Box(modifier = Modifier
                    .fillMaxHeight(fraction = 0.5f)
                    .fillMaxWidth()
                    .align(alignment = Alignment.BottomCenter)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            )
                        )
                    )
                )
            }
            Text(
                text = movieItem.title,
                textAlign = TextAlign.Left,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.BottomStart),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.White
            )
        }
    }
}

@ExperimentalCoilApi
@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL)
@Composable
internal fun MovieItemPreview() {
    MyMovieRomanceTheme {
        MovieColumnItem(
            movieItem = MovieItem(
                title = "Last Night in Soho",
                posters = emptyList()
            ),
            onClick = { }
        )
    }
}
