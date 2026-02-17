package com.slazy.secretdex.data.dto


import com.google.gson.annotations.SerializedName

data class StatDTO(
    @SerializedName("base_stat")
    val baseStat: Int?,
    @SerializedName("effort")
    val effort: Int?,
    @SerializedName("stat")
    val stat: DefaultNameDTO
)