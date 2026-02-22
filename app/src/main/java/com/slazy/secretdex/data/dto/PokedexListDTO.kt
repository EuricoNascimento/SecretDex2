package com.slazy.secretdex.data.dto


import com.google.gson.annotations.SerializedName

data class PokedexListDTO(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val results: List<DefaultNameDTO>
)