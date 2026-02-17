package com.slazy.secretdex.data.network

import com.slazy.secretdex.data.dto.PokemonDTO
import com.slazy.secretdex.data.dto.PokemonListDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {
    @GET("pokemon/{name}")
    suspend fun getPokemonByName(@Path("name") name: String): PokemonDTO

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): PokemonListDTO
}