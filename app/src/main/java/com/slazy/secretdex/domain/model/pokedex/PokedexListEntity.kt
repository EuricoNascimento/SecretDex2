package com.slazy.secretdex.domain.model.pokedex

data class PokedexListEntity(
    val count: Int,
    val listEntity: List<PokedexEntryEntity>
)