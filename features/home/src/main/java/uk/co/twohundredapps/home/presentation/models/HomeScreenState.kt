package uk.co.twohundredapps.home.presentation.models

internal sealed class HomeScreenState {
    object Init : HomeScreenState()
    object Loading : HomeScreenState()
    object Error : HomeScreenState()
    data class Loaded(val items: List<MovieItem>) : HomeScreenState()
}