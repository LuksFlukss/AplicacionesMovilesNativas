package com.luksfluks.flightsearch.ui.screens.search

import com.luksfluks.flightsearch.model.Airport
import com.luksfluks.flightsearch.model.Favorite

data class SearchUiState(
    val searchQuery: String = "",
    val selectedCode: String = "",
    val airportList: List<Airport> = emptyList(),
    val favoriteList: List<Favorite> = emptyList(),
)