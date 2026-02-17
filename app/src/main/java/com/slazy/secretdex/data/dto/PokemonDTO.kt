package com.slazy.secretdex.data.dto


import com.google.gson.annotations.SerializedName

data class PokemonDTO(
    @SerializedName("abilities")
    val abilities: List<AbilityDescriptionDTO>?,
    @SerializedName("base_experience")
    val baseExperience: Int?,
    @SerializedName("cries")
    val cries: CriesDTO?,
    @SerializedName("forms")
    val forms: List<FormDTO>?,
    @SerializedName("game_indices")
    val gameIndices: List<GameIndexDTO>?,
    @SerializedName("height")
    val height: Int?,
    @SerializedName("held_items")
    val heldItems: List<HeldItemDTO>?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("is_default")
    val isDefault: Boolean?,
    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("order")
    val order: Int?,
    @SerializedName("past_abilities")
    val pastAbilities: List<PastAbilityDTO>?,
    @SerializedName("past_stats")
    val pastStats: List<PastStatDTO>?,
    @SerializedName("past_types")
    val pastTypes: List<Any?>?,
    @SerializedName("species")
    val species: SpeciesDTO?,
    @SerializedName("sprites")
    val sprites: SpritesDTO?,
    @SerializedName("stats")
    val stats: List<StatDTO>?,
    @SerializedName("types")
    val types: List<TypeDTO>?,
    @SerializedName("weight")
    val weight: Int?
)