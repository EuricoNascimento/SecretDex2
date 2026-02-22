package com.slazy.secretdex.presentation.pokemonlist

import android.graphics.Bitmap
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
import com.slazy.secretdex.domain.model.pokedex.PokedexEntryEntity
import com.slazy.secretdex.domain.repository.IPokemonRepository
import com.slazy.secretdex.util.BuildConfig.PAGE_SIZE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: IPokemonRepository
): ViewModel() {
    private var curPage: Int = 0
    private var endReached: Boolean = false
    private val _uiState = MutableStateFlow<PokemonListState>(PokemonListState.Loading(false))
    val uiState = _uiState.asStateFlow()
    private val _pokemonList = MutableStateFlow(mutableListOf<PokedexEntryEntity>())
    val pokemonList = _pokemonList.asStateFlow()
    private val pokedexNumberList: List<Int>
        get() = _pokemonList.value.map { it.number.toInt() }

    init {
        loadPokemonPaginated()
    }

    fun calcDominantColor(bitmap: Bitmap, onFinish: (Color) -> Unit) {
        Palette.from(bitmap).generate { palette ->
            palette?.dominantSwatch?.rgb?.let { colorValue ->
                onFinish(Color(colorValue))
            }
        }
    }

    fun loadPokemonPaginated() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value = PokemonListState.Loading(true)
            repository.getPokemonList(PAGE_SIZE, curPage * PAGE_SIZE)
                .collect { result ->
                    result.fold(
                        onSuccess = { data ->
                            endReached = curPage * PAGE_SIZE >= data.count
                            if (!endReached) {
                                curPage++
                                _uiState.value = PokemonListState.Loading(false)
                                val dataList = data.listEntity.toMutableList()
                                dataList.removeIf { pokedexNumberList.contains(it.number.toInt()) }
                                _pokemonList.value += dataList
                                _pokemonList.value.sortedBy { it.number }
                            }
                        },
                        onFailure = {
                            _uiState.value = PokemonListState.Error(it.message, false)
                        }
                    )
                }
        }
    }
}