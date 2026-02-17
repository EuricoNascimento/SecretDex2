package com.slazy.secretdex.domain.repository

import com.slazy.secretdex.data.dto.DefaultNameDTO
import com.slazy.secretdex.data.dto.PokemonDTO
import com.slazy.secretdex.data.dto.PokemonListDTO
import kotlinx.coroutines.flow.Flow

interface IPokemonRepository {
    suspend fun getPokemonList(limit: Int, offset: Int): Flow<Result<PokemonListDTO>>

    suspend fun getPokemonInfo(name: String): Flow<Result<PokemonDTO>>
}