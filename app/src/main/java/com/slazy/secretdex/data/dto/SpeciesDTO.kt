package com.slazy.secretdex.data.dto


import com.google.gson.annotations.SerializedName

data class SpeciesDTO(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)