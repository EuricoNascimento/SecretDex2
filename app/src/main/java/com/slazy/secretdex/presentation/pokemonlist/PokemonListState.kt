package com.slazy.secretdex.presentation.pokemonlist

sealed class PokemonListState {
    data class Loading(val isLoading: Boolean): PokemonListState()
    data class Error (val message: String?, val isLoading: Boolean): PokemonListState()
}