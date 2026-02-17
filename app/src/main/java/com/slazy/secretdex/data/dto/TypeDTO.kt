package com.slazy.secretdex.data.dto


import com.google.gson.annotations.SerializedName

data class TypeDTO(
    @SerializedName("slot")
    val slot: Int?,
    @SerializedName("type")
    val type: DefaultNameDTO
)