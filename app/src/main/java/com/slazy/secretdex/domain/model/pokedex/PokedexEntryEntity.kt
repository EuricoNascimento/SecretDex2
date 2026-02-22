package com.slazy.secretdex.domain.model.pokedex

data class PokedexEntryEntity(
    val pokemonName: String,
    val number: String
) {
    val imageUrl: String
        get() =  "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png"
}