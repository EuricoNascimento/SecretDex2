package com.slazy.secretdex.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.slazy.secretdex.presentation.pokemonlist.PokemonListScreen
import com.slazy.secretdex.presentation.pokemonlist.PokemonListViewModel
import kotlinx.serialization.Serializable


@Serializable object PokemonListRoute
@Serializable data class PokemonRoute(val name: String, val dominantColor: Int)

@Composable
fun Router() {
    val navController = rememberNavController()

    Scaffold()
    { padding ->
        NavHostContainer(navController = navController, padding = padding)
    }
}

@Composable
fun NavHostContainer(navController: NavHostController, padding: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = PokemonListRoute,
        modifier = Modifier.padding(paddingValues = padding),
        builder = {
            composable(PokemonListRoute::class) {
                val viewModel: PokemonListViewModel = hiltViewModel()
                val pokemonList by viewModel.pokemonList.collectAsStateWithLifecycle()
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                PokemonListScreen(
                    navController = navController,
                    pokemonList =  pokemonList,
                    onColorCallback = viewModel::calcDominantColor,
                    uiState = uiState,
                    onLoadingPage = viewModel::loadPokemonPaginated
                )
            }
            composable(PokemonRoute::class) {
                val pokemonRoute = it.toRoute<PokemonRoute>()

            }
        }
    )
}