package com.slazy.secretdex.data.dto


import com.google.gson.annotations.SerializedName

data class VersionDetailDTO(
    @SerializedName("rarity")
    val rarity: Int?,
    @SerializedName("version")
    val version: DefaultNameDTO
)