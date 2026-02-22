package com.slazy.secretdex.data.repository

import com.slazy.secretdex.data.network.PokemonApi
import com.slazy.secretdex.domain.mapper.toPokedexEntryEntity
import com.slazy.secretdex.domain.mapper.toPokedexListEntity
import com.slazy.secretdex.domain.repository.IPokemonRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Singleton

@Singleton
class PokemonRepositoryImpl(
    private val api: PokemonApi
): IPokemonRepository {
    override suspend fun getPokemonList(
        limit: Int,
        offset: Int
    ) = flow {
        try {
            val response = api.getPokemonList(offset, limit)
            val pokedexList = response.toPokedexListEntity()
            emit(Result.success(pokedexList))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    override suspend fun getPokemonInfo(name: String) = flow {
        try {
            val response = api.getPokemonByName(name)
            emit(Result.success(response))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}