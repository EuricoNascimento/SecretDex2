package com.slazy.secretdex.data.dto


import com.google.gson.annotations.SerializedName

data class PastAbilityDTO(
    @SerializedName("abilities")
    val abilities: List<AbilityDescriptionDTO>?,
    @SerializedName("generation")
    val generation: GenerationDTO?
)