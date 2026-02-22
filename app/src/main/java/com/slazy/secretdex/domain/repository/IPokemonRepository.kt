package com.slazy.secretdex.domain.repository

import com.slazy.secretdex.data.dto.PokemonDTO
import com.slazy.secretdex.domain.model.pokedex.PokedexListEntity
import kotlinx.coroutines.flow.Flow

interface IPokemonRepository {
    suspend fun getPokemonList(limit: Int, offset: Int): Flow<Result<PokedexListEntity>>

    suspend fun getPokemonInfo(name: String): Flow<Result<PokemonDTO>>
}