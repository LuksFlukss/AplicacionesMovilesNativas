package com.luksfluks.flightsearch.ui.screens.flight_screen

import com.luksfluks.flightsearch.model.Airport
import com.luksfluks.flightsearch.model.Favorite

data class FlightsUiState(
    val code: String = "",
    val favoriteList: List<Favorite> = emptyList(),
    val destinationList: List<Airport> = emptyList(),
    val departureAirport: Airport = Airport(),
)
