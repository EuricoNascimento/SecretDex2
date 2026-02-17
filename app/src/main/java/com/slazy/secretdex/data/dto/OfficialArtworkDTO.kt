package com.slazy.secretdex.data.dto


import com.google.gson.annotations.SerializedName

data class OfficialArtworkDTO(
    @SerializedName("front_default")
    val frontDefault: String?,
    @SerializedName("front_shiny")
    val frontShiny: String?
)