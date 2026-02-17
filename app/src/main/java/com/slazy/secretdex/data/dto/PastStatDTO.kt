package com.slazy.secretdex.data.dto


import com.google.gson.annotations.SerializedName

data class PastStatDTO(
    @SerializedName("generation")
    val generation: GenerationDTO?,
    @SerializedName("stats")
    val stats: List<StatDTO>?
)