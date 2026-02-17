package com.slazy.secretdex.data.dto


import com.google.gson.annotations.SerializedName

data class AbilityDescriptionDTO(
    @SerializedName("ability")
    val ability: DefaultNameDTO?,
    @SerializedName("is_hidden")
    val isHidden: Boolean,
    @SerializedName("slot")
    val slot: Int
)