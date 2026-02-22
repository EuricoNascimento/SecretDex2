package com.slazy.secretdex.domain.mapper

import com.slazy.secretdex.data.dto.DefaultNameDTO
import com.slazy.secretdex.data.dto.PokedexListDTO
import com.slazy.secretdex.domain.model.pokedex.PokedexEntryEntity
import com.slazy.secretdex.domain.model.pokedex.PokedexListEntity

fun DefaultNameDTO.toPokedexEntryEntity(): PokedexEntryEntity {
    return PokedexEntryEntity(
        pokemonName = this.name,
        number = if (this.url.endsWith("/")) {
            this.url.dropLast(1).takeLastWhile { it.isDigit() }
        } else {
            this.url.takeLastWhile { it.isDigit() }
        }
    )
}

fun PokedexListDTO.toPokedexListEntity(): PokedexListEntity {
    return PokedexListEntity(
        count = this.count,
        listEntity = this.results.map { it.toPokedexEntryEntity() }
    )
}